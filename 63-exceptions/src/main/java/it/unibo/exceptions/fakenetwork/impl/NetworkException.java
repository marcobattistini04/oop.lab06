package it.unibo.exceptions.fakenetwork.impl;

import java.io.IOException;

public class NetworkException extends IOException{

    NetworkException() throws Exception {
        throw new Exception("Network error: no response");
    }

    NetworkException( String message) {
        System.out.println("Network error while sending message: " + message);
    }
    
}
