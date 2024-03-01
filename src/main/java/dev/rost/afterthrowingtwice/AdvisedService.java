package dev.rost.afterthrowingtwice;

import org.springframework.stereotype.Service;

@Service
public class AdvisedService {

    void doSomething() {
        throw new RuntimeException();
    }
}
