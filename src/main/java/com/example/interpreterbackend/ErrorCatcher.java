package com.example.interpreterbackend;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

import org.antlr.v4.runtime.misc.ParseCancellationException;

import java.util.ArrayList;

public class ErrorCatcher extends BaseErrorListener {
    public static final ErrorCatcher INSTANCE = new ErrorCatcher();

    public String stringErrores = "";


    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e){
        stringErrores += msg + "\n";
    }

}

