package springboot.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import springboot.beans.User;
import java.util.*;
import springboot.services.impl.*;
import springboot.services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController 
@RequestMapping(value="/users") 
public class UserController { 
    
    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    
    @Autowired
    private IUserService userService;
    
    @RequestMapping(value="/", method=RequestMethod.GET) 
    public List<User> getUserList() { 
        // 处理"/users/"的GET请求，用来获取用户列表 
        // 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递 
        return userService.getAllUsers(); 
    } 
 
    @RequestMapping(value="/", method=RequestMethod.POST) 
    public String postUser(@ModelAttribute User user) { 
        // 处理"/users/"的POST请求，用来创建User 
        // 除了@ModelAttribute绑定参数之外，还可以@RequestParam从页面中传递参数 
        logger.debug("User:"+user.getId()+","+user.getName()+","+user.getAge());
        logger.info("User:"+user.getId()+","+user.getName()+","+user.getAge());
        return userService.saveUser(user); 
    } 
 
    @RequestMapping(value="/{id}", method=RequestMethod.GET) 
    public User getUser(@PathVariable Long id) { 
        // 处理"/users/{id}"的GET请求，用来获取url中id值的User信息 
        // url中的id可通过@PathVariable绑定到函数的参数中 
        return userService.findUserById(id); 
    } 
 
    @RequestMapping(value="/{id}", method=RequestMethod.PUT) 
    public String putUser(@PathVariable Long id, @ModelAttribute User user) { 
        // 处理"/users/{id}"的PUT请求，用来更新User信息 
        return userService.updateUser(user); 
    } 
 
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE) 
    public String deleteUser(@PathVariable Long id) { 
        // 处理"/users/{id}"的DELETE请求，用来删除User 
        return userService.deleteUser(id); 
    } 
 
}