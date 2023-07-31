package com.secondservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RequestMapping("/second")
@RestController
public class SecondController {

    @GetMapping("/message")
    public Map<String, String> getSecondMessage() {
        return Collections.singletonMap("message", "Hello You called second service");
    }
}
