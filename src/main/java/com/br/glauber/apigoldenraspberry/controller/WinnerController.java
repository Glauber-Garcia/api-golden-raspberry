package com.br.glauber.apigoldenraspberry.controller;

import com.br.glauber.apigoldenraspberry.model.Nominee;
import com.br.glauber.apigoldenraspberry.service.NomineeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/winner")
@Api(value = "Winner Controller", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"winner-controller"}, description = "Controlador dos ganhadores do prêmio")
public class WinnerController {
    @Autowired
    private NomineeService service;

    @ApiOperation(value = "Retorna os ganhadores do prêmio")
    @RequestMapping(value = "/all",
            method = RequestMethod.GET)
    private List<Nominee> getPrizeInterval() {
        return service.getAlLWinnerNominees();
    }
}
