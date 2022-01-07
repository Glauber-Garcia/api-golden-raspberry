package com.br.glauber.apigoldenraspberry.controller;

import com.br.glauber.apigoldenraspberry.model.PrizesInterval;
import com.br.glauber.apigoldenraspberry.service.PrizesIntervalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/prizes")
public class PrizesIntervalController {
    @Autowired
    private PrizesIntervalService service;
    @GetMapping(value = "/interval")
    private PrizesInterval getPrizeInterval(){
        return service.getPrizesInterval();
    }
    @GetMapping(value = "/test")
    private String teste(){
        return "Teste - OK";
    }
}
