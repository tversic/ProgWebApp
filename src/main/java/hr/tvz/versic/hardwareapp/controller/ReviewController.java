package hr.tvz.versic.hardwareapp.controller;

import hr.tvz.versic.hardwareapp.model.DTO.ReviewDTO;
import hr.tvz.versic.hardwareapp.service.interfaces.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("review")
@CrossOrigin(origins = "http://localhost:4200")
public class ReviewController {

    private static ReviewService reviewService;
    public ReviewController(ReviewService reviewService){
        this.reviewService = reviewService;
    }

    @GetMapping
    public ResponseEntity<List<ReviewDTO>> getAllReviews(){
        List<ReviewDTO> reviewList = reviewService.getAll();
        if(reviewList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(reviewService.getAll());
    }

    @GetMapping(params = "hardwareCode")
    public List<ReviewDTO> getReviewsByCode(@RequestParam String hardwareCode){
        return reviewService.getAllByHardwareCode(hardwareCode);
    }
}
