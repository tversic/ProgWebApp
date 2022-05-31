package hr.tvz.versic.hardwareapp.service.interfaces;

import hr.tvz.versic.hardwareapp.model.DTO.ReviewDTO;

import java.util.List;

public interface ReviewService {
    List<ReviewDTO> getAll();

    List<ReviewDTO> getAllByHardwareCode(String code);

    ReviewDTO findByText(String text);
}

