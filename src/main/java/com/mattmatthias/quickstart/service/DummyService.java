package com.mattmatthias.quickstart.service;

import com.mattmatthias.quickstart.entity.Dummy;
import org.springframework.stereotype.Service;

public interface DummyService {
    Dummy registerNewDummy(Dummy newDummy);

    Dummy updateDummy(Dummy dummy);

    void deleteDummyById(int id);
}
