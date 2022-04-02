package hr.tvz.versic.hardwareapp.service.impl;

import hr.tvz.versic.hardwareapp.command.HardwareCommand;
import hr.tvz.versic.hardwareapp.enums.HardwareType;
import hr.tvz.versic.hardwareapp.model.DTO.HardwareDTO;
import hr.tvz.versic.hardwareapp.model.POJO.Hardware;
import hr.tvz.versic.hardwareapp.repository.interfaces.HardwareRepository;
import hr.tvz.versic.hardwareapp.service.interfaces.HardwareService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<HardwareDTO> findByCode(String code) {
        if(hardwareRepo.findByCode(code).isPresent())
        {
            HardwareDTO hardwareDTO = hardwareToHardwareDTO(hardwareRepo.findByCode(code).get());
            return ResponseEntity.status(HttpStatus.FOUND).body(hardwareDTO);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Override
    public ResponseEntity<HardwareDTO> save(HardwareCommand command){

        Optional<Hardware> hardwareOptional = hardwareRepo.save(hardwareCommandToHardware(command));
        if(hardwareOptional.isPresent()) {
            Hardware hardware = hardwareOptional.get();
            HardwareDTO hardwareDto =  hardwareToHardwareDTO(hardware);
            return ResponseEntity.status(HttpStatus.CREATED).body(hardwareDto);
        }
        else{
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @Override
    public ResponseEntity<HardwareDTO> delete (String code){
        if(hardwareRepo.delete(code))
        {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    private HardwareDTO hardwareToHardwareDTO(Hardware hardware)
    {
        return new HardwareDTO(hardware.getName(), hardware.getPrice());
    }

    private Hardware hardwareCommandToHardware(HardwareCommand hardware)
    {
        return new Hardware(hardware.getName(), hardware.getCode(),
                hardware.getPrice(), hardware.getHardwareType(), hardware.getStock());
    }
}
