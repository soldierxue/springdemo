package springboot.lambda;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import springboot.lambda.*;
import com.amazonaws.services.lambda.runtime.Context;
/**
 * The reall service implementation
 */
@Component
@Scope("prototype")
public class RequestSrv {
    static Log log = LogFactory.getLog(RequestComponent.class);

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    Environment environment;

    @Value(value = "${configtest.value:default config value2}")
    private String configValue;
    
    /*
     * Process request from lambda main
     */
    public String processRequest(String name, Context context) {
        log.info("In the hello lambda function");
        log.info("Test Configuration value  = "+ configValue);
        log.info("env value = " + environment.getProperty("configtest.value"));
        if(context != null){
            log.infor("AWS request ID:"+ context.getAwsRequestId());
            log.info("Function name: " + context.getFunctionName());
            log.info("Max mem allocated: " + context.getMemoryLimitInMB());
            log.info("Time remaining in milliseconds: " + context.getRemainingTimeInMillis());
            log.info("CloudWatch log stream name: " + context.getLogStreamName());
            log.info("CloudWatch log group name: " + context.getLogGroupName());          
            log.info("CloudWatch log group name: " + context.getLogGroupName());  
            log.infor("Client Context:"+ context.getClientContext());            
        }

        return String.format("Hello %s.", name);
    }
}
