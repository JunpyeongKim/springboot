package hello;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Spring Boot: Quick Start
 *  - http://projects.spring.io/spring-boot/#quick-start
 *
 * Browser > http://localhost:8080
 */
@Controller
public class SampleController {
    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Hello World!";
    }
}
