package com.example.bookstoreproject.apiII;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HomeAPI {
    @GetMapping("/api/tesst")
    public ResponseEntity<String>  testRe(){
        return ResponseEntity.ok("SUCCESS");
    }


}
