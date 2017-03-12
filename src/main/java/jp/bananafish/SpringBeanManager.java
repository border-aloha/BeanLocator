package jp.bananafish;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by tmikami on 2017/03/11.
 */
@Component
public class SpringBeanManager implements BeanManager, ApplicationContextAware {
    private static ApplicationContext applicationContext;
    private static Map<String, Object> cache = new ConcurrentHashMap<>();
    public Object getBean(String name) {
        Object bean = resolveBean(name);
        cache.put(name, bean);
        return bean;
    }

    public <T> T getBean(String name, Class<T> requiredType) {
        Object bean = resolveBean(name);
        if (requiredType.isAssignableFrom(bean.getClass())) {
            cache.put(name, bean);
        } else {
            throw new IllegalArgumentException();
        }
        return (T) bean;
    }

    private Object resolveBean(String name) {
        Object bean = cache.get(name);
        if (bean == null) {
            bean = applicationContext.getBean(name);
        }
        return bean;
    }

    public void setApplicationContext(ApplicationContext newContext) {
        applicationContext = newContext;
    }
}
