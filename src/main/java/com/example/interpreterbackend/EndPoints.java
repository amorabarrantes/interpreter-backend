package com.example.interpreterbackend;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")


public class EndPoints {

    @GetMapping("/")
    public String homePage(){
        return "Home page";
    }

    @GetMapping("/compile")

    public String prueba(@RequestParam(value = "stringCodeValue") String stringCodeValue){
        String mensaje = metodos.compilarCodigo(stringCodeValue);
        return mensaje;
    }

}
