package com.blueyonder.auth.exception;

public class AccessDeniedException extends RuntimeException{

        public AccessDeniedException(String message) {
            super(message);
        }
}
