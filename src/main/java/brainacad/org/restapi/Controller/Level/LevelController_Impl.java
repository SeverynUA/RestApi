package brainacad.org.restapi.Controller.Level;

import brainacad.org.restapi.Model.DTO.CreateDTO.LevelCreateDTO;
import brainacad.org.restapi.Model.DTO.ResponseDTO.LevelResponseDTO;
import brainacad.org.restapi.Model.DTO.UpdateDTO.LevelUpdateDTO;
import brainacad.org.restapi.Service.Level.LevelService;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/levels")
public class LevelController_Impl implements LevelController
{

    private final LevelService levelService;

    public LevelController_Impl(LevelService levelService)
    {
        this.levelService = levelService;
    }

    @PostMapping
    @Override
    public ResponseEntity<LevelCreateDTO> create(@RequestBody LevelCreateDTO dto)
    {
        LevelCreateDTO createdLevel = levelService.create(dto);
        return ResponseEntity.ok(createdLevel);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<LevelResponseDTO> getById(@PathVariable @NotNull Long id)
    {
        LevelResponseDTO level = levelService.getById(id);
        return ResponseEntity.ok(level);
    }

    @GetMapping
    @Override
    public ResponseEntity<List<LevelResponseDTO>> getAll() {
        List<LevelResponseDTO> levels = levelService.getAll();
        return ResponseEntity.ok(levels);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<LevelUpdateDTO> update(@PathVariable @NotNull Long id, @RequestBody LevelUpdateDTO dto)
    {
        LevelUpdateDTO updatedLevel = levelService.update(id, dto);
        return ResponseEntity.ok(updatedLevel);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> delete(@PathVariable @NotNull Long id)
    {
        levelService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
