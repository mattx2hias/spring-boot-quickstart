package com.mattmatthias.quickstart.serviceTest;

import com.mattmatthias.quickstart.entity.Dummy;
import com.mattmatthias.quickstart.service.DummyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@ActiveProfiles({})
public class DummyServiceTest {
    @Autowired
    DummyService dummyService;

    @DisplayName("Injected Service Components Are Not Null")
    @Test
    void injectedComponentsAreNotNull() {
        Assertions.assertNotNull(dummyService);
        assertThat(dummyService).isNotNull();
    }

    @DisplayName("Create New Dummy")
    @Test
    void createNewDummy() {
        Dummy newDummy = new Dummy("Hank");
        dummyService.registerNewDummy(newDummy);
        assertThat(newDummy).isNotNull();
    }

}
