package lzc.com.example.AOPdemo.aspect;

import lzc.com.example.AOPdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {


    @After("execution(* lzc.com.example.AOPdemo.dao.AccountDAO.findAccounts(..))")
    public void afterAdvice(JoinPoint joinPoint){
        System.out.println("\n=====>>> Executing @After advice on method");
        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @After (finally) advice on method: " + method);
    }

    @AfterThrowing(

            pointcut = "execution(* lzc.com.example.AOPdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "exc"
    )
    public void afterThrowing(JoinPoint joinPoint, Throwable exc) {
        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterThrowing on method: " + method);

        // log the exception
        System.out.println("\n=====>>> The exception is: " + exc);
    }

    // add new methods for @AfterReturning methods
    @AfterReturning(
            pointcut = "execution(* lzc.com.example.AOPdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturning(JoinPoint joinPoint, List<Account> result) {
        System.out.println("\n=====>>> Executing @AfterReturning on method");

       // print out the method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("Method: " + method);
        // print out the result of the method call
        System.out.println("Result: " + result);

        // let's post-process the data ... let's modify it :-)
        // convert the account names to uppercase
        convertAccountNamesToUpperCase(result);
        System.out.println("Result: " + result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        // loop through accounts
        for (Account account : result) {
            // get uppercase version of name
            String theUpperName = account.getName().toUpperCase();
            // update the name on the account
            account.setName(theUpperName);
        }
    }

    @Before("lzc.com.example.AOPdemo.aspect.AopExpression.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("\n=====>>> Executing @Before advice on method");

        // displayed method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        // displayed method args
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println(arg);
            if (arg instanceof Account) {
                Account account = (Account) arg;
                System.out.println("account name: " + account.getName());
                System.out.println("account level: " + account.getLevel());
            }
            if (arg instanceof String) {
                System.out.println("account name: " + arg);
                System.out.println("account level: " + arg);
            }
        }
}

}
