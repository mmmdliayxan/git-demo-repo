package auth;


import exceptions.NotFoundException;
import model.Role;
import model.User;
import required.Required;

import java.util.Scanner;

public class Auth {
    User[] users = new User[100];
    Required required = new Required();
    int count = 0;


    public void registrateUser() {
        String name = required.requiredText("Enter user name:");
        String surname = required.requiredText("Enter user surname:");
        int age = required.requiredNumber("Enter user age:");
        String username = required.requiredText("Enter user username:");
        String password = required.requiredText("Enter user password:");
        String role = required.requiredText("Enter user role:");
        Role role1 = Role.valueOf(role);

        User user = new User();
        user.setName(name);
        user.setSurName(surname);
        user.setAge(age);
        user.setUserName(username);
        user.setPassword(password);
        user.setRole(role1);

        users[count++] = user;
    }


    public void verifyUser(){
        String username = required.requiredText("Enter username:");
        String password = required.requiredText("Enter user password:");
        boolean found = false;

        for(int i = 0; i < count; i++){
            if(users[i].getUserName().equals(username) && users[i].getPassword().equals(password)){
                found = true;
            }
        }

        if(!found){
            throw new NotFoundException("User not found");
        }
    }
}
