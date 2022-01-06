package com.br.glauber.apigoldenraspberry.repository;

import com.br.glauber.apigoldenraspberry.model.WinnerData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WinnerDataRepository extends CrudRepository<WinnerData, Long> {

}
