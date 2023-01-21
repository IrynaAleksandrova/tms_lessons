package org.example.abstract_method;

public class LadaBodyServiceImpl implements BodyService {
    @Override
    public Body createBody() {
        return new Body("Lada body");
    }
}
