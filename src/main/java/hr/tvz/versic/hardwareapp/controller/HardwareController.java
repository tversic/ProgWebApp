package hr.tvz.versic.hardwareapp.controller;

import hr.tvz.versic.hardwareapp.command.HardwareCommand;
import hr.tvz.versic.hardwareapp.enums.HardwareType;
import hr.tvz.versic.hardwareapp.model.DTO.HardwareDTO;
import hr.tvz.versic.hardwareapp.model.POJO.Review;
import hr.tvz.versic.hardwareapp.service.interfaces.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import hr.tvz.versic.hardwareapp.service.interfaces.HardwareService;
import javax.validation.Valid;
import java.util.List;



@RestController
@RequestMapping("hardware")
@CrossOrigin(origins = "http://localhost:4200")
public class HardwareController {

    private static HardwareService hardwareService;
    private static ReviewService reviewService;
    public HardwareController(HardwareService hardwareService, ReviewService reviewService) {
        this.hardwareService = hardwareService;
        this.reviewService = reviewService;
    }

    @GetMapping("/api/review/all")
    public ResponseEntity<List<Review>> getAllReviews(){
        List<Review> reviewList = reviewService.getAll();
        if(reviewList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(reviewService.getAll());
    }

    @GetMapping("/api/review/all/{id}")
    public ResponseEntity<List<Review>> getReviewByHardwareId(@PathVariable Long id){
        List<Review> reviewList = reviewService.getAllByHardwareId(id);
        if(reviewList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(reviewList);
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
