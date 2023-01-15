package org.example.abstract_method;

public class BMWWheelServiceImpl implements WheelService {
    @Override
    public Wheel createWheel() {
        return new Wheel("BMW wheel");
    }
}
