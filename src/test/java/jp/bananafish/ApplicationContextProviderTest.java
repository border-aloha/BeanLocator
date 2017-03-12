package jp.bananafish;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by tmikami on 2017/03/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationContextProviderTest {
    @Test
    public void testGetApplicationContext() {
        ApplicationContext context = ApplicationContextProvider.getApplicationContext();
        assertThat(context, notNullValue());
        context.getBean();
    }
}
