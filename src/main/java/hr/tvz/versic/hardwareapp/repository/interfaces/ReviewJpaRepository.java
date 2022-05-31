package hr.tvz.versic.hardwareapp.repository.interfaces;

import hr.tvz.versic.hardwareapp.model.POJO.Hardware;
import hr.tvz.versic.hardwareapp.model.POJO.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewJpaRepository extends JpaRepository<Review, Long> {

    List<Review> findAll();

    Review findById(long id);

    Review findByTekstContaining(String text);

    List<Review> findByHardwareCode(String code);
}