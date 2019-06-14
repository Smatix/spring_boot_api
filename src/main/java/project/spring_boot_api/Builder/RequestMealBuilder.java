package project.spring_boot_api.Builder;

import project.spring_boot_api.DTO.MealDTO;
import project.spring_boot_api.Model.Food;
import project.spring_boot_api.Model.Meal;
import project.spring_boot_api.Model.User;
import project.spring_boot_api.Repository.FoodRepository;
import project.spring_boot_api.Repository.UserRepository;


public class RequestMealBuilder implements MealBuilderInterface {

    private MealDTO mealDTO;
    private Meal meal;
    private double calories;
    private double proteins;
    private double carbs;
    private double fats;
    private FoodRepository repository;
    private UserRepository userRepository;

    public RequestMealBuilder(MealDTO mealDTO, FoodRepository repository, UserRepository userRepository){
        this.mealDTO = mealDTO;
        this.userRepository = userRepository;
        this.repository = repository;
        this.meal = new Meal();
        this.calories = 0;
        this.proteins = 0;
        this.carbs = 0;
        this.fats = 0;
    }

    @Override
    public void addName() {
        this.meal.setName(this.mealDTO.getName());
    }

    @Override
    public void addPortions() {
        this.meal.setPortions(this.mealDTO.getPortions());
    }

    @Override
    public void addFoodList() {
        for (int i = 0; i<this.mealDTO.getFoodList().size();i++) {
            Food food = repository.findById(mealDTO.getFoodList().get(i)).get();
            this.calories += food.getCalories();
            this.proteins += food.getProteins();
            this.carbs += food.getCarbs();
            this.fats += food.getFats();
            this.meal.addIngredient(food);
        }
    }

    @Override
    public void addCalories() {
        this.meal.setCalories(this.calories);
    }

    @Override
    public void addProteins() {
        this.meal.setProteins(this.proteins);
    }

    @Override
    public void addCarbs() {
        this.meal.setCarbs(this.carbs);
    }

    @Override
    public void addFats() {
        this.meal.setFats(this.fats);
    }

    @Override
    public void addUser() {
        User user = userRepository.getUserByLogin(this.mealDTO.getOwner());
        this.meal.setUser(user);
    }

    @Override
    public Meal getMeal() {
        return this.meal;
    }


}
