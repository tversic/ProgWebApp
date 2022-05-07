package hr.tvz.versic.hardwareapp.repository.interfaces;

import hr.tvz.versic.hardwareapp.model.POJO.Hardware;

import java.util.List;
import java.util.Optional;

public interface HardwareRepository {
    List<Hardware> findAll();
    Optional<Hardware> findByCode(String code);
    Optional<Hardware> save(Hardware hardware);
    Optional<Hardware> put(Hardware hardware);
    Optional<Hardware> findStringByValue(String value);
    boolean delete(String code);
}
