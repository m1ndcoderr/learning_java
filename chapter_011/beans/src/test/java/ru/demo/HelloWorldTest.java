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
public class HelloWorldTest {
    /**
     * Demo test.
     */
    @Test
    public void whenBeanIsCreatedThenWeCanGetAMessage() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-demo-1.xml");
        HelloWorld object = (HelloWorld) context.getBean("hello_world");
        assertThat(object.getMessage(), is("Your message : Hello, world!"));
    }
}