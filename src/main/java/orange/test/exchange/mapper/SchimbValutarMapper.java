package orange.test.exchange.mapper;

import orange.test.exchange.model.domain.CursValutar;
import orange.test.exchange.model.domain.SchimbValutar;
import orange.test.exchange.model.domain.Valuta;
import orange.test.exchange.model.dto.NewSchimbValutarDTO;
import org.springframework.stereotype.Component;

@Component
public class SchimbValutarMapper {

    public SchimbValutar toEntity(NewSchimbValutarDTO newSchimbValutarDTO) {

        SchimbValutar schimbValutar = new SchimbValutar();
        schimbValutar.setSumaPrimita(newSchimbValutarDTO.getSumaPrimita());

        Valuta valuta = new Valuta();
        valuta.setCod(newSchimbValutarDTO.getCodValuta());
        schimbValutar.setValuta(valuta);

        CursValutar cursValutar = new CursValutar();
        cursValutar.setCurs(newSchimbValutarDTO.getCursSchimb());
        schimbValutar.setCursValutar(cursValutar);

        schimbValutar.setOperatorId(newSchimbValutarDTO.getOperatorId());

        return schimbValutar;
    }
}
