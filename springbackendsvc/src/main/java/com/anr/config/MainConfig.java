package com.anr.config;

import static org.springframework.aop.interceptor.CustomizableTraceInterceptor.PLACEHOLDER_ARGUMENTS;
import static org.springframework.aop.interceptor.CustomizableTraceInterceptor.PLACEHOLDER_EXCEPTION;
import static org.springframework.aop.interceptor.CustomizableTraceInterceptor.PLACEHOLDER_INVOCATION_TIME;
import static org.springframework.aop.interceptor.CustomizableTraceInterceptor.PLACEHOLDER_METHOD_NAME;
import static org.springframework.aop.interceptor.CustomizableTraceInterceptor.PLACEHOLDER_TARGET_CLASS_SHORT_NAME;

import javax.servlet.Filter;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.BeansException;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.ErrorPageFilter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan
@EnableWebMvc
public class MainConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {

    private ApplicationContext appContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        appContext = applicationContext;
    }

    @Bean
    public CommonsRequestLoggingFilter requestLoggingFilter() {
        CommonsRequestLoggingFilter crlf = new CommonsRequestLoggingFilter();
        crlf.setIncludeClientInfo(true);
        crlf.setIncludeQueryString(true);
        crlf.setIncludePayload(false);
        return crlf;
    }

    @Bean
    public TraceInterceptor traceInterceptor() {
        TraceInterceptor traceInterceptor = new TraceInterceptor();

        String enterMessage = "\"name\": \"" + PLACEHOLDER_TARGET_CLASS_SHORT_NAME + "." + PLACEHOLDER_METHOD_NAME
                + "\", \"methodEntryValues\" : \"" + PLACEHOLDER_ARGUMENTS + "\"";
        String exitMessage = "\"name\": \"" + PLACEHOLDER_TARGET_CLASS_SHORT_NAME + "." + PLACEHOLDER_METHOD_NAME
                + "\", \"methodExitValues\" : \"" + PLACEHOLDER_ARGUMENTS + "\", \" timeTaken\" : \""
                + PLACEHOLDER_INVOCATION_TIME + " ms.\"";
        String exceptionMessage = "\"name\": \"" + PLACEHOLDER_TARGET_CLASS_SHORT_NAME + "." + PLACEHOLDER_METHOD_NAME
                + "\", \"exceptionEncountered\" : \"" + PLACEHOLDER_EXCEPTION + "\"";
        traceInterceptor.setEnterMessage(enterMessage);
        traceInterceptor.setExitMessage(exitMessage);
        traceInterceptor.setExceptionMessage(exceptionMessage);
        traceInterceptor.setHideProxyClassNames(true);

        return traceInterceptor;
    }

    @Bean
    public Advisor traceAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(public * com.anr.service..*.*(..))");
        return new DefaultPointcutAdvisor(pointcut, traceInterceptor());
    }

    @Bean
    public ErrorPageFilter errorPageFilter() {
        return new ErrorPageFilter();
    }

    @Bean
    public FilterRegistrationBean<Filter> disableSpringBootErrorFilter(ErrorPageFilter filter) {
        FilterRegistrationBean<Filter> frBean = new FilterRegistrationBean<>();
        frBean.setFilter(filter);
        frBean.setEnabled(false);
        return frBean;
    }

}
