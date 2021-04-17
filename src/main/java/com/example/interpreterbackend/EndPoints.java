package com.example.interpreterbackend;
import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

@RestController

@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", allowCredentials = "true")


public class EndPoints {

    @Bean
    public ConfigurableServletWebServerFactory webServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.addConnectorCustomizers(new TomcatConnectorCustomizer() {
            @Override
            public void customize(Connector connector) {
                connector.setProperty("relaxedQueryChars", "|{}[]");
            }
        });
        return factory;
    }

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
