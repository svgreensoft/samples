package org.sversh.springboot.dictionary;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author <a>Sergey Vershinin</a>
 * @since Jul 9, 2017
 *
 */
@RestController
public class AppController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

}
