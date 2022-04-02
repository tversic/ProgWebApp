package hr.tvz.versic.hardwareapp.service.interfaces;

import hr.tvz.versic.hardwareapp.command.HardwareCommand;
import hr.tvz.versic.hardwareapp.model.DTO.HardwareDTO;
import hr.tvz.versic.hardwareapp.model.POJO.Hardware;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface HardwareService {

    List<HardwareDTO> findAll();

    ResponseEntity<HardwareDTO> findByCode(String code);

    ResponseEntity<HardwareDTO> save (HardwareCommand command);

    ResponseEntity<HardwareDTO> delete (String code);
}
