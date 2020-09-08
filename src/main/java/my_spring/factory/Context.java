package my_spring.factory;

import my_spring.configuration.Config;


public class Context {

    private static final Context context = new Context();
    private final ObjectFactory objectFactory = ObjectFactory.getInstance();

    public Context configure(Config config) {
        objectFactory.configure(config);
        return context;
    }

    private Context() {
    }

    public static Context getInstance() {
        return context;
    }

    public <T> T createObject(Class<T> type) {
        return objectFactory.createObject(type);
    }

}
