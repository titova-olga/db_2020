package my_spring;

import my_spring.configuration.Config;
import my_spring.configuration.JavaConfig;
import my_spring.factory.Context;
import my_spring.factory.ObjectFactory;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Map;

/**
 * @author Evgeny Borisov
 */
public class ObjectFactoryTest {


    @Test(expected = IllegalArgumentException.class)
    public void injectRandomIntForIncorrectValuesIsFailing() {
        ObjectFactory objectFactory = ObjectFactory.getInstance();
        objectFactory.configure(new JavaConfig(null, "my_spring"));
        objectFactory.createObject(Developer.class);
    }

    @Test
    public void injectRandomIntIsWorking() {
        ObjectFactory objectFactory = ObjectFactory.getInstance();
        objectFactory.configure(new JavaConfig(null, "my_spring"));
        Soldier soldier = objectFactory.createObject(Soldier.class);
        Assert.assertTrue(soldier.getPower() < 15 && soldier.getPower() > 7);
    }

    @Test
    public void objectWasCreatedFromConfiguredClass() {

        Config config = Mockito.mock(Config.class);

        Mockito.when(config.getImpl(SuperHero.class)).then(invocation -> Batman.class);
        Mockito.when(config.getPackageToScan()).then(invocation -> "my_spring");

        ObjectFactory objectFactory = ObjectFactory.getInstance();
        objectFactory.configure(config);
        SuperHero superHero = objectFactory.createObject(SuperHero.class);
        Assert.assertEquals(Batman.class, superHero.getClass());
    }
}























