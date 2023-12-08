package com.example.renderingservice.router;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Контроллер отображающий карту
 */

@Controller
@RequestMapping("/rendering-service")
public class BasicController {

    @GetMapping(value = "/map", produces = MediaType.TEXT_HTML_VALUE)
    public String getMap() {
        return "index";
    }

}