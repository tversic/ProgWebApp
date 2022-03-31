package hr.tvz.versic.hardwareapp.repository.impl;

import hr.tvz.versic.hardwareapp.enums.HardwareType;
import hr.tvz.versic.hardwareapp.model.POJO.Hardware;
import hr.tvz.versic.hardwareapp.repository.interfaces.HardwareRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class HardwareRepoImpl implements HardwareRepository {

    private List<Hardware> hardwares = Arrays.asList(
            new Hardware("LenovoHDD", "0000", 300.00, HardwareType.STORAGE),
            new Hardware("MX432DDR4", "0001", 80.00, HardwareType.RAM)
    );

    @Override
    public List<Hardware> findAll() {
        return hardwares;
    }

    @Override
    public Optional<Hardware> findByCode(String code) {
        return hardwares.stream().filter(hardware -> Objects.equals(hardware.getCode(), code)).findAny();
    }
}
