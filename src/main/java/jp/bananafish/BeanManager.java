package jp.bananafish;

/**
 * Created by tmikami on 2017/03/11.
 */
public interface BeanManager {
    Object getBean(String name);
    <T> T getBean(String name, Class<T> requiredType);
}
