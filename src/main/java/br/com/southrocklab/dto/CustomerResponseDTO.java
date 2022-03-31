package br.com.southrocklab.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerResponseDTO extends CustomerDTO {

    @ApiModelProperty(
        value = "Id to customer.",
        dataType = "int"
    )
    private Integer id;

    @ApiModelProperty(
        value = "Registered cards of customer.",
        dataType = "list"
    )
    private List<CardResponseDTO> cards = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<CardResponseDTO> getCards() {
        return cards == null ? Collections.emptyList() : cards;
    }

    public void setCards(List<CardResponseDTO> cards) {
        this.cards = cards;
    }
}
