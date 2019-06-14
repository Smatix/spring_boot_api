package project.spring_boot_api.DTO;

import java.util.List;

public class MealDTO {
    private String name;
    private Integer portions;
    private String owner;
    private List<Integer> foodList;

    public void setName(String name) {
        this.name = name;
    }

    public void setPortions(Integer portions) {
        this.portions = portions;
    }

    public void setFoodList(List<Integer> foodList) {
        this.foodList = foodList;
    }

    public String getName() {
        return name;
    }

    public Integer getPortions() {
        return portions;
    }

    public List<Integer> getFoodList() {
        return foodList;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
