package brainacad.org.restapi.Mapping;

import brainacad.org.restapi.Mapping.Componet.LevelMapper;
import brainacad.org.restapi.Model.DTO.CreateDTO.Log_dataCreateDTO;
import brainacad.org.restapi.Model.DTO.ResponseDTO.Log_dataResponseDTO;
import brainacad.org.restapi.Model.DTO.UpdateDTO.Log_dataUpdateDTO;
import brainacad.org.restapi.Model.Entity.Level;
import brainacad.org.restapi.Model.Entity.Log_data;
import brainacad.org.restapi.Service.Level.LevelService;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = LevelMapper.class)
public interface Log_dataMapping {

    @Mapping(target = "level", source = "level_name", qualifiedByName = "mapStringToLevel")
    Log_data toEntity(Log_dataCreateDTO dto);

    @Mapping(target = "level", source = "level_name", qualifiedByName = "mapStringToLevel")
    Log_data toEntity(Log_dataUpdateDTO dto);

    @Mapping(target = "level_name", source = "level", qualifiedByName = "mapLevelToString")
    Log_dataResponseDTO toResponseDto(Log_data entity);

    @Mapping(target = "level_name", source = "level", qualifiedByName = "mapLevelToString")
    Log_dataCreateDTO toCreateDto(Log_data entity);

    @Mapping(target = "level_name", source = "level", qualifiedByName = "mapLevelToString")
    Log_dataUpdateDTO toUpdateDto(Log_data entity);
}
