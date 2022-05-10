package hr.tvz.versic.hardwareapp.controller;

import hr.tvz.versic.hardwareapp.command.HardwareCommand;
import hr.tvz.versic.hardwareapp.enums.HardwareType;
import hr.tvz.versic.hardwareapp.model.DTO.HardwareDTO;
import hr.tvz.versic.hardwareapp.model.DTO.ReviewDTO;
import hr.tvz.versic.hardwareapp.service.interfaces.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import hr.tvz.versic.hardwareapp.service.interfaces.HardwareService;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("hardware")
@CrossOrigin(origins = "http://localhost:4200")
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

    @GetMapping("/value/{value}")
    public ResponseEntity<HardwareDTO> returnByValue(@PathVariable final String value){
        HardwareDTO hardwareDTO = hardwareService.findByValue(value);
        if(hardwareDTO != null){
            return ResponseEntity.status(HttpStatus.OK).body(hardwareDTO);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hardwareDTO);
        }
    }

    @GetMapping("/type")
    public Enum<HardwareType>[] HardwareType (){
        return HardwareType.values();
    }

    @GetMapping("/{code}")
    public ResponseEntity<HardwareDTO> returnByCode(@PathVariable final String code)
    {
        Optional<HardwareDTO> hardwareDTO = hardwareService.findByCode(code);
        if (hardwareDTO.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(hardwareDTO.get());
        }else
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
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
