package hr.tvz.versic.hardwareapp.service.impl;

import hr.tvz.versic.hardwareapp.model.POJO.Review;
import hr.tvz.versic.hardwareapp.repository.interfaces.ReviewJpaRepository;
import hr.tvz.versic.hardwareapp.service.interfaces.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private static ReviewJpaRepository reviewJpaRepository;
    ReviewServiceImpl(ReviewJpaRepository reviewJpaRepository){
        this.reviewJpaRepository = reviewJpaRepository;
    }

    @Override
    public List<Review> getAll() {
        return reviewJpaRepository.findAll();
    }

    @Override
    public List<Review> getAllByHardwareId(Long id) {
        return reviewJpaRepository.findByHardwareId(id);
    }
}
