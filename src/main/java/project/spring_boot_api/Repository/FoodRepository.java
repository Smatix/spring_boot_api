package project.spring_boot_api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.spring_boot_api.Model.Food;
import project.spring_boot_api.Model.User;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {

    Food findByName(String name);

}
