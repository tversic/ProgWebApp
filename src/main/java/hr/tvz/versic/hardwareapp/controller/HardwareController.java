package hr.tvz.versic.hardwareapp.controller;

import hr.tvz.versic.hardwareapp.model.DTO.HardwareDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import hr.tvz.versic.hardwareapp.service.interfaces.HardwareService;

import java.util.List;
import java.util.Optional;


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
    @GetMapping(params = "code")
    public Optional<HardwareDTO> returnByCode(@RequestParam final String code)
    {
        return hardwareService.findByCode(code);
    }
}
