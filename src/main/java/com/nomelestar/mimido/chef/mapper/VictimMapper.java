package com.nomelestar.mimido.chef.mapper;

import com.nomelestar.mimido.chef.dto.VictimCreateDTO;
import com.nomelestar.mimido.chef.dto.VictimResponseDTO;
import com.nomelestar.mimido.chef.dto.VictimUpdateDTO;
import com.nomelestar.mimido.chef.model.Victim;
import org.springframework.stereotype.Component;

@Component
public class VictimMapper {

    public Victim toEntity(VictimCreateDTO dto) {
        Victim victim = new Victim();
        victim.setName(dto.getName());
        victim.setFamily(dto.getFamily());
        victim.setStatus(dto.getStatus());
        victim.setLocation(dto.getLocation());
        victim.setDeathDateTime(dto.getDeathDateTime());
        return victim;
    }

    public void update(Victim victim, VictimUpdateDTO dto) {
        victim.setName(dto.getName());
        victim.setFamily(dto.getFamily());
        victim.setStatus(dto.getStatus());
        victim.setLocation(dto.getLocation());
        victim.setDeathDateTime(dto.getDeathDateTime());
    }

    public VictimResponseDTO toResponse(Victim victim) {
        VictimResponseDTO response = new VictimResponseDTO();
        response.setId(victim.getId());
        response.setName(victim.getName());
        response.setFamily(victim.getFamily());
        response.setStatus(victim.getStatus());
        response.setLocation(victim.getLocation());
        response.setDeathDateTime(victim.getDeathDateTime());
        return response;
    }
}
