package org.example.abstract_method;

public interface AbstractFactory {

    EngineService getEngineService();

    BodyService getBodyService();

    WheelService getWheelService();

}
