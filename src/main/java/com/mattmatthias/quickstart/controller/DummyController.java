package com.mattmatthias.quickstart.controller;

import com.mattmatthias.quickstart.entity.Dummy;
import com.mattmatthias.quickstart.service.DummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyController {

    @Autowired
    private DummyService dummyService;

    @GetMapping("/")
    String landingPage() {
        return "yo";
    }

    @PostMapping("/dummy/register")
    Dummy register(@RequestBody Dummy newDummy) {
        return this.dummyService.registerNewDummy(newDummy);
    }
}
