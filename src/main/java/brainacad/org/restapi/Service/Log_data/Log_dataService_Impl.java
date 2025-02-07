package brainacad.org.restapi.Service.Log_data;

import brainacad.org.restapi.Mapping.LevelMapping;
import brainacad.org.restapi.Mapping.Log_dataMapping;
import brainacad.org.restapi.Model.DTO.CreateDTO.LevelCreateDTO;
import brainacad.org.restapi.Model.DTO.CreateDTO.Log_dataCreateDTO;
import brainacad.org.restapi.Model.DTO.ResponseDTO.LevelResponseDTO;
import brainacad.org.restapi.Model.DTO.ResponseDTO.Log_dataResponseDTO;
import brainacad.org.restapi.Model.DTO.UpdateDTO.LevelUpdateDTO;
import brainacad.org.restapi.Model.DTO.UpdateDTO.Log_dataUpdateDTO;
import brainacad.org.restapi.Model.Entity.Level;
import brainacad.org.restapi.Model.Entity.Log_data;
import brainacad.org.restapi.Repository.Level_DAO;
import brainacad.org.restapi.Repository.Log_dataDAO;
import brainacad.org.restapi.Service.Level.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Log_dataService_Impl implements Log_dataService
{
    @Autowired
    Log_dataDAO log_dataDAO;

    @Autowired
    private Log_dataMapping log_dataMapping;
    @Autowired
    private Level_DAO level_DAO;

    @Override
    public Log_dataCreateDTO create(Log_dataCreateDTO dto)
    {
        Log_data log_data = log_dataMapping.toEntity(dto);
        Log_data savedLog_data = log_dataDAO.save(log_data);
        return log_dataMapping.toCreateDto(savedLog_data);
    }

    @Override
    public Log_dataResponseDTO getById(Long id)
    {
        Log_data log_data = log_dataDAO.findById(id).orElseThrow(() -> new RuntimeException("Log_data not found"));
        return log_dataMapping.toResponseDto(log_data);
    }

    @Override
    public List<Log_dataResponseDTO> getAll()
    {
        return log_dataDAO.findAll().stream()
                .map(log_dataMapping::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public Log_dataUpdateDTO update(Long id, Log_dataUpdateDTO dto) {
        Log_data existingLogData = log_dataDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("Log data not found"));

        Level level = level_DAO.findByName(dto.getLevel_name())
                .orElseThrow(() -> new RuntimeException("Level not found"));

        existingLogData.setLevel(level);
        existingLogData.setSrc(dto.getSrc());
        existingLogData.setMessage(dto.getMessage());

        Log_data updatedLogData = log_dataDAO.save(existingLogData);

        return log_dataMapping.toUpdateDto(updatedLogData);
    }


    @Override
    public void delete(Long id)
    {
        log_dataDAO.deleteById(id);
    }

    @Override
    public JpaRepository<?, ?> getRepository() {
        return log_dataDAO;
    }
}
