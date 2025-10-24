package service;

import exceptions.AccessDeniedException;
import logger.Logger;
import model.Role;
import model.User;

import java.io.IOException;
import java.time.LocalDateTime;

public class UserService {
    static int count =0;


    public static void showAllUsers(User currentUser){
        if(currentUser.getRole() != Role.ADMIN){
            throw new AccessDeniedException("User can not view all users");
        }

        for(User user : User.users){
            if(user != null){
                System.out.println(user);
            }
        }
    }

    public static void getProfile(User currentUser){

        System.out.println(currentUser);

    }

    public static  void deleteUser(User currentUser,String username) throws IOException {

        if(currentUser.getRole() != Role.ADMIN){
            throw new AccessDeniedException("User can not delete");
        }

        for(int i =0; i<User.users.length;i++){
            if(User.users[i] == null){
                break;
            }
            if(username.equals(User.users[i].getUserName())){
                User.users[i] =null;
                System.out.println("User successfully deleted");
                Logger.log(LocalDateTime.now()+" "+" User succesfully deleted");
                return;
            }
        }
        try {
            throw new RuntimeException("There is no such user. ");
        }catch (RuntimeException e){
            e.printStackTrace();
        }

    }

}
