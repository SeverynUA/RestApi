package brainacad.org.restapi.ServiceTest.Level;

import brainacad.org.restapi.Mapping.LevelMapping;
import brainacad.org.restapi.Model.DTO.CreateDTO.LevelCreateDTO;
import brainacad.org.restapi.Model.DTO.ResponseDTO.LevelResponseDTO;
import brainacad.org.restapi.Model.DTO.UpdateDTO.LevelUpdateDTO;
import brainacad.org.restapi.Model.Entity.Level;
import brainacad.org.restapi.Repository.Level_DAO;
import brainacad.org.restapi.RestApiApplication;
import brainacad.org.restapi.Service.Level.LevelService_Impl;
import brainacad.org.restapi.ServiceTest.CRUDService_Abstract;
import brainacad.org.restapi.ServiceTest.CRUDService_Interface;
import jakarta.annotation.PostConstruct;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class LevelServiceTest_Impl implements LevelServiceTest {

    @Mock
    private Level_DAO levelRepository;

    @Mock
    private LevelMapping levelMapper;

    @InjectMocks
    private LevelService_Impl levelService;

    private LevelCreateDTO levelCreateDTO;
    private LevelResponseDTO levelResponseDTO;
    private LevelUpdateDTO levelUpdateDTO;
    private Level levelEntity;

    @BeforeEach
    @Override
    public void setUp()
    {
        this.levelCreateDTO = LevelCreateDTO.builder().name("Test Level").build();
        this.levelResponseDTO = LevelResponseDTO.builder().name("Test Level").build();
        this.levelUpdateDTO = LevelUpdateDTO.builder().id(1L).name("Updated Level").build();
        this.levelEntity = Level.builder().id(1L).name("Test Level").build();

        lenient().when(levelMapper.toEntity(levelCreateDTO)).thenReturn(levelEntity);
        lenient().when(levelRepository.save(any(Level.class))).thenReturn(levelEntity);
        lenient().when(levelMapper.toCreateDto(levelEntity)).thenReturn(levelCreateDTO);
        lenient().when(levelMapper.toResponseDto(levelEntity)).thenReturn(levelResponseDTO);
        lenient().when(levelMapper.toUpdateDto(levelEntity)).thenReturn(levelUpdateDTO);
    }

    @Test
    @Override
    public void create_ReturnsClass_WhenValidInputProvided()
    {
        LevelCreateDTO result = levelService.create(levelCreateDTO);

        assertNotNull(result);
        assertEquals("Test Level", result.getName());
        verify(levelRepository, times(1)).save(any(Level.class));
    }

    @Test
    @Override
    public void getById_ReturnsClass_WhenRequestExists()
    {
        when(levelRepository.findById(1L)).thenReturn(Optional.of(levelEntity));

        LevelResponseDTO result = levelService.getById(1L);

        assertNotNull(result);
        assertEquals("Test Level", result.getName());
        verify(levelRepository, times(1)).findById(1L);
    }

    @Test
    @Override
    public void getAll_ReturnsList_WhenLevelExist()
    {
        when(levelRepository.findAll()).thenReturn(List.of(levelEntity));

        List<LevelResponseDTO> result = levelService.getAll();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Test Level", result.get(0).getName());
        verify(levelRepository, times(1)).findAll();
    }

    @Test
    @Override
    public void update_UpdatesEntity_WhenValidInputProvided()
    {
        when(levelRepository.findById(1L)).thenReturn(Optional.of(levelEntity));
        when(levelRepository.save(any(Level.class))).thenReturn(levelEntity);

        LevelUpdateDTO result = levelService.update(1L, levelUpdateDTO);

        assertNotNull(result);
        assertEquals("Updated Level", result.getName());
        verify(levelRepository, times(1)).findById(1L);
        verify(levelRepository, times(1)).save(any(Level.class));
    }

    @Test
    @Override
    public void delete_DoesNotThrow_WhenRequestExists()
    {
        lenient().when(levelRepository.existsById(1L)).thenReturn(true);
        doNothing().when(levelRepository).deleteById(1L);

        assertDoesNotThrow(() -> levelService.delete(1L));

        verify(levelRepository, times(1)).deleteById(1L);
    }

}
