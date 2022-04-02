package hr.tvz.versic.hardwareapp.repository.interfaces;

import hr.tvz.versic.hardwareapp.model.DTO.HardwareDTO;
import hr.tvz.versic.hardwareapp.model.POJO.Hardware;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface HardwareRepository {
    List<Hardware> findAll();
    Optional<Hardware> findByCode(String code);
    Optional<Hardware> save(Hardware hardware);
    boolean delete(String code);
}
