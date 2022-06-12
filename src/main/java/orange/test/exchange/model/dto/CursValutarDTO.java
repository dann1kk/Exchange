package orange.test.exchange.model.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
public class CursValutarDTO {
    String codValuta;
    float rata;
    float curs;
    LocalDate data;
}
