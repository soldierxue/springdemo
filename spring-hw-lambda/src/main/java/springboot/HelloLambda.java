package springboot;

import com.amazonaws.services.lambda.runtime.*;
import springboot.lambda.*;
/*
 * Hello Lambda Demo
 */
public class HelloLambda implements RequestHandler <String, String> {
    /*
     * Lambda Handler Main
     */
    public String handleRequest(String name, Context context) {
        SpringBootInvocation springBootInvocation =  new SpringBootInvocation();
        springBootInvocation.run();
        return springBootInvocation.getApplicationContext().getBean(RequestSrv.class).processRequest(name,context);
    }
    /*
     * Local Test Main
     */
    public static void main(String[] args) {
        SpringBootInvocation springBootInvocation =  new SpringBootInvocation();
        springBootInvocation.run(HelloLambda.class);
        springBootInvocation.getApplicationContext().getBean(RequestSrv.class).processRequest("jasonxue",null);
    }
}