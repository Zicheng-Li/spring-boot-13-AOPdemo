package lzc.com.example.AOPdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyCloudLog {
    @Before("forDaoPackageNoGetterSetter()")
    public void logToCloud() {
        System.out.println("\n=====>>> Logging to Cloud");

    }
}
