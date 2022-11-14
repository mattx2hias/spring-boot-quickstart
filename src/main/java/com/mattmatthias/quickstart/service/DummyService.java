package com.mattmatthias.quickstart.service;

import com.mattmatthias.quickstart.entity.Dummy;
import com.mattmatthias.quickstart.exception.DummyInputInvalidException;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface DummyService {

    Optional<Dummy> findById(int id);

    Dummy registerNewDummy(Dummy newDummy) throws DummyInputInvalidException;

    void updateDummy(Dummy dummy);

    void deleteDummyById(int id);
}
