package me.study.oauth2.resource.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping("/api/users/me")
    public ResponseEntity<String> profile()
    {
        return ResponseEntity.ok("user");
    }
}
