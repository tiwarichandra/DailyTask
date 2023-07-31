package com.tiwari.springtrans.aop;

import com.mysql.cj.jdbc.ConnectionImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;
import java.sql.Connection;

@Component
@Aspect
public class DataSourceAspect {

    @Around("target(javax.sql.DataSource)")
    public Object logDataSourceConnectionInfo(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Signature signature = proceedingJoinPoint.getSignature();
        System.out.println("Datasource tracker: "+signature);
        Object proceed = proceedingJoinPoint.proceed();

        if (proceed instanceof Connection) {
            Connection connection = (Connection) Proxy.newProxyInstance(ConnectionImpl.class.getClassLoader(), new Class[]{Connection.class}, new ConnectionInvocationHandler((Connection) proceed));
            return connection;
        }
        return proceed;


    }
}
