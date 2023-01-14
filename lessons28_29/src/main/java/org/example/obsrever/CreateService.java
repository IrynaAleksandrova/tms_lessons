package org.example.obsrever;

import java.util.Observable;

public class CreateService extends Observable implements UserService{

    private String serviceName = "create";
    public void createPerson(User user) {
        System.out.println("New message: ");
        setChanged();                        // произойдут изменения
        notifyObservers(user);               // оповещать всех подписчиков
    }

    public String getServiceName() {
        return serviceName;
    }
}
