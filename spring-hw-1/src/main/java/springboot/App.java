package springboot;
import org.springframework.boot.SpringApplication;
/**
 * Spring boot demo: Non Web Application Hello World!
 *
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
        SpringApplication app = new SpringApplication(App.class);
        app.run(args);
    }
}