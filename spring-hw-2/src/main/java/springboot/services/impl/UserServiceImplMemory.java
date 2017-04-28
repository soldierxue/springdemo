package springboot.services.impl;

import springboot.beans.User;
import springboot.services.IUserService;
import java.util.*;
import org.springframework.stereotype.Service;

/*
 * Service Implement for user service using memory Map storage
 */
public class UserServiceImplMemory  { 
    
    
    // 创建线程安全的Map 
    private static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>()); 
    
    public static List<User> getAllUsers(){
        List<User> r = new ArrayList<User>(users.values()); 
        return r;
    }
    
    public static User findUserById(Long id){
        return users.get(id); 
        
    }
    public static String saveUser(User user){
        users.put(user.getId(), user);
        return "success";
    }
    
    public static String deleteUser(Long id){
        users.remove(id); 
        return "success"; 
    }
    
    public static String updateUser(User user){
        Long id = user.getId();
        User u = users.get(id); 
        u.setName(user.getName()); 
        u.setAge(user.getAge()); 
        users.put(id, u); 
        return "success"; 
    }

}