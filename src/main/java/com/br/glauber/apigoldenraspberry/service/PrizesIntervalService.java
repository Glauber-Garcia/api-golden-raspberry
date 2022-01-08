package com.br.glauber.apigoldenraspberry.service;

import com.br.glauber.apigoldenraspberry.model.NomineeDTO;
import com.br.glauber.apigoldenraspberry.model.PrizesInterval;
import com.br.glauber.apigoldenraspberry.model.Nominee;
import com.br.glauber.apigoldenraspberry.model.PrizesIntervalData;
import com.br.glauber.apigoldenraspberry.repository.NomineeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class PrizesIntervalService {
    private static final Logger LOGGER = Logger.getLogger(PrizesIntervalService.class.getName());
    @Autowired
    private NomineeRepository wr;

    public PrizesInterval getPrizesInterval() {
        PrizesInterval p = new PrizesInterval();
        List<Nominee> list = wr.findAllByWinnerTrue();
        //entra na função que separa os produtores
        List<Nominee> listFinal = getProducersSeparated(list);
        //entra na função que pega os vencedores com mais de um premio
        List<Nominee> doubleWinners = getDoubleWinners(listFinal);
        List<PrizesIntervalData> listPrizesData = new ArrayList<>();
        List<String> ls = new ArrayList<>();
        for (Nominee nm : doubleWinners){
            ls.add(nm.getProducers());
        }
        Set<String> set = new HashSet<>(ls);
        ls.clear();
        ls.addAll(set);
        for (String dN : ls) {
            Long previousWin = 0L;
            Long follwingWin = 0L;
            for (Nominee n : doubleWinners) {
                if (n.getProducers().equals(dN)) {
                    if (previousWin == 0) {
                        previousWin = n.getYear();
                    } else {
                        if (n.getYear() < previousWin) {
                            follwingWin = previousWin;
                            previousWin = n.getYear();
                        } else {
                            if (follwingWin == 0) {
                                follwingWin = n.getYear();
                            } else {
                                previousWin = follwingWin;
                                follwingWin = n.getYear();
                            }
                        }
                    }
                }
            }
            //CRIA O OBJETO DATA PARA PODER CRIAR UMA LISTA E DEPOIS PREENCHELA CORRETAMENTE PARA PODER INSERIR NO RETORNO DA API
            PrizesIntervalData pd = new PrizesIntervalData();
            pd.setProducer(dN);
            pd.setPreviousWin(previousWin);
            pd.setFollowingWin(follwingWin);
            pd.setInterval(follwingWin - previousWin);
            listPrizesData.add(pd);
        }

        p.setMin(listPrizesData);
        p.setMax(listPrizesData);
        return p;

    }

    private List<Nominee> getDoubleWinners(List<Nominee> listNominee) {
        //cria um lista para preencher com quem venceu mais de uma vez
        List<Nominee> nomeProducers = new ArrayList<>();
        //passa por essa lista para poder pegar o nome do produtor
        for (Nominee n : listNominee) {
            //zera o contador de vitorias para poder calcular
            int nroVictory = 0;
            //passa pela lista de nominados para verificar se ele tem mais de uma vitoria
            for (Nominee n1 : listNominee) {
                //se ele for o nominado que esta no primeiro loop, ele adiociona mais 1 a vitoria
                if (n1.getProducers().equals(n.getProducers())) {
                    nroVictory += 1;
                }
            }
            //se o numero de vitorias for maior que 1 ele adiciona na lista final;
            if (nroVictory != 1) {
                nomeProducers.add(n);
            }
        }
        return nomeProducers;
    }


    private List<Nominee> getProducersSeparated(List<Nominee> producers) {
        List<Nominee> list = new ArrayList<>();
        for (Nominee n : producers) {
            if (n.getProducers().contains("and") || n.getProducers().contains(",")) {
                n.setProducers(n.getProducers().replaceAll(" and ", "-"));
                n.setProducers(n.getProducers().replaceAll(", ", "-"));
                String[] arr = n.getProducers().split("-");
                for (int i = 0; i < arr.length; i++) {
                    Nominee newNominee = new Nominee();
                    newNominee.setProducers(arr[i]);
                    newNominee.setWinner(true);
                    newNominee.setStudios(n.getStudios());
                    newNominee.setTitle(n.getTitle());
                    newNominee.setYear(n.getYear());
                    LOGGER.log(Level.INFO, newNominee.toString());
                    list.add(newNominee);
                }
            } else {
                list.add(n);
            }
        }
        return list;
    }
}
