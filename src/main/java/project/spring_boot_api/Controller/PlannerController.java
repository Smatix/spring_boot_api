package project.spring_boot_api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.spring_boot_api.DTO.PlannerDTO;
import project.spring_boot_api.Model.Meal;
import project.spring_boot_api.Model.PlannerItem;
import project.spring_boot_api.Repository.MealRepository;
import project.spring_boot_api.Repository.PlannerRepository;

import java.util.List;

@RestController
public class PlannerController {

    private PlannerRepository plannerRepository;
    private MealRepository mealRepository;

    @Autowired
    public PlannerController(PlannerRepository plannerRepository, MealRepository mealRepository) {
        this.plannerRepository = plannerRepository;
        this.mealRepository = mealRepository;
    }

    @GetMapping("/planner/{date}")
    public List<PlannerItem> getAllByDate(@PathVariable String date){
        return this.plannerRepository.getAllByDate(date);
    }

    @PostMapping("/planner")
    public PlannerItem addPlannerItem(@RequestBody PlannerDTO plannerDTO) {
        Meal meal = this.mealRepository.findById(plannerDTO.getMeal()).get();
        PlannerItem item = new PlannerItem();
        item.setDate(plannerDTO.getDate());
        item.setTitle(plannerDTO.getTitle());
        item.setMeal(meal);
        return plannerRepository.save(item);
    }

    @PutMapping("/planner/{id}")
    public PlannerItem updatePlannerItem(@PathVariable Integer id, @RequestBody PlannerDTO plannerDTO) {
        Meal meal = this.mealRepository.findById(plannerDTO.getMeal()).get();
        PlannerItem item = this.plannerRepository.findById(id).get();
        item.setDate(plannerDTO.getDate());
        item.setTitle(plannerDTO.getTitle());
        item.setMeal(meal);
        item.setId(id);
        return plannerRepository.save(item);
    }

    @DeleteMapping("/planner/{id}")
    public String delete(@PathVariable Integer id){
        PlannerItem item = this.plannerRepository.findById(id).get();
        this.plannerRepository.delete(item);
        return "Deleted";
    }
}
