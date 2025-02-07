package brainacad.org.restapi.Controller.Log_data;

import brainacad.org.restapi.Controller.DAO_Controller;
import brainacad.org.restapi.Model.DTO.CreateDTO.Log_dataCreateDTO;
import brainacad.org.restapi.Model.DTO.ResponseDTO.Log_dataResponseDTO;
import brainacad.org.restapi.Model.DTO.UpdateDTO.Log_dataUpdateDTO;

public interface Log_dataController  extends DAO_Controller<Log_dataCreateDTO, Log_dataResponseDTO, Log_dataUpdateDTO> {
}
