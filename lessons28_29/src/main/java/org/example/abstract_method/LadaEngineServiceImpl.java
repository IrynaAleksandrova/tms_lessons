package org.example.abstract_method;

public class LadaEngineServiceImpl implements EngineService {
    @Override
    public Engine createEngine() {
        return new Engine("Lada engine");
    }
}
