package com.mattmatthias.quickstart.service;

import com.mattmatthias.quickstart.entity.Dummy;
import com.mattmatthias.quickstart.exception.DummyDoesNotExist;
import com.mattmatthias.quickstart.exception.DummyInputInvalidException;
import com.mattmatthias.quickstart.repository.DummyRepository;
import com.mattmatthias.quickstart.utility.DummyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class DummyServiceImpl implements DummyService {

    @Autowired
    private DummyRepository dummyRepository;

    @Override
    public Optional<Dummy> findById(int id) {
        return dummyRepository.findById(id);
    }

    @Override
    public Dummy registerNewDummy(Dummy newDummy) throws DummyInputInvalidException {
        newDummy.setCreationDate(Instant.EPOCH.getEpochSecond());
        if(DummyUtil.validDummyName(newDummy.getName())) {
            dummyRepository.save(newDummy);
            return newDummy;
        } else {
            throw new DummyInputInvalidException();
        }
    }

    @Override
    public void updateDummy(Dummy dummy) {
        if(dummyRepository.existsById(dummy.getId())) {
            dummyRepository.save(dummy);
        } else {
            throw new DummyDoesNotExist();
        }
    }

    @Override
    public void deleteDummyById(int id) {
        dummyRepository.deleteById(id);
    }
}
