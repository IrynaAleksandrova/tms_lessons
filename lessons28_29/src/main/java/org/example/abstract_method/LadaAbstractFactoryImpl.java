package org.example.abstract_method;

public class LadaAbstractFactoryImpl implements AbstractFactory {
    @Override
    public EngineService getEngineService() {
        return new LadaEngineServiceImpl();}

    @Override
    public BodyService getBodyService() {
        return new LadaBodyServiceImpl();
    }

    @Override
    public WheelService getWheelService() {
        return new AudiWheelServiceImpl();
    }
}
