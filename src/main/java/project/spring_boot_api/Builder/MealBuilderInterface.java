package project.spring_boot_api.Builder;

import project.spring_boot_api.Model.Meal;

public interface MealBuilderInterface {
    void addName();
    void addPortions();
    void addFoodList();
    void addCalories();
    void addProteins();
    void addCarbs();
    void addFats();
    void addUser();
    Meal getMeal();
}
