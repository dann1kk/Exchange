package orange.test.exchange.mapper;

import orange.test.exchange.model.domain.CursValutar;
import orange.test.exchange.model.dto.CursValutarDTO;
import orange.test.exchange.model.dto.NewCursValutarDTO;
import org.springframework.stereotype.Component;

@Component
public class CursValutarMapper {

    public CursValutar toEntity(NewCursValutarDTO cursValutarDTO) {
        CursValutar cursValutar = new CursValutar();
        cursValutar.setCurs(cursValutarDTO.getCurs());
        cursValutar.setRata(cursValutarDTO.getRata());

        return cursValutar;
    }

    public CursValutarDTO toDto(CursValutar cursValutar) {
        return CursValutarDTO.builder()
                .curs(cursValutar.getCurs())
                .rata(cursValutar.getRata())
                .codValuta(cursValutar.getValuta().getCod())
                .data(cursValutar.getData())
                .build();
    }
}
