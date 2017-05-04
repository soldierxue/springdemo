package springboot.controller;

import org.apache.log4j.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import springboot.beans.*;
import springboot.services.*;
import springboot.services.impl.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Path("/")
@Component
@Scope("prototype")
public class UserRSController {

    @Autowired
    private IUserService userService;
    
    static final Logger logger = Logger.getLogger(UserRSController.class);

    static class Entity {
        public int id = 1;
        public String name;

        public Entity(String name) {
            this.name = name;
        }
    }

    @GET
    @Path("/users")
    public Response indexUsers(
    ) {
        logger.debug("Request got");
        return Response.status(200)
                .entity(userService.getAllUsers())
                .build();
    }

    @GET
    @Path("/users/{id}")
    public Response exampleEndpoint(
            @PathParam("id") String id
    ) {

        logger.debug("Request got by user id");
        return Response.status(201)
                .entity(userService.findUserById(id))
                .build();
    }

    /**
     * This controller uses automatically serialization of Request body to any POJO
     * @param requestEntity Request Entity
     * @return Response
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/user")
    public Response exampleSecondEndpointPost(
            User user
    ) {

        logger.debug("POST Request got");
        logger.debug("User:"+user.getId()+","+user.getName()+","+user.getAge());
        String msg = userService.saveUser(user);
        return Response.status(201)
                .entity(msg)
                .build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/user")
    public Response exampleSecondEndpointPost(
            User user
    ) {

        logger.debug("PUT Request got");
        logger.debug("User:"+user.getId()+","+user.getName()+","+user.getAge());
        String msg = userService.updateUser(user);
        return Response.status(201)
                .entity(msg)
                .build();
    }    

}
