package e8ilab2.apipedidos.controllers;

import e8ilab2.apipedidos.utils.Messages;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public ResponseEntity<?> healthTest() {
        return ResponseEntity.ok().body(new Messages(200, "API Ok!"));
    }
}
