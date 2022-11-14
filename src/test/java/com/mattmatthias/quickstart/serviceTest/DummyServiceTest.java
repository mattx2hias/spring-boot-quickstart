package com.mattmatthias.quickstart.serviceTest;

import com.mattmatthias.quickstart.entity.Dummy;
import com.mattmatthias.quickstart.exception.DummyDoesNotExist;
import com.mattmatthias.quickstart.exception.DummyInputInvalidException;
import com.mattmatthias.quickstart.repository.DummyRepository;
import com.mattmatthias.quickstart.service.DummyService;
import com.mattmatthias.quickstart.service.DummyServiceImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class DummyServiceTest {
    @Mock
    DummyRepository dummyRepository;

    @InjectMocks
    DummyServiceImpl dummyService;

    @DisplayName("Injected Service Components Are Not Null")
    @Test
    void injectedComponentsAreNotNull() {
        assertNotNull(dummyService);
    }

    @DisplayName("Create New Dummy")
    @Test
    void createNewDummy() throws DummyInputInvalidException {
        Dummy newDummy = new Dummy(1, "Hank");
        Dummy savedDummy = dummyService.registerNewDummy(newDummy);
        assertNotNull(savedDummy);
    }

    @DisplayName("Invalid Dummy name throws DummyInputInvalidException")
    @Test
    void invalidDummyNameThrowsException() {
        assertThrows(DummyInputInvalidException.class, () -> {
            Dummy newDummy = new Dummy("Ahhhhhhhhhhhhhhhhhhh");
            dummyService.registerNewDummy(newDummy);
        });
    }

    @DisplayName("throws DummyDoesNotExistException")
    @Test
    void dummyDoesNotExistThrowsException() {
        assertThrows(DummyDoesNotExist.class, () -> {
            dummyService.updateDummy(new Dummy(20, "Jess"));
        });
    }

    @DisplayName("Delete Dummy")
    @Test
    void deleteDummy() {
        dummyService.deleteDummyById(1);
        verify(dummyRepository, times(1)).deleteById(1);
    }

}
