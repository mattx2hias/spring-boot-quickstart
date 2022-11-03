package com.mattmatthias.quickstart.repositoryTest;

import com.mattmatthias.quickstart.entity.Dummy;
import com.mattmatthias.quickstart.repository.DummyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.time.Instant;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class DummyRepositoryTest {
    @Autowired
    private DummyRepository dummyRepository;
    Dummy testDummy = new Dummy(0, "Bob", Instant.EPOCH.getEpochSecond());

    @DisplayName("Injected repository components are not null")
    @Test
    void injectedComponentsAreNotNull() {
        Assertions.assertNotNull(dummyRepository);
    }

    @DisplayName("Newly created Dummy exists by id")
    @Test
    void savedDummyExistsById() {
        dummyRepository.save(testDummy);
        Assertions.assertNotNull(dummyRepository.getReferenceById(testDummy.getId()));
    }

}
