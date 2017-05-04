package springboot;

import com.amazonaws.services.lambda.runtime.*;
import springboot.lambda.*;
/*
 * Hello Lambda Demo
 */
public class HelloLambda implements RequestHandler <String, String> {
    /*
     * Local Test Main
     */
    public static void main(String[] args) {
        SpringBootInvocation springBootInvocation =  new SpringBootInvocation();
        springBootInvocation.run();
        //springBootInvocation.getApplicationContext().getBean(RequestSrv.class).processRequest("jasonxue",null);
    }
}