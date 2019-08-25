package com.b2b.cart.services.impl;

import com.b2b.cart.models.corporate.Holding;
import com.b2b.cart.repository.HoldingRepository;
import com.b2b.cart.services.HoldingServices;
import com.b2b.cart.services.generics.CrudServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Service
public class HoldingServicesImpl extends CrudServicesImpl<Holding> implements HoldingServices<Holding> {
    @Autowired
    private HoldingRepository holdingRepository;

    @PostConstruct
    public  void posContructor() {
        this.setRepository( holdingRepository);
    }

    public Optional<Holding> UpdateById(long id, Holding element) {
        Optional<Holding> optionalCurrent = this.repository.findById(id);
        if (optionalCurrent.isPresent()) {
            Holding currentOnDb = optionalCurrent.get();

            if (element.getName() != null) {
                currentOnDb.setName(element.getName());
            }

            if (element.getMananger() != null) {
                currentOnDb.setMananger(element.getMananger());
            }
            return Optional.of((Holding) this.repository.save(currentOnDb));
        }
        return Optional.empty();

    }


}
