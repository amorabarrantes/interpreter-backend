package com.example.interpreterbackend;
import org.springframework.web.bind.annotation.*;

@RestController



public class EndPoints {

    @GetMapping("/")
    public String homePage(){
        return "Home page";
    }

    @GetMapping("/compile")
    @CrossOrigin(origins = "http://localhost:3000")
    public String prueba(@RequestParam(value = "stringCodeValue") String stringCodeValue){
        System.out.println(stringCodeValue + "hola");
        String mensaje = metodos.compilarCodigo(stringCodeValue);
        return mensaje;
    }

}
