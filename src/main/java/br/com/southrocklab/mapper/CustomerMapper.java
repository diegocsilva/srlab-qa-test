package br.com.southrocklab.mapper;

import br.com.southrocklab.dto.CustomerDTO;
import br.com.southrocklab.dto.CustomerResponseDTO;
import br.com.southrocklab.model.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CardMapper.class})
public interface CustomerMapper {

    Customer map(CustomerDTO dto);

    CustomerDTO map(Customer customer);

    CustomerResponseDTO mapToResponse(CustomerDTO dto);

    List<CustomerResponseDTO> map(List<Customer> customers);

    CustomerResponseDTO mapToResponse(Customer customer);

    Customer map(CustomerResponseDTO dto);

}
