package lzc.com.example.AOPdemo.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class AopExpression {
    @Pointcut("execution(* lzc.com.example.AOPdemo.dao.*.*(..))")
    public void forDaoPackage() {}
    // create pointcut for getter methods
    @Pointcut("execution(* lzc.com.example.AOPdemo.dao.*.get*(..))")
    public void getter() {}
    // create pointcut for setter methods
    @Pointcut("execution(* lzc.com.example.AOPdemo.dao.*.set*(..))")
    public void setter() {}
    // create pointcut: include package ... exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {}
}
