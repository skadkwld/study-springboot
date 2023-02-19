package tobyspring.helloboot;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class HelloDecorator implements HelloService{
    private final HelloService helloService;
    @Override
    public String sayHello(String name) {
        return "*" + helloService.sayHello(name) + "*";
    }

    public HelloDecorator(HelloService helloService) {
        this.helloService = helloService;
    }
}
