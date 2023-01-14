package org.example.abstract_method;

public class BMWEngineServiceImpl implements EngineService {
    @Override
    public Engine createEngine() {
        return new Engine("BMW engine");
    }
}
