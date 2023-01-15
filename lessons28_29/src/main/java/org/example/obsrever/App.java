package org.example.obsrever;

public class App {
    public static void main(String[] args) {

        CreateService createService = new CreateService();
        DeleteService deleteService = new DeleteService();

        createService.addObserver(new Security());            // регистрируем для рассылки новых пользователей
        createService.addObserver(new Salary());
        createService.addObserver(new Admin());

        createService.createPerson(new User("Mike", "programmer"));
        System.out.println("---------");
        createService.createPerson(new User("Brad", "cleaner"));
        System.out.println("---------");
        deleteService.addObserver(new Admin());
        deleteService.deletePerson(new User("Brad", "cleaner"));
        System.out.println("---------");


    }
}
