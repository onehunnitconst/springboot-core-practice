package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class AppContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    void findAllBean() {
        String[] beanDefNames = ac.getBeanDefinitionNames();
        for (String beanDefName : beanDefNames) {
            BeanDefinition beanDef = ac.getBeanDefinition(beanDefName);
            if (beanDef.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefName);
                System.out.println("name = " + beanDefName + ", object = " + bean);
            }
        }
    }

}
