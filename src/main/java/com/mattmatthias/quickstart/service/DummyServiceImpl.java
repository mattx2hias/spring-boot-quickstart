package com.mattmatthias.quickstart.service;

import com.mattmatthias.quickstart.entity.Dummy;
import com.mattmatthias.quickstart.repository.DummyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class DummyServiceImpl implements DummyService {

    @Autowired private DummyRepository dummyRepository;
    @Override
    public Dummy registerNewDummy(Dummy newDummy) {
        newDummy.setCreationDate(Instant.EPOCH.getEpochSecond());
        return dummyRepository.save(newDummy);
    }

    @Override
    public Dummy updateDummy(Dummy dummy) {
        Dummy dummyToUpdate = dummyRepository.getReferenceById(dummy.getId());
        return null;
    }

    @Override
    public void deleteDummyById(int id) {
        dummyRepository.deleteById(id);
    }
}
