package orange.test.exchange.mapper;

import orange.test.exchange.model.domain.Numerar;
import orange.test.exchange.model.domain.Valuta;
import orange.test.exchange.model.dto.NewNumerarDTO;
import org.springframework.stereotype.Component;

@Component
public class NumerarMapper {
    public Numerar toEntity(NewNumerarDTO newNumerarDTO) {

        Numerar numerar = new Numerar();

        numerar.setOperatorId(newNumerarDTO.getOperatorId());

        Valuta valuta = new Valuta();
        valuta.setCod(newNumerarDTO.getCodValuta().toUpperCase());
        numerar.setValuta(valuta);

        numerar.setData(newNumerarDTO.getData());
        numerar.setSuma(newNumerarDTO.getSuma());

        return numerar;
    }
}
