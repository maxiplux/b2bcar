package com.b2b.cart.repository;


import com.b2b.cart.models.workflow.WorkFlow;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WorkFlowRepository extends MongoRepository<WorkFlow, String> {
    //http://www.technicalkeeda.com/spring-tutorials/spring-4-mongodb-repository-example

}