package com.mattmatthias.quickstart.aspect;

import com.mattmatthias.quickstart.entity.Dummy;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class DummyAspect {

    @Before("execution(* com.mattmatthias.quickstart.service.*.*(..))")
    public void before() {
        System.out.println("before service methods");
    }

    @AfterReturning(value = "execution(* com.mattmatthias.quickstart.repository.DummyRepository.save(..))", returning = "dummy")
    public void logNewDummy(Dummy dummy) throws Throwable{
        System.out.println("new dummy created: " + dummy.getId());
    }
    @After(value = "execution(* com.mattmatthias.quickstart.service.DummyService.deleteDummyById(..))")
    public void logDeleteDummy() {
        System.out.println("dummy deleted: ");
    }

    @AfterThrowing("execution(* com.mattmatthias.quickstart.exception.DummyInputInvalidException.*(..))")
    public void invalidDummyInputAdvice() {
        System.out.println("invalid Dummy input");
    }

}
