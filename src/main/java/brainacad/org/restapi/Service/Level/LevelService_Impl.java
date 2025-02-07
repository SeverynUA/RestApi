package brainacad.org.restapi.Service.Level;

import brainacad.org.restapi.Mapping.LevelMapping;
import brainacad.org.restapi.Model.DTO.CreateDTO.LevelCreateDTO;
import brainacad.org.restapi.Model.DTO.ResponseDTO.LevelResponseDTO;
import brainacad.org.restapi.Model.DTO.UpdateDTO.LevelUpdateDTO;
import brainacad.org.restapi.Model.Entity.Level;
import brainacad.org.restapi.Repository.Level_DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LevelService_Impl implements LevelService
{

    @Autowired
    private Level_DAO levelRepository;

    @Qualifier("levelMapping")
    @Autowired
    private LevelMapping levelMapper;

    @Override
    public LevelCreateDTO create(LevelCreateDTO dto)
    {
        Level level = levelMapper.toEntity(dto);
        Level savedLevel = levelRepository.save(level);
        return levelMapper.toCreateDto(savedLevel);
    }

    public Level findByName(String levelName) {
        return levelRepository.findByName(levelName)
                .orElseThrow(() -> new RuntimeException("Level not found: " + levelName));
    }

    @Override
    public LevelResponseDTO getById(Long id)
    {
        Level level = levelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Level not found"));
        return levelMapper.toResponseDto(level);
    }

    @Override
    public List<LevelResponseDTO> getAll()
    {
        return levelRepository.findAll().stream()
                .map(levelMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public LevelUpdateDTO update(Long id, LevelUpdateDTO dto)
    {
        Level existingLevel = levelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Level not found"));

        existingLevel.setName(dto.getName());
        Level updatedLevel = levelRepository.save(existingLevel);

        return levelMapper.toUpdateDto(updatedLevel);
    }

    @Override
    public void delete(Long id)
    {
        levelRepository.deleteById(id);
    }

    @Override
    public JpaRepository<?, ?> getRepository()
    {
        return levelRepository;
    }
}
