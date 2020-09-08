package my_spring;

import my_spring.configuration.Config;
import my_spring.configuration.JavaConfig;
import my_spring.factory.Context;
import my_spring.factory.ObjectFactory;

import java.util.Map;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {

        Map<Class<?>, Class<?>> map = Map.of(
                Speaker.class, ConsoleSpeaker.class
                );

        Context context = Context.getInstance().configure(new JavaConfig(map,"my_spring"));

        IRobot iRobot = context.createObject(IRobot.class);
        iRobot.cleanRoom();
    }
}
