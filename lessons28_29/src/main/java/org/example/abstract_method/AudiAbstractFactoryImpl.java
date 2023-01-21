package org.example.abstract_method;

public class AudiAbstractFactoryImpl implements AbstractFactory {
    @Override
    public EngineService getEngineService() {
        return new AudiEngineServiceImpl();
    }

    @Override
    public BodyService getBodyService() {
        return new BMWBodyServiceImpl();
    }

    @Override
    public WheelService getWheelService() {
        return new AudiWheelServiceImpl();
    }
}
