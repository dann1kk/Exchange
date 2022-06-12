package orange.test.exchange.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewCursValutarDTO {
    public String codValuta;
    public float rata;
    public float curs;
}
