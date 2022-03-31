package br.com.southrocklab.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class CardResponseDTO extends CardDTO {

    @ApiModelProperty(
        value = "Id of card.",
        dataType = "int"
    )
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
