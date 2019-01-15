package ru.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 18.08.2017
 */
@Component
public class ByeWorld {
    @Override
    public String toString(){
        return "Bye!";
    }
}
