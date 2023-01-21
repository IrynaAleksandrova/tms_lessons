package org.example.obsrever;

import java.util.Observable;
import java.util.Observer;

public class Salary implements Observer {
    @Override
    public void update(Observable o, Object arg) {

        UserService service = (UserService) o;
        User user1 = (User) arg;
        System.out.println("This is salary");

        if (service.getServiceName().equals("create")) {
            System.out.println("Prepare salary bill for " + user1.getName() + "; " + user1.getCategory());
        } else if (service.getServiceName().equals("delete")) {
            System.out.println("Delete salary bill for " + user1.getName() + "; " + user1.getCategory());
        }

    }
}
