package org.example.abstract_method;

public class BMWBodyServiceImpl implements BodyService {
    @Override
    public Body createBody() {
        return new Body("BMW body");
    }
}
