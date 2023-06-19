package com.vet.vetWorker.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PetDTO {

    private Long id;

    private Long petId;

    private String operationType;

    private String name;

    private Integer breed;

    private Byte sex;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime birthday;

    private Byte sterilized;

    private Integer kind;

    private Short color;

    private String chipNumber;

    private Long ownerId;

}
