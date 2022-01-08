package com.br.glauber.apigoldenraspberry.repository;

import com.br.glauber.apigoldenraspberry.model.Nominee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NomineeRepository extends CrudRepository<Nominee, Long> {
    List<Nominee> findAllByWinnerTrue();
}
