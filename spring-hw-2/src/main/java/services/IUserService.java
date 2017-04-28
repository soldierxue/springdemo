package services;
import beans.User;
import java.util.*;
/*
 * Service interface for user
 */
public interface IUserService { 
    /*
     * Get all users
     */
    public  List<User> getAllUsers();
    public User findUserById(Long id);
    public String saveUser(User u);
    public String deleteUser(Long id);
    public String updateUser(User u);

}