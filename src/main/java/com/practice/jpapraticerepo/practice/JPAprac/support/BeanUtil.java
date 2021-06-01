package com.practice.jpapraticerepo.practice.JPAprac.support;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

//컴포넌트로 지정되어 있어야 한다는걸 주의해야한다.
@Component
public class BeanUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
                BeanUtil.applicationContext = applicationContext;
    }

    public static <T> T  getBean(Class<T> clazz){
        return applicationContext.getBean(clazz);
    }
}
