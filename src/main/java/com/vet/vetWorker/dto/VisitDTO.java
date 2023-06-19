package com.vet.vetWorker.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VisitDTO {

    private Long id;

    private Long visitId;

    private String operationType;

    private Long petId;

    private Long clientId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime date;

    private String anamnesis;

    private String prescription;

    private String recommendation;

    private Integer type;

    private Long firstVisitId;

    private Float weight;

    private Float temperature;

    private Integer heartBeat;

    private Integer breathBeat;

    private Long vaccineId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime nextVaccination;
}

