package com.br.glauber.apigoldenraspberry.service;

import com.br.glauber.apigoldenraspberry.model.WinnerData;
import com.br.glauber.apigoldenraspberry.repository.WinnerDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class WinnerDataService {
    private static final Logger LOGGER = Logger.getLogger(WinnerDataService.class.getName());
    @Autowired
    private WinnerDataRepository repository;
    String line = "";
    public void savWinnerData(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/movielist.csv"));
            while(line == String.valueOf(br.readLine() != null)){
                String[] data = line.split(",");
                WinnerData dt = new WinnerData();
                dt.setYear(Long.parseLong(data[0]));
                dt.setTitle(data[1]);
                dt.setStudios(data[2]);
                dt.setProducers(data[3]);
                dt.setWinner(Boolean.parseBoolean(data[4]));
                LOGGER.log(Level.INFO, "Criado o objeto "+ dt.toString());
                repository.save(dt);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
