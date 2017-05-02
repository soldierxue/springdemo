package springboot;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import springboot.lambda.*;
/**
 * Spring boot demo: Non Web Application Hello World!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //SpringApplication.run(App.class,args);
        SpringBootInvocation springBootInvocation =  new SpringBootInvocation();
        springBootInvocation.run();
        springBootInvocation.getApplicationContext().getBean(RequestComponent.class).processRequest("Robert",null);
    }
}