package project.spring_boot_api.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Food")
public class Food {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private double weight;
    private double calories;
    private double proteins;
    private double carbs;
    private double fats;
    @ManyToMany(mappedBy = "ingredients")
    private List<Meal> meals;

    public Food() {
    }

    public Food(Integer id,
                String name,
                double weight,
                double calories,
                double proteins,
                double carbs,
                double fats) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.calories = calories;
        this.proteins = proteins;
        this.carbs = carbs;
        this.fats = fats;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getProteins() {
        return proteins;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public double getCarbs() {
        return carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public double getFats() {
        return fats;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }
}
