package brainacad.org.restapi.Mapping;

import brainacad.org.restapi.Model.DTO.CreateDTO.LevelCreateDTO;
import brainacad.org.restapi.Model.DTO.ResponseDTO.LevelResponseDTO;
import brainacad.org.restapi.Model.DTO.UpdateDTO.LevelUpdateDTO;
import brainacad.org.restapi.Model.Entity.Level;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LevelMapping
{
    Level toEntity(LevelCreateDTO dto);
    Level toEntity(LevelUpdateDTO dto);
    LevelResponseDTO toResponseDto(Level entity);
    LevelCreateDTO toCreateDto(Level entity);
    LevelUpdateDTO toUpdateDto(Level entity);
}
