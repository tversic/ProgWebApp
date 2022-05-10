package hr.tvz.versic.hardwareapp.service.impl;

import hr.tvz.versic.hardwareapp.model.DTO.ReviewDTO;
import hr.tvz.versic.hardwareapp.model.POJO.Review;
import hr.tvz.versic.hardwareapp.repository.interfaces.ReviewJpaRepository;
import hr.tvz.versic.hardwareapp.service.interfaces.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {

    private static ReviewJpaRepository reviewJpaRepository;
    ReviewServiceImpl(ReviewJpaRepository reviewJpaRepository){
        this.reviewJpaRepository = reviewJpaRepository;
    }

    @Override
    public List<ReviewDTO> getAll() {
        return reviewJpaRepository.findAll().stream()
                .map(this::mapReviewToReviewDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReviewDTO> getAllByHardwareCode(String code) {
        return reviewJpaRepository.findByHardwareCode(code).stream()
                .map(this::mapReviewToReviewDTO)
                .collect(Collectors.toList());
    }

    private ReviewDTO mapReviewToReviewDTO(Review review){
        return new ReviewDTO(review.getName(), review.getTekst(), review.getOcjena());
    }
}
