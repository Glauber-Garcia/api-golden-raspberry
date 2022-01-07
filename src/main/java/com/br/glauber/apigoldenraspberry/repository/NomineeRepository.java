package com.br.glauber.apigoldenraspberry.repository;

import com.br.glauber.apigoldenraspberry.model.Nominee;
import com.br.glauber.apigoldenraspberry.model.NomineeAux;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NomineeRepository extends CrudRepository<Nominee, Long> {
    List<Nominee> findAllByWinnerTrueOrderByProducers();
}
