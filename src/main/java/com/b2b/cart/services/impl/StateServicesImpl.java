package com.b2b.cart.services.impl;

import com.b2b.cart.models.rules.State;
import com.b2b.cart.repository.StateRepository;
import com.b2b.cart.services.StateServices;
import com.b2b.cart.services.generics.CrudServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Service
public class StateServicesImpl extends CrudServicesImpl<State> implements StateServices<State> {

    @Autowired
    private StateRepository stateRepository;



    @PostConstruct
    private void postConstruct() {
      this.repository=stateRepository;
    }


    public Optional<State> UpdateById(long id, State element) {
        Optional<State> optionalCurrentCompany = this.repository.findById(id);
        if (optionalCurrentCompany.isPresent()) {
            State currentProduct = optionalCurrentCompany.get();

            if (element.getName() != null) {
                currentProduct.setName(element.getName());
            }

            if (element.getSequence() != null) {
                currentProduct.setSequence(element.getSequence());
            }

            if (element.getSendEmilToAdmin() != null) {
                currentProduct.setSendEmilToAdmin(element.getSendEmilToAdmin());
            }

            if (element.getSendEmilToClient() != null) {
                currentProduct.setSendEmilToClient(element.getSendEmilToClient());
            }

            if (element.getSendEmilToStaff() != null) {
                currentProduct.setSendEmilToStaff(element.getSendEmilToStaff());
            }


            if (element.getNextStates() != null) {
                currentProduct.setNextStates(element.getNextStates());
            }

            return Optional.of((State) this.repository.save(currentProduct));
        }
        return Optional.empty();

    }


}
