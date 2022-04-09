package hr.tvz.versic.hardwareapp.controller;

import hr.tvz.versic.hardwareapp.command.HardwareCommand;
import hr.tvz.versic.hardwareapp.model.DTO.HardwareDTO;
import org.springframework.http.HttpStatus;
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
        HardwareDTO hardwareDTO = hardwareService.findByCode(code);
        if (hardwareDTO != null){
            return ResponseEntity.status(HttpStatus.OK).body(hardwareDTO);
        }else
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hardwareDTO);
        }
    }

    @PostMapping
    public ResponseEntity<HardwareDTO> save(@Valid @RequestBody final HardwareCommand command){
        HardwareDTO hardwareDTO = hardwareService.save(command);
        if(hardwareDTO != null){
            return ResponseEntity.status(HttpStatus.OK).body(hardwareDTO);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hardwareDTO);
        }
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<HardwareDTO> delete(@Valid @PathVariable String code){
        if(hardwareService.delete(code)){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/{code}")
    public ResponseEntity<HardwareDTO> put(@Valid @RequestBody HardwareCommand hardwareCommand){
        HardwareDTO hardwareDTO = hardwareService.put(hardwareCommand);
        if(hardwareDTO != null){
            return ResponseEntity.status(HttpStatus.OK).body(hardwareDTO);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
