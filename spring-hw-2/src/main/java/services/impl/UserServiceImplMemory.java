package services.impl;

import beans.User;
import services.IUserService;
import java.util.*;
/*
 * Service Implement for user service using memory Map storage
 */
public class UserServiceImplMemory implements IUserService { 
    
    // 创建线程安全的Map 
    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>()); 
    
    public  List<User> getAllUsers(){
        List<User> r = new ArrayList<User>(users.values()); 
        return r;
    }
    
    public User findUserById(Long id){
        return users.get(id); 
        
    }
    public String saveUser(User user){
        users.put(user.getId(), user);
        return "success";
    }
    
    public String deleteUser(Long id){
        users.remove(id); 
        return "success"; 
    }
    
    public String UpdateUser(User user){
        Long id = user.getId();
        User u = users.get(id); 
        u.setName(user.getName()); 
        u.setAge(user.getAge()); 
        users.put(id, u); 
        return "success"; 
    }

}