package com.cloudit.project.métier;

import com.cloudit.project.ExeptionHnadler.PlantsNotFoundExeption;
import com.cloudit.project.model.Plants;
import org.springframework.stereotype.Service;

@Service
public class PlantsValidationService {

    public void validate(Plants plant) throws PlantsNotFoundExeption {
        if (plant.getSoilQuality_quota() <= 0) {
            throw new PlantsNotFoundExeption("Soil quality must be a positive number");
        }
        if (plant.getNutriments_quota() <= 0) {
            throw new PlantsNotFoundExeption("Nutriments must be a positive number");
        }
        if (plant.getPrune_quota() <= 0) {
            throw new PlantsNotFoundExeption("Prune quota must be a positive number");
        }
        if (plant.getType() == null) {
            throw new PlantsNotFoundExeption("Plant type must be specified");
        }

        if (plant.getWater_Quota() <= 0) {
            throw new PlantsNotFoundExeption("Le quota d'eau doit être supérieur à zéro.");
        }
        if (plant.getEmployee_quota() <= 0) {
            throw new PlantsNotFoundExeption("Le quota d'employés doit être supérieur à zéro.");
        }
        if (plant.getAge_Months() <= 0) {
            throw new PlantsNotFoundExeption("L'âge en mois doit être supérieur à zéro.");
        }
        if (plant.getArea_quota_m() <= 0) {
            throw new PlantsNotFoundExeption("Le quota de surface doit être supérieur à zéro.");
        }
    }
}
