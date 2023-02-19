package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloServiceTest {
    @Test
    void simpleHelloService() {
        SimpleHelloService helloService = new SimpleHelloService();

        Assertions.assertThat(helloService.sayHello("uiju")).isEqualTo("Hello uiju");
    }

    @Test
    void helloDecorator() {
        HelloDecorator decorator = new HelloDecorator(name -> name);

        String ret = decorator.sayHello("uiju");

        Assertions.assertThat(ret).isEqualTo("*uiju*");
    }
}
