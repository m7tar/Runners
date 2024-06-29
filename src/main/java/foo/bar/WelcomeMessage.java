package foo.bar;

import org.springframework.stereotype.Component;

@Component  //this class is available to Spring
public class WelcomeMessage {
    public String getwelcomeMessage() {
        return "Welcome to Foo Bar!";
    }
}
