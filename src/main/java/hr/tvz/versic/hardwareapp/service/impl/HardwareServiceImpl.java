package hr.tvz.versic.hardwareapp.service.impl;

import hr.tvz.versic.hardwareapp.enums.HardwareType;
import hr.tvz.versic.hardwareapp.model.DTO.HardwareDTO;
import hr.tvz.versic.hardwareapp.model.POJO.Hardware;
import hr.tvz.versic.hardwareapp.repository.interfaces.HardwareRepository;
import hr.tvz.versic.hardwareapp.service.interfaces.HardwareService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HardwareServiceImpl implements HardwareService {
    private static HardwareRepository hardwareRepo;
    public HardwareServiceImpl(HardwareRepository hardwareRepo) {
        this.hardwareRepo = hardwareRepo;
    }

    @Override
    public List<HardwareDTO> findAll() {
        return hardwareRepo.findAll().stream().map(this::hardwareToHardwareDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<HardwareDTO> findByCode(String code) {
        return hardwareRepo.findByCode(code).map(this::hardwareToHardwareDTO);
    }

    private HardwareDTO hardwareToHardwareDTO(Hardware hardware)
    {
        return new HardwareDTO(hardware.getName(), hardware.getPrice());
    }
}
