package hr.tvz.versic.hardwareapp.service.interfaces;

import hr.tvz.versic.hardwareapp.command.HardwareCommand;
import hr.tvz.versic.hardwareapp.model.DTO.HardwareDTO;

import java.util.List;
import java.util.Optional;

public interface HardwareService {

    List<HardwareDTO> findAll();

    Optional<HardwareDTO> findByCode(String code);

    HardwareDTO save (HardwareCommand command);

    boolean delete (String code);

    HardwareDTO put (HardwareCommand hardwareCommand);

    HardwareDTO findByValue(String code);
}
