package com.br.glauber.apigoldenraspberry.controller;

import com.br.glauber.apigoldenraspberry.model.PrizesInterval;
import com.br.glauber.apigoldenraspberry.service.PrizesIntervalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/prizes")
@Api(value = "Prizes Interval Controller", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"prizes-interval-controller"}, description = "Controlador dos intervalos das premiações")
public class PrizesIntervalController {
    @Autowired
    private PrizesIntervalService service;

    @ApiOperation(value = "Retorna os produtores com o menor e o maior intervalo de vezes que ganhou o prêmio")
    @RequestMapping(value = "/interval",
            method = RequestMethod.GET)
    private PrizesInterval getPrizeInterval() {
        return service.getPrizesInterval();
    }
}
