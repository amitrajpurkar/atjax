package com.anr.demo;

import static org.springframework.aop.interceptor.CustomizableTraceInterceptor.PLACEHOLDER_ARGUMENTS;
import static org.springframework.aop.interceptor.CustomizableTraceInterceptor.PLACEHOLDER_INVOCATION_TIME;
import static org.springframework.aop.interceptor.CustomizableTraceInterceptor.PLACEHOLDER_METHOD_NAME;
import static org.springframework.aop.interceptor.CustomizableTraceInterceptor.PLACEHOLDER_TARGET_CLASS_NAME;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.interceptor.CustomizableTraceInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder appBldr) {
        return appBldr.sources(Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommonsRequestLoggingFilter requestLoggingFilter() {
        CommonsRequestLoggingFilter crlf = new CommonsRequestLoggingFilter();
        crlf.setIncludeClientInfo(true);
        crlf.setIncludeQueryString(true);
        crlf.setIncludePayload(true);

        return crlf;
    }

    @Bean
    public CustomizableTraceInterceptor customizableTraceInterceptor() {
        CustomizableTraceInterceptor cti = new CustomizableTraceInterceptor();
        cti.setEnterMessage("entering method '" + PLACEHOLDER_METHOD_NAME + "(" + PLACEHOLDER_ARGUMENTS
                + ")' of class [" + PLACEHOLDER_TARGET_CLASS_NAME + "]");
        cti.setExitMessage("exiting method '" + PLACEHOLDER_METHOD_NAME + "' of class [" + PLACEHOLDER_TARGET_CLASS_NAME
                + "] took " + PLACEHOLDER_INVOCATION_TIME + "ms.");

        return cti;
    }

    @Bean
    public Advisor traceAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(public * com.anr..*.*(..))");

        return new DefaultPointcutAdvisor(pointcut, customizableTraceInterceptor());
    }

}
