package brainacad.org.restapi.Controller.Level;

import brainacad.org.restapi.Controller.DAO_Controller;
import brainacad.org.restapi.Model.DTO.CreateDTO.LevelCreateDTO;
import brainacad.org.restapi.Model.DTO.ResponseDTO.LevelResponseDTO;
import brainacad.org.restapi.Model.DTO.UpdateDTO.LevelUpdateDTO;

public interface LevelController extends DAO_Controller <LevelCreateDTO, LevelResponseDTO, LevelUpdateDTO>
{

}
