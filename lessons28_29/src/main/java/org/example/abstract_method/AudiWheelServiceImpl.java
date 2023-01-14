package org.example.abstract_method;

public class AudiWheelServiceImpl implements WheelService {
    @Override
    public Wheel createWheel() {
        return new Wheel("Audi wheel");
    }
}
