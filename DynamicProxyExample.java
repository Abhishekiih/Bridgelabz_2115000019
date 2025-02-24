import java.lang.reflect.*;

interface Greeting {
    void sayHello();
}

class GreetingImpl implements Greeting {
    public void sayHello() {
        System.out.println("Hello, World!");
    }
}

class LoggingProxy implements InvocationHandler {
    private final Object target;
    
    public LoggingProxy(Object target) {
        this.target = target;
    }
    
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Invoking method: " + method.getName());
        return method.invoke(target, args);
    }
}

public class DynamicProxyExample {
    public static void main(String[] args) {
        Greeting original = new GreetingImpl();
        Greeting proxyInstance = (Greeting) Proxy.newProxyInstance(
            Greeting.class.getClassLoader(),
            new Class<?>[]{Greeting.class},
            new LoggingProxy(original)
        );
        
        proxyInstance.sayHello();
    }
}