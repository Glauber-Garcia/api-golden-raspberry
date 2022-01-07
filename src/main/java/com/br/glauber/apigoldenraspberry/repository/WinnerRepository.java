package com.br.glauber.apigoldenraspberry.repository;

import com.br.glauber.apigoldenraspberry.model.Winner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WinnerRepository extends CrudRepository<Winner, Long> {

}
