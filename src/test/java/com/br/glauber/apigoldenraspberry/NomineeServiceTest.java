package com.br.glauber.apigoldenraspberry;

import com.br.glauber.apigoldenraspberry.model.Nominee;
import com.br.glauber.apigoldenraspberry.repository.NomineeRepository;
import com.br.glauber.apigoldenraspberry.service.NomineeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

@RunWith(SpringRunner.class)
public class NomineeServiceTest {
    @TestConfiguration
    static class NomineeServiceTestConfiguration {
        @Bean
        public NomineeService nomineeService() {
            return new NomineeService();
        }
    }

    @Autowired
    NomineeService nomineeService;
    @MockBean
    NomineeRepository nomineeRepository;

    @Test
    public void nomineeServiceTestAll() throws IOException {
        List<Nominee> list = nomineeService.getAllNominees();
        String sList = list.toString();
        String sData = getListNominee().toString();
        Assertions.assertEquals(sList, sData);
    }

    @Test
    public void nomineeServiceTestAllWinner() throws IOException {
        List<Nominee> list = nomineeService.getAlLWinnerNominees();
        String sList = list.toString();
        String sData = getListNomineeWinner().toString();
        Assertions.assertEquals(sList, sData);
    }

    private List<Nominee> getListNomineeWinner() throws IOException {
        List<Nominee> list = new ArrayList<>();
        for (Nominee n : getListNominee()) {
            if (n.getWinner()) {
                list.add(n);
            }
        }
        return list;
    }


    private List<Nominee> getListNominee() throws IOException {
        List<Nominee> list = new ArrayList<>();
        String line = "";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("src/main/resources/movielist.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while ((line = br.readLine()) != null) {
            if (!line.startsWith("year;title;studios;producers;winner")) {
                String[] data = line.split(";");
                Nominee dt = new Nominee();
                dt.setYear(Long.parseLong(data[0]));
                dt.setTitle(data[1]);
                dt.setStudios(data[2]);
                dt.setProducers(data[3]);
                if (data.length > 4) {
                    dt.setWinner(true);
                } else {
                    dt.setWinner(false);
                }

                list.add(dt);
            }
        }
        return list;
    }

    @Before
    public void setup() throws IOException {
        List<Nominee> list = getListNominee();
        List<Nominee> listWinner = getListNomineeWinner();
        Mockito.when(nomineeRepository.findAll()).thenReturn(list);
        Mockito.when(nomineeRepository.findAllByWinnerTrue()).thenReturn(listWinner);
    }
}
