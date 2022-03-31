package hr.tvz.versic.hardwareapp.service.interfaces;

import hr.tvz.versic.hardwareapp.model.DTO.HardwareDTO;

import java.util.List;
import java.util.Optional;

public interface HardwareService {

    List<HardwareDTO> findAll();

    Optional<HardwareDTO> findByCode(String code);
}
