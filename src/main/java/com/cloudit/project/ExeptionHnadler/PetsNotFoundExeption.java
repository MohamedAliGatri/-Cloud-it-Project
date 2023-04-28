package com.cloudit.project.ExeptionHnadler;

public class PetsNotFoundExeption extends RuntimeException {
    public PetsNotFoundExeption(String message) {
        super(message);
    }
}
