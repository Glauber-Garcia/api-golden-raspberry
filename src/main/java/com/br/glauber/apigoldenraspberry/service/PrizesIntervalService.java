package com.br.glauber.apigoldenraspberry.service;

import com.br.glauber.apigoldenraspberry.model.PrizesInterval;
import com.br.glauber.apigoldenraspberry.model.PrizesIntervalData;
import com.br.glauber.apigoldenraspberry.model.Winner;
import com.br.glauber.apigoldenraspberry.repository.WinnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrizesIntervalService {
    @Autowired
    private WinnerRepository wr;
    public PrizesInterval getPrizesInterval(){
      return null;

    }

}
