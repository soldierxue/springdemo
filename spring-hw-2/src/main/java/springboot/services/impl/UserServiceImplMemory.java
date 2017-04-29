package springboot.services.impl;

import springboot.beans.User;
import springboot.services.IUserService;
import java.util.*;
import org.springframework.stereotype.Service;

/*
 * Service Implement for user service using memory Map storage
 */
@Service
public class UserServiceImplMemory implements IUserService  { 
    
    
    // 创建线程安全的Map 
    private static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>()); 
    
    static{
        User u = new User();
        u.setId(Long.valueOf(122));
        u.setName("tst");
        u.setAge(12);
        users.put(u.getId(),u);
    }
    
    public  List<User> getAllUsers(){
        List<User> r = new ArrayList<User>(users.values()); 
        return r;
    }
    
    public  User findUserById(Long id){
        return users.get(id); 
        
    }
    public  String saveUser(User user){
        users.put(user.getId(), user);
        return "save success";
    }
    
    public  String deleteUser(Long id){
        users.remove(id); 
        return "delete success"; 
    }
    
    public  String updateUser(User user){
        Long id = user.getId();
        User u = users.get(id); 
        u.setName(user.getName()); 
        u.setAge(user.getAge()); 
        users.put(id, u); 
        return "update success"; 
    }

}