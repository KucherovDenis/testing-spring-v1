package ru.denku;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.denku.domain.Runner;
import ru.denku.io.Loader;


public class Application {

    private static void showExceptionMessage(Exception e) {
        System.err.println(e.getMessage());
        Throwable cause = e.getCause();
        while (cause != null) {
            System.err.println(cause.getMessage());
            cause = cause.getCause();
        }
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Runner testRunner = context.getBean(Runner.class);
        try {
            testRunner.run();
        } catch (ApplicationException e) {
            showExceptionMessage(e);
        }
        context.close();
    }
}
