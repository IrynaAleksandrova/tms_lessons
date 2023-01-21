package org.example.abstract_method;

public class BMWAbstractFactoryImpl implements AbstractFactory {
    @Override
    public EngineService getEngineService() {
        return new BMWEngineServiceImpl();
    }

    @Override
    public BodyService getBodyService() {
        return new BMWBodyServiceImpl();
    }

    @Override
    public WheelService getWheelService() {
        return new BMWWheelServiceImpl();
    }
}
