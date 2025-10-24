package model;

public class User {

    public static User[] users;
    private String name;
    private String surname;
    private int age;
    private String username;
    private String password;
    private Role role;


    public String getName() {
        return name;
    }

    public String getSurName() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getUserName() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole(){
        return role;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setSurName(String surname){
        this.surname = surname;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setUserName(String username){
        this.username=username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setRole(Role role){
        this.role = role;
    }
}
