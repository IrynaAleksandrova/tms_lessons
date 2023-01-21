package org.example.abstract_method;

public class AudiEngineServiceImpl implements EngineService {
    @Override
    public Engine createEngine() {
        return new Engine("Audi engine");
    }
}
