package brainacad.org.restapi.Service.Log_data;

import brainacad.org.restapi.Model.DTO.CreateDTO.Log_dataCreateDTO;
import brainacad.org.restapi.Model.DTO.ResponseDTO.Log_dataResponseDTO;
import brainacad.org.restapi.Model.DTO.UpdateDTO.Log_dataUpdateDTO;
import brainacad.org.restapi.Model.Entity.Level;
import brainacad.org.restapi.Service.DAO_Service;

public interface Log_dataService extends DAO_Service<Log_dataCreateDTO, Log_dataResponseDTO, Log_dataUpdateDTO>
{
}
