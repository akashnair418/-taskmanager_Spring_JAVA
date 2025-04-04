package com.scalar.taskmanager;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/listofpeople")
    String listofpeople() {
        return "SKY, REYNA< RAZE, YORU";
    }

    @GetMapping("/listofabilites")
    String abilites(){
        return "BOOMBOT, NADE, ROCKET";
    }
}
