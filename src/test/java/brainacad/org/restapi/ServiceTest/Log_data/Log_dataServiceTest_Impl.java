package brainacad.org.restapi.ServiceTest.Log_data;

import brainacad.org.restapi.Mapping.Log_dataMapping;
import brainacad.org.restapi.Model.DTO.CreateDTO.Log_dataCreateDTO;
import brainacad.org.restapi.Model.DTO.ResponseDTO.Log_dataResponseDTO;
import brainacad.org.restapi.Model.DTO.UpdateDTO.Log_dataUpdateDTO;
import brainacad.org.restapi.Model.Entity.Level;
import brainacad.org.restapi.Model.Entity.Log_data;
import brainacad.org.restapi.Repository.Level_DAO;
import brainacad.org.restapi.Repository.Log_dataDAO;
import brainacad.org.restapi.Service.Log_data.Log_dataService_Impl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class Log_dataServiceTest_Impl implements Log_dataServiceTest {

    @InjectMocks
    private Log_dataService_Impl logDataService;

    @Mock
    private Log_dataDAO logDataRepository;

    @Mock
    private Log_dataMapping logDataMapper;

    @Mock
    private Level_DAO levelRepository;

    private Log_dataCreateDTO logDataCreateDTO;
    private Log_dataResponseDTO logDataResponseDTO;
    private Log_dataUpdateDTO logDataUpdateDTO;
    private Log_data logDataEntity;
    private Level levelEntity;

    @Override
    @BeforeEach
    public void setUp() {
        this.levelEntity = Level.builder().id(1L).name("Error").build();
        this.logDataCreateDTO = Log_dataCreateDTO.builder().level_name("Error").src("System").message("Something went wrong").build();
        this.logDataResponseDTO = Log_dataResponseDTO.builder().level_name("Error").src("System").message("Something went wrong").build();
        this.logDataUpdateDTO = Log_dataUpdateDTO.builder().id(1L).level_name("Error").src("Updated System").message("Updated message").build();
        this.logDataEntity = Log_data.builder().id(1L).level(levelEntity).src("System").message("Something went wrong").build();

        lenient().when(levelRepository.findByName("Error")).thenReturn(Optional.of(levelEntity));
        lenient().when(logDataMapper.toEntity(logDataCreateDTO)).thenReturn(logDataEntity);
        lenient().when(logDataRepository.save(any(Log_data.class))).thenReturn(logDataEntity);
        lenient().when(logDataMapper.toCreateDto(logDataEntity)).thenReturn(logDataCreateDTO);
        lenient().when(logDataMapper.toResponseDto(logDataEntity)).thenReturn(logDataResponseDTO);
        lenient().when(logDataMapper.toUpdateDto(logDataEntity)).thenReturn(logDataUpdateDTO);
    }

    @Override
    @Test
    public void create_ReturnsClass_WhenValidInputProvided()
    {
        Log_dataCreateDTO result = logDataService.create(logDataCreateDTO);
        assertNotNull(result);
        assertEquals("Error", result.getLevel_name());
        verify(logDataRepository, times(1)).save(any(Log_data.class));
    }

    @Override
    @Test
    public void getById_ReturnsClass_WhenRequestExists()
    {
        when(logDataRepository.findById(1L)).thenReturn(Optional.of(logDataEntity));
        Log_dataResponseDTO result = logDataService.getById(1L);
        assertNotNull(result);
        assertEquals("Error", result.getLevel_name());
        verify(logDataRepository, times(1)).findById(1L);
    }

    @Override
    @Test
    public void getAll_ReturnsList_WhenDataExist()
    {
        when(logDataRepository.findAll()).thenReturn(List.of(logDataEntity));
        List<Log_dataResponseDTO> result = logDataService.getAll();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Error", result.get(0).getLevel_name());
        verify(logDataRepository, times(1)).findAll();
    }

    @Override
    @Test
    public void update_UpdatesEntity_WhenValidInputProvided()
    {
        when(logDataRepository.findById(1L)).thenReturn(Optional.of(logDataEntity));
        when(logDataRepository.save(any(Log_data.class))).thenReturn(logDataEntity);
        when(levelRepository.findByName("Error")).thenReturn(Optional.of(levelEntity));

        Log_dataUpdateDTO result = logDataService.update(1L, logDataUpdateDTO);

        assertNotNull(result);
        assertEquals("Updated System", result.getSrc());
        assertEquals("Updated message", result.getMessage());
        verify(logDataRepository, times(1)).findById(1L);
        verify(logDataRepository, times(1)).save(any(Log_data.class));
    }

    @Override
    @Test
    public void delete_DoesNotThrow_WhenRequestExists()
    {
        lenient().when(logDataRepository.existsById(1L)).thenReturn(true);
        doNothing().when(logDataRepository).deleteById(1L);
        assertDoesNotThrow(() -> logDataService.delete(1L));
        verify(logDataRepository, times(1)).deleteById(1L);
    }
}
