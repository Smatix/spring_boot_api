package project.spring_boot_api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import project.spring_boot_api.Builder.MealBuilderInterface;
import project.spring_boot_api.Builder.MealDirector;

import project.spring_boot_api.Builder.RequestMealBuilder;
import project.spring_boot_api.DTO.MealDTO;
import project.spring_boot_api.Model.Meal;
import project.spring_boot_api.Repository.FoodRepository;
import project.spring_boot_api.Repository.MealRepository;
import project.spring_boot_api.Repository.UserRepository;

import java.util.List;


@RestController
public class MealController {

    private MealRepository mealRepository;
    private FoodRepository foodRepository;
    private UserRepository userRepository;

    @Autowired
    public MealController(MealRepository mealRepository,
                          FoodRepository foodRepository,
                          UserRepository userRepository) {
        this.mealRepository = mealRepository;
        this.foodRepository = foodRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/meals")
    public List<Meal> getAll(){
        return this.mealRepository.findAll();
    }

    @PostMapping("/meals")
    public Meal addMeal(@RequestBody MealDTO mealDTO) {

        MealBuilderInterface builder = new RequestMealBuilder(mealDTO, this.foodRepository, this.userRepository);
        MealDirector director = new MealDirector();
        return this.mealRepository.save(director.build(builder));
    }

    @GetMapping("/meals/{id}")
    public Meal getOne(@PathVariable Integer id){
        return this.mealRepository.findById(id).get();
    }

    @GetMapping("/meals/user/{userId}")
    public List<Meal> getOneByUser(@PathVariable Integer userId){
        return this.mealRepository.getAllByUserId(userId);
    }

    @PutMapping("/meals/{id}")
    public Meal update(@PathVariable Integer id, @RequestBody MealDTO mealDTO) {

        MealBuilderInterface builder = new RequestMealBuilder(mealDTO, this.foodRepository, this.userRepository);
        MealDirector director = new MealDirector();
        Meal meal = director.build(builder);
        meal.setId(id);
        return this.mealRepository.save(meal);
    }

    @DeleteMapping("/meals/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        Meal meal = mealRepository.findById(id).get();
        this.mealRepository.delete(meal);
    }
}
