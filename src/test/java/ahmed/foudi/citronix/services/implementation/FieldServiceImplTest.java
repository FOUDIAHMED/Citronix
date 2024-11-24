package ahmed.foudi.citronix.services.implementation;

import ahmed.foudi.citronix.dto.field.FieldRequestDTO;
import ahmed.foudi.citronix.dto.field.FieldResponseDTO;
import ahmed.foudi.citronix.entities.Farm;
import ahmed.foudi.citronix.entities.Field;
import ahmed.foudi.citronix.exception.farmexception.FarmException;
import ahmed.foudi.citronix.exception.fieldexception.SuperficieFieldException;
import ahmed.foudi.citronix.mappers.field.FieldDtoMapper;
import ahmed.foudi.citronix.repository.FarmRepository;
import ahmed.foudi.citronix.repository.FieldRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FieldServiceImplTest {

    @Mock
    private FieldRepository fieldRepository;
    @Mock
    private FarmRepository farmRepository;
    @Mock
    private FieldDtoMapper fieldDtoMapper;
    @InjectMocks
    private FieldServiceImpl fieldService;

    private Farm farm;
    private Field field;
    private FieldRequestDTO requestDTO;
    private FieldResponseDTO responseDTO;

    @BeforeEach
    void setUp() {
        farm = new Farm();
        farm.setId(1L);
        farm.setSuperficie(10000.0); // 1 hectare
        farm.setFields(new ArrayList<>());
        farm.setDateCreation(LocalDate.now());

        field = new Field();
        field.setId(1L);
        field.setSurface(2000.0);
        field.setFarm(farm);

        requestDTO = new FieldRequestDTO();
        requestDTO.setFarmId(1L);
        requestDTO.setSurface(2000.0);

        responseDTO = new FieldResponseDTO();
        responseDTO.setId(1L);
        responseDTO.setSurface(2000.0);
    }

    @Test
    void shouldSaveFieldSuccessfully() {
        when(farmRepository.findById(1L)).thenReturn(Optional.of(farm));
        when(fieldDtoMapper.toEntity(requestDTO)).thenReturn(field);
        when(fieldRepository.save(any(Field.class))).thenReturn(field);
        when(fieldDtoMapper.toDto(field)).thenReturn(responseDTO);

        FieldResponseDTO result = fieldService.save(requestDTO);

        assertNotNull(result);
        assertEquals(2000.0, result.getSurface());
        verify(fieldRepository).save(any(Field.class));
    }

    @Test
    void shouldThrowExceptionWhenSurfaceLessThan1000() {
        requestDTO.setSurface(500);
        
        assertThrows(SuperficieFieldException.class, () -> fieldService.save(requestDTO));
        verify(fieldRepository, never()).save(any());
    }

    @Test
    void shouldThrowExceptionWhenSurfaceExceeds50PercentOfFarm() {
        requestDTO.setSurface(6000); // More than 50% of farm surface
        when(farmRepository.findById(1L)).thenReturn(Optional.of(farm));
        when(fieldDtoMapper.toEntity(requestDTO)).thenReturn(field);

        assertThrows(SuperficieFieldException.class, () -> fieldService.save(requestDTO));
        verify(fieldRepository, never()).save(any());
    }

    @Test
    void shouldThrowExceptionWhenFarmHas10Fields() {
        List<Field> existingFields = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Field f = new Field();
            f.setId((long) i);
            existingFields.add(f);
        }
        farm.setFields(existingFields);
        
        when(farmRepository.findById(1L)).thenReturn(Optional.of(farm));
        when(fieldDtoMapper.toEntity(requestDTO)).thenReturn(field);

        assertThrows(FarmException.class, () -> fieldService.save(requestDTO));
        verify(fieldRepository, never()).save(any());
    }

    @Test
    void shouldThrowExceptionWhenTotalSurfaceExceedsFarmSurface() {
        Field existingField = new Field();
        existingField.setSurface(9000.0);
        farm.setFields(Arrays.asList(existingField));
        
        when(farmRepository.findById(1L)).thenReturn(Optional.of(farm));
        when(fieldDtoMapper.toEntity(requestDTO)).thenReturn(field);

        assertThrows(FarmException.class, () -> fieldService.save(requestDTO));
        verify(fieldRepository, never()).save(any());
    }

    @Test
    void shouldUpdateFieldSuccessfully() {
        when(fieldRepository.findById(1L)).thenReturn(Optional.of(field));
        when(farmRepository.findById(1L)).thenReturn(Optional.of(farm));
        when(fieldDtoMapper.toEntity(requestDTO)).thenReturn(field);
        when(fieldRepository.save(any(Field.class))).thenReturn(field);
        when(fieldDtoMapper.toDto(field)).thenReturn(responseDTO);

        FieldResponseDTO result = fieldService.update(1L, requestDTO);

        assertNotNull(result);
        assertEquals(2000, result.getSurface());
        verify(fieldRepository).save(any(Field.class));
    }

    @Test
    void shouldDeleteFieldSuccessfully() {
        when(fieldRepository.findById(1L)).thenReturn(Optional.of(field));
        when(fieldDtoMapper.toDto(field)).thenReturn(responseDTO);

        FieldResponseDTO result = fieldService.delete(1L);

        assertNotNull(result);
        verify(fieldRepository).deleteById(1L);
    }

    @Test
    void shouldThrowExceptionWhenFieldNotFound() {
        when(fieldRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> fieldService.findById(99L));
        verify(fieldDtoMapper, never()).toDto(any());
    }

    @Test
    void shouldFindAllFieldsSuccessfully() {
        List<Field> fields = Arrays.asList(field);
        when(fieldRepository.findAll()).thenReturn(fields);
        when(fieldDtoMapper.toDto(any(Field.class))).thenReturn(responseDTO);

        List<FieldResponseDTO> results = fieldService.findAll();

        assertNotNull(results);
        assertEquals(1, results.size());
        verify(fieldRepository).findAll();
    }
} 