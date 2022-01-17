package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.*;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        UserService testService = new UserServiceImpl();

        testService.createUsersTable();

        testService.saveUser("Глеб", "LastName1", (byte) 20);
        System.out.println("User с именем – Глеб добавлен в базу данных");

        testService.saveUser("Среда", "Пупкин", (byte) 25);
        System.out.println("User с именем – Среда добавлен в базу данных");

        testService.saveUser("Олег", "LastName3", (byte) 31);
        System.out.println("User с именем – Олег добавлен в базу данных");

        testService.saveUser("Жаба", "LastName4", (byte) 54);
        System.out.println("User с именем – Жаба добавлен в базу данных");

        System.out.println(testService.getAllUsers());

        testService.cleanUsersTable();

        testService.dropUsersTable();
    }
}
