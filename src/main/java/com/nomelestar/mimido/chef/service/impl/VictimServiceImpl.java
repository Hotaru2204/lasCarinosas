package com.nomelestar.mimido.chef.service.impl;

import com.nomelestar.mimido.chef.dto.VictimCreateDTO;
import com.nomelestar.mimido.chef.dto.VictimResponseDTO;
import com.nomelestar.mimido.chef.dto.VictimUpdateDTO;
import com.nomelestar.mimido.chef.mapper.VictimMapper;
import com.nomelestar.mimido.chef.model.Victim;
import com.nomelestar.mimido.chef.repository.VictimRepository;
import com.nomelestar.mimido.chef.service.VictimService;
import com.nomelestar.mimido.common.ResourceNotFoundException;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class VictimServiceImpl implements VictimService {

    private final VictimRepository victimRepository;
    private final VictimMapper victimMapper;

    public VictimServiceImpl(VictimRepository victimRepository, VictimMapper victimMapper) {
        this.victimRepository = victimRepository;
        this.victimMapper = victimMapper;
    }

    @Override
    public List<VictimResponseDTO> getAll() {
        return victimRepository.findAll().stream().map(victimMapper::toResponse).toList();
    }

    @Override
    public VictimResponseDTO create(VictimCreateDTO createDTO) {
        Victim victim = victimMapper.toEntity(createDTO);
        return victimMapper.toResponse(victimRepository.save(victim));
    }

    @Override
    public VictimResponseDTO update(Long id, VictimUpdateDTO updateDTO) {
        Victim victim = victimRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Victim not found with id: " + id));
        victimMapper.update(victim, updateDTO);
        return victimMapper.toResponse(victimRepository.save(victim));
    }

    @Override
    public void delete(Long id) {
        Victim victim = victimRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Victim not found with id: " + id));
        victimRepository.delete(victim);
    }
}
