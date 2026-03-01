package com.nomelestar.mimido.chef.service;

import com.nomelestar.mimido.chef.dto.VictimCreateDTO;
import com.nomelestar.mimido.chef.dto.VictimResponseDTO;
import com.nomelestar.mimido.chef.dto.VictimUpdateDTO;
import java.util.List;

public interface VictimService {

    List<VictimResponseDTO> getAll();

    VictimResponseDTO create(VictimCreateDTO createDTO);

    VictimResponseDTO update(Long id, VictimUpdateDTO updateDTO);

    void delete(Long id);
}
