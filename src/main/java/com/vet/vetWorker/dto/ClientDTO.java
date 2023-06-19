package com.vet.vetWorker.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientDTO {

    private Long id;

    private Long clientId;

    private String operationType;

    private String firstName;

    private String middleName;

    private String surname;

    private String phone;

    private String email;

}
