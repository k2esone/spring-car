package pl.sda.springcar.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCarResponse {

    private Long idR;
    private String regR;
    private LocalDate registrationDateR;
    private Integer doorsR;
    private Double engineCapR;

}

