package com.example.interpreterbackend;
import Interpreter.interpreterVisit;
import Interpreter.valuesTable;
import contextAnalysis.identificationTable;
import org.springframework.web.bind.annotation.*;
import java.util.LinkedList;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@RestController

@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", allowCredentials = "true")


public class EndPoints {
    public boolean estaLimpio = false;
    claseTablas ct = claseTablas.getIsntance();

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

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("*")
                        .allowedHeaders("*");
            }
        };
    }

    @GetMapping("/")
    public String homePage(){
        return "Home page";
    }


    @GetMapping("/compileAllCode")
    public ResponseBody compilarCodigoCompleto(@RequestParam(value = "stringCodeValue") String stringCodeValue){
        estaLimpio = true;

        String mensaje = metodos.compilarCodigoCompleto(
                "char chr(int i){return 'i';} " +
                "\nint ord(char ch){return 0;}\n" +
                "int len(int[] arr){return arr.length;} \n" +
                stringCodeValue);




        String tablaVariables = ct.tablaVarDeclaration.retornarStringTablaVariable();
        String tablaFunciones = ct.tablaFunciones.retornarStringTablaFuncion();
        String tablaClases = ct.tablaClassDeclaration.retornarStringTablaClase();

        String tablasGlobal = tablaVariables + "\n" + tablaClases + "\n" + tablaFunciones;

        //Impresiones mensaje
        interpreterVisit iv = new interpreterVisit();

        if(mensaje.contains("Ⓖ")){
            String[] sublist = mensaje.split("Ⓖ");
            tablasGlobal += "\n\n\n IMPRESIONES: \n" + sublist[0];
            mensaje = "Ejecucion finalizada!!";
        }


        ResponseBody response = new ResponseBody(mensaje, tablasGlobal);

        ct.tablaFunciones = new identificationTable<>(new LinkedList<>(), 0);
        ct.tablaClassDeclaration = new identificationTable<>(new LinkedList<>(), 0);
        ct.tablaVarDeclaration = new identificationTable<>(new LinkedList<>(), 0);

        ct.tablaNodoValorFuncion = new valuesTable<>(new LinkedList<>(), 0);
        ct.tablaNodoValorVariable = new valuesTable<>(new LinkedList<>(), 0);
        ct.tablaNodoValorClase = new valuesTable<>(new LinkedList<>(), 0);

        return response;
    }

    @GetMapping("/compileSnippet")
    public ResponseBody compilarCodigoConsola(@RequestParam(value = "stringCodeValue") String stringCodeValue){
        if(estaLimpio){
            metodos.compilarCodigoConsola("char chr(int i){return 'i';} " +
                    "\nint ord(char ch){return 0;}\n" +
                    "int len(int[] arr){return arr.length;} \n");
            estaLimpio = false;
        }

        String mensaje = metodos.compilarCodigoConsola(stringCodeValue);

        String tablaVariables = ct.tablaVarDeclaration.retornarStringTablaVariable();
        String tablaFunciones = ct.tablaFunciones.retornarStringTablaFuncion();
        String tablaClases = ct.tablaClassDeclaration.retornarStringTablaClase();

        String tablasGlobal = tablaVariables + "\n" + tablaClases + "\n" + tablaFunciones;

        interpreterVisit iv = new interpreterVisit();


        if(mensaje.contains("Ⓖ")){
            String[] sublist = mensaje.split("Ⓖ");
            tablasGlobal += "\n\n\n IMPRESIONES: \n" + sublist[0];
            mensaje = "Ejecucion finalizada!!";
        }
        ResponseBody response = new ResponseBody(mensaje, tablasGlobal);
        
        return response;
    }

}
