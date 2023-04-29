package com.cloudit.project.métier;

import com.cloudit.project.ExeptionHnadler.PetsNotFoundExeption;
import com.cloudit.project.model.Pets;
import org.springframework.stereotype.Service;

@Service
    public class PetsValidationService {

        public void validatePet(Pets pet) throws PetsNotFoundExeption {
            if (pet.getType() == null) {
                throw new PetsNotFoundExeption("Le type de l'animal de compagnie ne peut pas être nul.");
            }
            if (pet.getWeights() <= 0) {
                throw new PetsNotFoundExeption("Le poids de l'animal de compagnie doit être supérieur à zéro.");
            }
            if (pet.getShelter_quota() < 0) {
                throw new PetsNotFoundExeption("Le quota de refuge pour l'animal de compagnie ne peut pas être négatif.");
            }
            if (pet.getWater_Quota() <= 0) {
                throw new PetsNotFoundExeption("Le quota d'eau doit être supérieur à zéro.");
            }
            if (pet.getEmployee_quota() <= 0) {
                throw new PetsNotFoundExeption("Le quota d'employés doit être supérieur à zéro.");
            }
            if (pet.getAge_Months() <= 0) {
                throw new PetsNotFoundExeption("L'âge en mois doit être supérieur à zéro.");
            }
            if (pet.getArea_quota_m() <= 0) {
                throw new PetsNotFoundExeption("Le quota de surface doit être supérieur à zéro.");
            }

            // autres validations selon vos besoins
        }


    }


