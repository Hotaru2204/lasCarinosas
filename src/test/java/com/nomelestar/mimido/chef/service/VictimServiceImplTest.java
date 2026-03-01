package com.nomelestar.mimido.chef.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.nomelestar.mimido.chef.dto.VictimCreateDTO;
import com.nomelestar.mimido.chef.dto.VictimResponseDTO;
import com.nomelestar.mimido.chef.dto.VictimUpdateDTO;
import com.nomelestar.mimido.chef.mapper.VictimMapper;
import com.nomelestar.mimido.chef.model.Victim;
import com.nomelestar.mimido.chef.repository.VictimRepository;
import com.nomelestar.mimido.chef.service.impl.VictimServiceImpl;
import com.nomelestar.mimido.common.ResourceNotFoundException;
import java.time.LocalDateTime;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class VictimServiceImplTest {
    private static final LocalDateTime FIXED_DATE = LocalDateTime.of(2024, 3, 1, 22, 0, 0);

    @Mock
    private VictimRepository victimRepository;

    @Mock
    private VictimMapper victimMapper;

    @InjectMocks
    private VictimServiceImpl victimService;

    @Test
    void createShouldMapAndPersistVictim() {
        VictimCreateDTO createDTO = new VictimCreateDTO();
        createDTO.setName("MG");
        createDTO.setFamily("Gonzaga");
        createDTO.setStatus("DECEASED");
        createDTO.setLocation("Luxury Bathroom");
        createDTO.setDeathDateTime(FIXED_DATE);

        Victim victim = new Victim();
        victim.setId(1L);
        VictimResponseDTO responseDTO = new VictimResponseDTO();
        responseDTO.setId(1L);

        when(victimMapper.toEntity(createDTO)).thenReturn(victim);
        when(victimRepository.save(victim)).thenReturn(victim);
        when(victimMapper.toResponse(victim)).thenReturn(responseDTO);

        VictimResponseDTO result = victimService.create(createDTO);

        assertThat(result.getId()).isEqualTo(1L);
        verify(victimRepository).save(victim);
    }

    @Test
    void updateShouldFailWhenVictimDoesNotExist() {
        when(victimRepository.findById(99L)).thenReturn(Optional.empty());

        VictimUpdateDTO updateDTO = new VictimUpdateDTO();
        updateDTO.setName("S.A");
        updateDTO.setFamily("Aris");
        updateDTO.setStatus("DECEASED");
        updateDTO.setLocation("Study");
        updateDTO.setDeathDateTime(FIXED_DATE);

        assertThatThrownBy(() -> victimService.update(99L, updateDTO))
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessageContaining("99");
    }

    @Test
    void deleteShouldRemoveVictimWhenFound() {
        Victim victim = new Victim();
        victim.setId(5L);
        when(victimRepository.findById(5L)).thenReturn(Optional.of(victim));

        victimService.delete(5L);

        verify(victimRepository).delete(victim);
    }
}
