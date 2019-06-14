package project.spring_boot_api.Model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Planner")
public class PlannerItem {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;
    String date;
    String title;
    @ManyToOne
    @JoinColumn(name="meal_id")
    Meal meal;

    public PlannerItem() {
    }

    public PlannerItem(String date, String title, Meal meal) {
        this.date = date;
        this.title = title;
        this.meal = meal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }
}
