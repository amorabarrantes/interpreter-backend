package com.example.interpreterbackend;

public class ResponseBody {
    private final String mensajeError;
    private final String mensajeImpresion;

    public ResponseBody(String mensajeError, String mensajeImpresion) {
        this.mensajeError = mensajeError;
        this.mensajeImpresion = mensajeImpresion;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public String getMensajeImpresion(){
        return  mensajeImpresion;
    }
}
