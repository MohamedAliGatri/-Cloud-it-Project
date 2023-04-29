package com.cloudit.project.ExeptionHnadler;

public class PlantsNotFoundExeption extends RuntimeException{
    public PlantsNotFoundExeption(String message) {
        super(message);
    }



    public PlantsNotFoundExeption(String plant, String id, Long plantId) {
    }
}
