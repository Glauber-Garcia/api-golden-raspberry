package com.br.glauber.apigoldenraspberry;

import com.br.glauber.apigoldenraspberry.model.Nominee;
import com.br.glauber.apigoldenraspberry.model.PrizesInterval;
import com.br.glauber.apigoldenraspberry.model.PrizesIntervalData;
import com.br.glauber.apigoldenraspberry.repository.NomineeRepository;
import com.br.glauber.apigoldenraspberry.service.NomineeService;
import com.br.glauber.apigoldenraspberry.service.PrizesIntervalService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

@RunWith(SpringRunner.class)
public class PrizesIntervalServiceTest {
    @TestConfiguration
    static class PrizesIntervalServiceTestConfiguration {
        @Bean
        public PrizesIntervalService prizesIntervalService() {
            return new PrizesIntervalService();
        }
        @Bean
        public ObjectMapper objectMapper() {
            return new ObjectMapper();
        }
    }

    @Autowired
    PrizesIntervalService prizesIntervalService;
    @MockBean
    NomineeRepository nomineeRepository;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void getPrizesInterval() throws JsonProcessingException {
        PrizesInterval p =  prizesIntervalService.getPrizesInterval();
        String jsonP = objectMapper.writeValueAsString(p);
        Assertions.assertEquals(jsonP, getPrizesIntervalMock());
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

    private String getPrizesIntervalMock() throws JsonProcessingException {
        String json = "{\"min\":[{\"producer\":\"Joel Silver\",\"interval\":1,\"previousWin\":1990,\"followingWin\":1991}],\"max\":[{\"producer\":\"Matthew Vaughn\",\"interval\":13,\"previousWin\":2002,\"followingWin\":2015},{\"producer\":\"Matthew Vaughn\",\"interval\":13,\"previousWin\":2015,\"followingWin\":2028}]}";
      return json;
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
