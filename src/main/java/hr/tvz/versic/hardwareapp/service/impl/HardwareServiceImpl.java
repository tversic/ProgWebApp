package hr.tvz.versic.hardwareapp.service.impl;

import hr.tvz.versic.hardwareapp.command.HardwareCommand;
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
    public HardwareDTO findByValue(String code){
        Hardware hardware = hardwareRepo.findStringByValue(code).get();
        return hardwareToHardwareDTO(hardware);
    }

    @Override
    public List<HardwareDTO> findAll() {
        return hardwareRepo.findAll().stream().map(this::hardwareToHardwareDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<HardwareDTO> findByCode(String code) {
        if(hardwareRepo.findByCode(code).isPresent()) {
            HardwareDTO hardwareDTO = hardwareToHardwareDTO(hardwareRepo.findByCode(code).get());
            return Optional.of(hardwareDTO);
        }else{
            return Optional.empty();
        }
    }

    @Override
    public HardwareDTO save(HardwareCommand command){

        Optional<Hardware> hardwareOptional = hardwareRepo.save(hardwareCommandToHardware(command));
        if(hardwareOptional.isPresent()) {
            Hardware hardware = hardwareOptional.get();
            HardwareDTO hardwareDto =  hardwareToHardwareDTO(hardware);
            return hardwareDto;
        }
        else{
            return null;
        }
    }

    @Override
    public boolean delete (String code){
        if(hardwareRepo.delete(code)) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public HardwareDTO put(HardwareCommand hardwareCommand) {
        Hardware hardware = hardwareCommandToHardware(hardwareCommand);
        HardwareDTO hardwareDTO = hardwareToHardwareDTO(hardware);
        if(hardwareRepo.put(hardware).isPresent()) {
            return hardwareDTO;
        }
        else{
            return null;
        }
    }

    private HardwareDTO hardwareToHardwareDTO(Hardware hardware) {
        return new HardwareDTO(hardware.getName(), hardware.getPrice(), hardware.getCode());
    }

    private Hardware hardwareCommandToHardware(HardwareCommand hardware) {
        return new Hardware(hardware.getName(), hardware.getCode(),
                hardware.getPrice(), hardware.getHardwareType().toString(), hardware.getStock());
    }
}