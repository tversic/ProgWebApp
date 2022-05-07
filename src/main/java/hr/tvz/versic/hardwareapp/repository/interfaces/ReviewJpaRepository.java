package hr.tvz.versic.hardwareapp.repository.interfaces;

import hr.tvz.versic.hardwareapp.model.POJO.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewJpaRepository extends JpaRepository<Review, Long> {

    List<Review> findAll();

    @Query("SELECT r FROM Review r where r.id = ?1")
    Review findById(long id);
}