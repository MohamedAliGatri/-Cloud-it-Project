package com.cloudit.project.ExeptionHnadler;

public class ProjectsNotFoundExeption extends RuntimeException {

        public ProjectsNotFoundExeption(String message) {
            super(message);
        }
    }

