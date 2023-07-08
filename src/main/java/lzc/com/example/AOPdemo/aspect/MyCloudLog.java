package lzc.com.example.AOPdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLog {
    @Before("lzc.com.example.AOPdemo.aspect.AopExpression.forDaoPackageNoGetterSetter()")
    public void logToCloud() {
        System.out.println("\n=====>>> Logging to Cloud");

    }
}
