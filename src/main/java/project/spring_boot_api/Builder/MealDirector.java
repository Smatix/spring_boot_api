package project.spring_boot_api.Builder;

import project.spring_boot_api.Model.Meal;

public class MealDirector {

    public MealDirector() {
    }

    public Meal build(MealBuilderInterface builder) {
        builder.addName();
        builder.addPortions();
        builder.addFoodList();
        builder.addCalories();
        builder.addProteins();
        builder.addCarbs();
        builder.addFats();
        builder.addUser();
        return builder.getMeal();
    }
}
