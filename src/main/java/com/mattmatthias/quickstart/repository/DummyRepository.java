package com.mattmatthias.quickstart.repository;

import com.mattmatthias.quickstart.entity.Dummy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface DummyRepository extends JpaRepository<Dummy, Integer> {

}
