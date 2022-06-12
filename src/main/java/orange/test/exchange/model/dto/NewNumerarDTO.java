package orange.test.exchange.model.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class NewNumerarDTO {
    int operatorId;
    String codValuta;
    float suma;
    LocalDate data;
}
