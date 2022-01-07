package com.br.glauber.apigoldenraspberry.service;

import com.br.glauber.apigoldenraspberry.model.Winner;
import com.br.glauber.apigoldenraspberry.repository.WinnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class WinnerService {
    private static final Logger LOGGER = Logger.getLogger(WinnerService.class.getName());
    @Autowired
    private WinnerRepository repository;
    String line = "";
    public void savWinnerData(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/movielist.csv"));
            while((line = br.readLine()) != null){
                if( !line.startsWith("year;title;studios;producers;winner")) {
                    String[] data = line.split(";");
                    Winner dt = new Winner();
                    dt.setYear(Long.parseLong(data[0]));
                    dt.setTitle(data[1]);
                    dt.setStudios(data[2]);
                    dt.setProducers(data[3]);
                    if( data.length > 4 ){
                        dt.setWinner(true);
                    }else{
                        dt.setWinner(false);
                    }

                    LOGGER.log(Level.INFO, "Criado o objeto " + dt.toString());
                    repository.save(dt);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
