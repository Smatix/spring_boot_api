package project.spring_boot_api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.spring_boot_api.Model.PlannerItem;

import java.util.List;

public interface PlannerRepository extends JpaRepository<PlannerItem, Integer> {
    List<PlannerItem> getAllByDate(String date);
}
