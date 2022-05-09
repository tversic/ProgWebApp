package hr.tvz.versic.hardwareapp.service.interfaces;

import hr.tvz.versic.hardwareapp.model.POJO.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAll ();

    List<Review> getAllByHardwareId(Long id);
}
