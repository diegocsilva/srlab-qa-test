package br.com.southrocklab.mapper;

import br.com.southrocklab.dto.CardDTO;
import br.com.southrocklab.dto.CardResponseDTO;
import br.com.southrocklab.model.Card;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardMapper {

    @Mapping(target = "customer.id", source = "customerId")
    Card map(CardDTO dto);

    @Mapping(target = "customerId", source = "customer.id")
    CardResponseDTO mapToResponse(Card card);

    List<CardResponseDTO> mapToResponse(List<Card> cards);

}
