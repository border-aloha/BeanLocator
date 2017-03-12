package jp.bananafish;

/**
 * Created by tmikami on 2017/03/12.
 */
public class BeanLocator {
    private static BeanManager beanManager;

    public static Object getBean(String name) {
        return resolveBeanManager().getBean(name);
    }

    public static <T> T getBean(String name, Class<T> requiredType) {
        return resolveBeanManager().getBean(name, requiredType);
    }

    private static BeanManager resolveBeanManager() {
        if (beanManager != null) {
            return beanManager;
        }
        // Springの探索
        Class.forName("org.springframework.context.ApplicationContext");
        Class.forName("jp.bananafish.SpringBeanManager");
        return beanManager;
    }
}
