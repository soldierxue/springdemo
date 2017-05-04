package springboot;

import springboot.lambda.*;
/*
 * Hello Lambda Demo
 */
public class HelloLambda  {
    /*
     * Local Test Main
     */
    public static void main(String[] args) {
        SpringBootInvocation springBootInvocation =  new SpringBootInvocation();
        springBootInvocation.run();
        //springBootInvocation.getApplicationContext().getBean(RequestSrv.class).processRequest("jasonxue",null);
    }
}