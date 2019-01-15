package ru.demo;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 18.08.2017
 */
public class HelloWorld {
    /**
     * Some string value.
     */
    private String message;

    /**
     * Setter.
     *
     * @param message - message to set.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Returns message.
     *
     * @return string.
     */
    public String getMessage() {
        return "Your message : " + message;
    }
}
