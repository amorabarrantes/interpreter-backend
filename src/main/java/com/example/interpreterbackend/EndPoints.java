package com.example.interpreterbackend;
import contextAnalysis.identificationTable;
import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;

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

    @GetMapping("/")
    public String homePage(){
        return "Home page";
    }


    @GetMapping("/compileAllCode")
    public ResponseBody compilarCodigoCompleto(@RequestParam(value = "stringCodeValue") String stringCodeValue){
        estaLimpio = true;

        String mensaje = metodos.compilarCodigoCompleto(
                "char chr(int i){return 'q';} " +
                "\nint ord(string ch){return 0;}\n" +
                "int len(int[] arr){return 0;} \n" +
                stringCodeValue);

        String tablaVariables = ct.tablaVarDeclaration.retornarStringTablaVariable();
        String tablaFunciones = ct.tablaFunciones.retornarStringTablaFuncion();
        String tablaClases = ct.tablaClassDeclaration.retornarStringTablaClase();

        String tablasGlobal = tablaVariables + "\n" + tablaClases + "\n" + tablaFunciones;

        ResponseBody response = new ResponseBody(mensaje, tablasGlobal);

        ct.tablaFunciones = new identificationTable<>(new LinkedList<>(), 0);
        ct.tablaClassDeclaration = new identificationTable<>(new LinkedList<>(), 0);
        ct.tablaVarDeclaration = new identificationTable<>(new LinkedList<>(), 0);
        return response;
    }

    @GetMapping("/compileSnippet")
    public ResponseBody compilarCodigoConsola(@RequestParam(value = "stringCodeValue") String stringCodeValue){
        if(estaLimpio){
            metodos.compilarCodigoConsola("char chr(int i){return 'q';} " +
                    "\nint ord(string ch){return 0;}\n" +
                    "int len(int[] arr){return 0;} \n");
            estaLimpio = false;
        }

        String mensaje = metodos.compilarCodigoConsola(stringCodeValue);

        String tablaVariables = ct.tablaVarDeclaration.retornarStringTablaVariable();
        String tablaFunciones = ct.tablaFunciones.retornarStringTablaFuncion();
        String tablaClases = ct.tablaClassDeclaration.retornarStringTablaClase();

        String tablasGlobal = tablaVariables + "\n" + tablaClases + "\n" + tablaFunciones;

        ResponseBody response = new ResponseBody(mensaje, tablasGlobal);
        return response;
    }

}
