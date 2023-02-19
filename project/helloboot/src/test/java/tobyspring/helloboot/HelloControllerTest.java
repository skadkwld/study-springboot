package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

public class HelloControllerTest {
    @Test
    void helloController(){
        HelloController helloController = new HelloController((name) -> name);

        Assertions.assertThat(helloController.hello("uiju")).isEqualTo("uiju");
    }

    @Test
    void failHelloController() {
        HelloController helloController = new HelloController(name -> name);

        Assertions.assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
            @Override
            public void call() throws Throwable {
                helloController.hello(null);
            }
        }).isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(() -> {
            helloController.hello("");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
