package orange.test.exchange.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewSchimbValutarDTO {
    String codValuta;
    float cursSchimb;
    float sumaPrimita;
    int operatorId;
}
