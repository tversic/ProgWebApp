package hr.tvz.versic.hardwareapp.repository.impl;

import hr.tvz.versic.hardwareapp.enums.HardwareType;
import hr.tvz.versic.hardwareapp.model.POJO.Hardware;
import hr.tvz.versic.hardwareapp.repository.interfaces.HardwareRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class HardwareRepoImpl implements HardwareRepository {

    private List<Hardware> hardwares = new ArrayList<>(Arrays.asList(
            new Hardware("LenovoHDD", "0000", 300.00, HardwareType.STORAGE, 5),
            new Hardware("MX432DDR4", "0001", 80.00, HardwareType.RAM, 4),
            new Hardware("MX432DfasR4", "0002", 90.00, HardwareType.CPU, 4),
            new Hardware("MX432DfasR4", "0003", 100.00, HardwareType.GPU, 2  )
    ));

    @Override
    public List<Hardware> findAll() {
        return hardwares;
    }

    @Override
    public Optional<Hardware> findByCode(String code) {
        return hardwares.stream().filter(hardware -> Objects.equals(hardware.getCode(), code)).findAny();
    }

    @Override
    public Optional<Hardware> save(Hardware hardware) {
        List<Hardware> tmp = hardwares
                .stream().filter(f -> f.getCode().equals(hardware.getCode()))
                .collect(Collectors.toList());
        if(tmp.size() == 0)
        {
            hardwares.add(hardware);
            return Optional.of(hardware);
        }else{
            return Optional.empty();
        }
    }

    @Override
    public Optional<Hardware> put(Hardware hardware) {
        Optional<Hardware> returnHardware = hardwares
                .stream()
                .filter(hardware1 -> hardware1
                        .getCode()
                        .equals(hardware.getCode()))
                        .findAny();
        if(returnHardware.isPresent()){
            hardwares.stream().map(hardware1 -> {
                if(hardware1.getCode().equals(hardware.getCode())){
                    return hardware1;
                }else{
                    return hardware;
                }
            }).collect(Collectors.toList());
        }
        return returnHardware;
    }

    @Override
    public boolean delete(String code){
        List<Hardware> hardwareOptional = hardwares.stream()
                .filter(f -> f.getCode().equals(code))
                .collect(Collectors.toList());
        if(hardwareOptional.size() > 0){
             hardwares.removeIf(h -> h.getCode().equals(code));
            return true;
        }else{
            return false;
        }
    }

}
