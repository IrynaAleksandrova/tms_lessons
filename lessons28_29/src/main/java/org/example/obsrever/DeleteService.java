package org.example.obsrever;

import java.util.Observable;

public class DeleteService extends Observable implements UserService{

    private String serviceName = "delete";

    public void deletePerson(User user) {
        System.out.println("New message: ");
        setChanged();                        // произойдут изменения
        notifyObservers(user);               // оповещать всех подписчиков
    }

    public String getServiceName() {
        return serviceName;
    }
}
