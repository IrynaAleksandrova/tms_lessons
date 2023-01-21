package org.example.abstract_method;

public class Factory {

    public static void main(String[] args) {

        Service service = new Service();
        service.createCar(new AudiAbstractFactoryImpl());
        System.out.println();
        service.createCar(new BMWAbstractFactoryImpl());
        System.out.println();
        service.createCar(new LadaAbstractFactoryImpl());
        System.out.println();
    }
}
