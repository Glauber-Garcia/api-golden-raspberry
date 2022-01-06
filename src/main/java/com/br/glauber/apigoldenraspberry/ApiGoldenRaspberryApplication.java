package com.br.glauber.apigoldenraspberry;

import com.br.glauber.apigoldenraspberry.service.WinnerDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiGoldenRaspberryApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiGoldenRaspberryApplication.class, args);
        WinnerDataService winnerDataService = new WinnerDataService();
        winnerDataService.savWinnerData();
    }

}
