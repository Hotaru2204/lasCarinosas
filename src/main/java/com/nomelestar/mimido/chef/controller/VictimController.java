package com.nomelestar.mimido.chef.controller;

import com.nomelestar.mimido.chef.dto.VictimCreateDTO;
import com.nomelestar.mimido.chef.dto.VictimResponseDTO;
import com.nomelestar.mimido.chef.dto.VictimUpdateDTO;
import com.nomelestar.mimido.chef.service.VictimService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/victims")
public class VictimController {

    private final VictimService victimService;

    public VictimController(VictimService victimService) {
        this.victimService = victimService;
    }

    @GetMapping
    public List<VictimResponseDTO> getAll() {
        return victimService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VictimResponseDTO create(@Valid @RequestBody VictimCreateDTO dto) {
        return victimService.create(dto);
    }

    @PutMapping("/{id}")
    public VictimResponseDTO update(@PathVariable Long id, @Valid @RequestBody VictimUpdateDTO dto) {
        return victimService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        victimService.delete(id);
    }
}
