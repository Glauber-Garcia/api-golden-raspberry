package com.br.glauber.apigoldenraspberry.service;

import com.br.glauber.apigoldenraspberry.model.PrizesInterval;
import com.br.glauber.apigoldenraspberry.model.Nominee;
import com.br.glauber.apigoldenraspberry.repository.NomineeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrizesIntervalService {
    @Autowired
    private NomineeRepository wr;

    public PrizesInterval getPrizesInterval() {
        List<Nominee> list = wr.findAllByWinnerTrueOrderByProducers();
        List<Nominee> doubleWinners = getDoubleWinners(list);

        return null;

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
            if (nroVictory > 1) {
                nomeProducers.add(n);
            }
        }
        return nomeProducers;
    }

}
