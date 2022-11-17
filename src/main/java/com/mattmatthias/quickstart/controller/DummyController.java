package com.mattmatthias.quickstart.controller;

import com.mattmatthias.quickstart.entity.Dummy;
import com.mattmatthias.quickstart.exception.DummyInputInvalidException;
import com.mattmatthias.quickstart.service.DummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class DummyController {

    @Autowired
    private DummyService dummyService;

    @GetMapping("/")
    public String landingPage() {
        return "yo";
    }

    @GetMapping("/mysocialsecuritynumber")
    String landingPage2() {
        return "nice try";
    }

    @PostMapping("/dummy/register")
    Dummy register(@RequestBody Dummy newDummy) throws DummyInputInvalidException {
        return this.dummyService.registerNewDummy(newDummy);
    }

}
