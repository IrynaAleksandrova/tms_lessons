package org.example.abstract_method;

public class Service {
    public void createCar(AbstractFactory factory){

        EngineService engineService = factory.getEngineService();
        Engine engine = engineService.createEngine();
        System.out.println(engine);

        BodyService bodyService = factory.getBodyService();
        Body body = bodyService.createBody();
        System.out.println(body);

        WheelService wheelService = factory.getWheelService();
        Wheel wheel = wheelService.createWheel();
        System.out.println(wheel);
    }
}
