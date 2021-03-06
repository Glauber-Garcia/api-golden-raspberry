package com.br.glauber.apigoldenraspberry;

import com.br.glauber.apigoldenraspberry.service.NomineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class ApiGoldenRaspberryApplication {
    @Autowired
    private NomineeService winnerDataService;
    public static void main(String[] args) {
        SpringApplication.run(ApiGoldenRaspberryApplication.class, args);
    }
    @EventListener(ApplicationReadyEvent.class)
    public void doAfterStartup() {
        winnerDataService.savWinnerData();
    }
}
