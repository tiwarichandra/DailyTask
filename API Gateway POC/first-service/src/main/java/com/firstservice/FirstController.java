package com.firstservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RequestMapping("/first")
@RestController
public class FirstController {

    @GetMapping("/message")
    public Map<String, String> getMessage() {
        return Collections.singletonMap("message", "Hello You called first service");
    }

}
