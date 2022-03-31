package br.com.southrocklab.resource;

import br.com.southrocklab.dto.CardDTO;
import br.com.southrocklab.dto.CardResponseDTO;
import br.com.southrocklab.service.CardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/card")
public class CardResource {

    private final CardService service;

    public CardResource(CardService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CardResponseDTO> create(@Valid @RequestBody CardDTO dto) {
        CardResponseDTO customer = service.create(dto);
        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
