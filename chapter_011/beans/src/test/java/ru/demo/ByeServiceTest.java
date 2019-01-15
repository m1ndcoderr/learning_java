package ru.demo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 18.08.2017
 */
public class ByeServiceTest {
    /**
     * Demo test.
     */
    @Test
    public void whenBeanIsCreatedThenWeCanGetThatJavaClass() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-demo-2.xml");
        ByeService object = (ByeService) context.getBean("byeService");
        assertThat(object, is("Your message : Bye!"));
    }
}