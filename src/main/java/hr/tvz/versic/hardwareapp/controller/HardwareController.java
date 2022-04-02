package hr.tvz.versic.hardwareapp.controller;

import hr.tvz.versic.hardwareapp.command.HardwareCommand;
import hr.tvz.versic.hardwareapp.model.DTO.HardwareDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import hr.tvz.versic.hardwareapp.service.interfaces.HardwareService;
import javax.validation.Valid;
import java.util.List;



@RestController
@RequestMapping("hardware")
public class HardwareController {

    private static HardwareService hardwareService;
    public HardwareController(HardwareService hardwareService) {
        this.hardwareService = hardwareService;
    }

    @GetMapping
    public List<HardwareDTO> getAllHardwares()
    {
        return hardwareService.findAll();
    }

    @GetMapping("/{code}")
    public ResponseEntity<HardwareDTO> returnByCode(@PathVariable final String code)
    {
        return hardwareService.findByCode(code);
    }

    @PostMapping
    public ResponseEntity<HardwareDTO> save(@Valid @RequestBody final HardwareCommand command){
        return hardwareService.save(command);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<HardwareDTO> delete(@Valid @PathVariable String code){
        return hardwareService.delete(code);
    }
}
