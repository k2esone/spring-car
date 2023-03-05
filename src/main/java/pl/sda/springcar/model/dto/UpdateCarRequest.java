package pl.sda.springcar.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCarRequest {

    private String regR;
    private Integer doorsR;
    private Double engineCapR;
}
