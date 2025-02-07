package brainacad.org.restapi.Service.Level;

import brainacad.org.restapi.Model.DTO.CreateDTO.LevelCreateDTO;
import brainacad.org.restapi.Model.DTO.ResponseDTO.LevelResponseDTO;
import brainacad.org.restapi.Model.DTO.UpdateDTO.LevelUpdateDTO;
import brainacad.org.restapi.Model.Entity.Level;
import brainacad.org.restapi.Service.DAO_Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LevelService extends DAO_Service<LevelCreateDTO,LevelResponseDTO, LevelUpdateDTO>
{
    public Level findByName(String levelName);
}
