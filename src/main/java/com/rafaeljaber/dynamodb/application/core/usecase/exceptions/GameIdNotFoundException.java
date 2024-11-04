package com.rafaeljaber.dynamodb.application.core.usecase.exceptions;

public class GameIdNotFoundException extends RuntimeException {
    public GameIdNotFoundException(String message) {
        super(message);
    }
}
