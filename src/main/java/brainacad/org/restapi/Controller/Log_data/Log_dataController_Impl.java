package brainacad.org.restapi.Controller.Log_data;

import brainacad.org.restapi.Model.DTO.CreateDTO.Log_dataCreateDTO;
import brainacad.org.restapi.Model.DTO.ResponseDTO.Log_dataResponseDTO;
import brainacad.org.restapi.Model.DTO.UpdateDTO.Log_dataUpdateDTO;
import brainacad.org.restapi.Service.Log_data.Log_dataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/log_data")
public class Log_dataController_Impl implements Log_dataController
{

    private final Log_dataService logDataService;

    @Autowired
    public Log_dataController_Impl(Log_dataService logDataService)
    {
        this.logDataService = logDataService;
    }

    @PostMapping
    @Override
    public ResponseEntity<Log_dataCreateDTO> create(@RequestBody Log_dataCreateDTO dto)
    {
        Log_dataCreateDTO createdLog = logDataService.create(dto);
        return ResponseEntity.ok(createdLog);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Log_dataResponseDTO> getById(@PathVariable Long id)
    {
        Log_dataResponseDTO logData = logDataService.getById(id);
        return ResponseEntity.ok(logData);
    }

    @GetMapping
    @Override
    public ResponseEntity<List<Log_dataResponseDTO>> getAll()
    {
        List<Log_dataResponseDTO> logs = logDataService.getAll();
        return ResponseEntity.ok(logs);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<Log_dataUpdateDTO> update(@PathVariable Long id, @RequestBody Log_dataUpdateDTO dto)
    {
        Log_dataUpdateDTO updatedLog = logDataService.update(id, dto);
        return ResponseEntity.ok(updatedLog);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> delete(@PathVariable Long id)
    {
        logDataService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

