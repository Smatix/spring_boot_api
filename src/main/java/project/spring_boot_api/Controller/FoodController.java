package project.spring_boot_api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.spring_boot_api.Model.Food;
import project.spring_boot_api.Repository.FoodRepository;
import project.spring_boot_api.Repository.UserRepository;

import java.util.List;

@RestController
public class FoodController {

    private FoodRepository foodRespository;

    @Autowired
    public FoodController(FoodRepository foodRespository) {
        this.foodRespository = foodRespository;
    }

    @GetMapping("/foods")
    public List<Food> getAllFood() {
        return foodRespository.findAll();
    }

    @PostMapping("/foods")
    public Food addFood(@RequestBody Food food) {
        return foodRespository.save(food);
    }

    @PutMapping("/foods/{id}")
    public Food updateFood(@PathVariable Integer id, @RequestBody Food food) {
        food.setId(id);
        return foodRespository.save(food);
    }

    @DeleteMapping("/foods/{id}")
    public String delete(@PathVariable Integer id) {
        Food food = foodRespository.findById(id).get();
        foodRespository.delete(food);
        return "Deleted";
    }

    @GetMapping("/foods/{id}")
    public Food getById(@PathVariable Integer id) {
        return foodRespository.findById(id).get();
    }

    @GetMapping("/foods/one/{name}")
    public Food getByName(@PathVariable  String name) {
        return foodRespository.findByName(name);
    }



}
