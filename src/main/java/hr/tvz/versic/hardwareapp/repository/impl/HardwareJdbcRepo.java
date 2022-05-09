package hr.tvz.versic.hardwareapp.repository.impl;

import com.sun.source.tree.PackageTree;
import hr.tvz.versic.hardwareapp.enums.HardwareType;
import hr.tvz.versic.hardwareapp.model.POJO.Hardware;
import hr.tvz.versic.hardwareapp.model.POJO.Review;
import hr.tvz.versic.hardwareapp.repository.interfaces.HardwareRepository;
import hr.tvz.versic.hardwareapp.repository.interfaces.ReviewJpaRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Primary
@Repository
public class HardwareJdbcRepo implements HardwareRepository {

    private static final String SELECT_ALL = "SELECT id, name, code, price, type, stock FROM hardware";
    private static final String SELECT_STRING = "SELECT id, name, code, price, type, stock from hardware WHERE LOWER(name) like CONCAT('%' ,? ,'%')";

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert jdbcInsert;
    private final ReviewJpaRepository reviewJpaRepository;

    public HardwareJdbcRepo(JdbcTemplate jdbcTemplate, ReviewJpaRepository reviewJpaRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.reviewJpaRepository = reviewJpaRepository;
        this.jdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("hardware")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public Optional<Hardware> findStringByValue(String value){
        List<Hardware> hardwares = jdbcTemplate.query(SELECT_STRING, this::mapRowToHardware, value.toLowerCase());
        if (hardwares.size() > 0){
            return Optional.ofNullable(jdbcTemplate.query(SELECT_STRING, this::mapRowToHardware, value.toLowerCase()).get(0));
        }
        else {
            return Optional.empty();
        }
    }

    @Override
    public List<Hardware> findAll() {
        List<Hardware> hardwares = List.copyOf(jdbcTemplate.query(SELECT_ALL, this::mapRowToHardware));
       // System.out.println(hardwares.get(0).getReview().get(0).getName());
        return List.copyOf(jdbcTemplate.query(SELECT_ALL, this::mapRowToHardware));
    }

    @Override
    public Optional<Hardware> findByCode(String code) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(SELECT_ALL + " where code = ?", this::mapRowToHardware, code));
    }

    @Override
    public Optional<Hardware> save(Hardware hardware) {
        hardware.setId(saveHardware(hardware));
        if(hardware.getId() != null){
            return Optional.ofNullable(hardware);
        }
        return Optional.empty();
    }

    private Long saveHardware(Hardware hardware){
        Map<String, Object> values = new HashMap<>();
        values.put("code", hardware.getCode());
        values.put("name", hardware.getName());
        values.put("price", hardware.getPrice());
        values.put("type", hardware.getType());
        values.put("stock", hardware.getStock());

        return jdbcInsert.executeAndReturnKey(values).longValue();
    }

    @Override
    public Optional<Hardware> put(Hardware hardware) {
        return Optional.empty();
    }

    @Override
    public boolean delete(String code) {
        jdbcTemplate.update("DELETE FROM hardware where code = ?", code);
        return true;
    }


    private Hardware mapRowToHardware(ResultSet rs, int rowNum) throws SQLException{
        Hardware h1 =  new Hardware(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("code"),
                rs.getDouble("price"),
                rs.getString("type"),
                rs.getInt("stock")
        );
       // List<Review> review = reviewJpaRepository.findByHardwareId(h1.getId());
        //h1.setReview(reviewJpaRepository.findByHardwareId(h1.getId()));
        return h1;
    }
}
