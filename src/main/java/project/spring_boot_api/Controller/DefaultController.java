package project.spring_boot_api.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

    @GetMapping("/hello")
    public String getHello() {
        return "Hello World";
    }



    @GetMapping("/dwaplusdwa")
    public Integer getHello2() {
        return 2+2;
    }
}
