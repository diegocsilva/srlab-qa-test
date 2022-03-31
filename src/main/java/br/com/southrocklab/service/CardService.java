package br.com.southrocklab.service;

import br.com.southrocklab.dto.CardDTO;
import br.com.southrocklab.dto.CardResponseDTO;
import br.com.southrocklab.mapper.CardMapper;
import br.com.southrocklab.model.Card;
import br.com.southrocklab.repository.CardRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CardService {

    private final CardRepository repository;
    private final CustomerService customerService;
    private final CardMapper mapper;

    public CardService(CardRepository repository, CustomerService customerService, CardMapper mapper) {
        this.repository = repository;
        this.customerService = customerService;
        this.mapper = mapper;
    }

    public List<CardResponseDTO> list() {
        List<Card> all = repository.findAll();
        return mapper.mapToResponse(all);
    }

    private Card create(Card card) {
        return repository.save(card);
    }

    public CardResponseDTO create(CardDTO card) {
        customerService.getById(card.getCustomerId());
        Card car = mapper.map(card);
        return mapper.mapToResponse(create(car));
    }

    public void delete(Integer id) {
        Card card = repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Card not found"));
        repository.delete(card);
    }
}
