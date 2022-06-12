package orange.test.exchange.service;

import lombok.RequiredArgsConstructor;
import orange.test.exchange.model.domain.Numerar;
import orange.test.exchange.repository.NumerarRepository;
import orange.test.exchange.repository.ValutaRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class NumerarService {

    private final ValutaRepository valutaRepository;
    private final NumerarRepository numerarRepository;

    public Mono<Numerar> update(Numerar numerar) {

        Mono<Numerar> numerarMono = valutaRepository.findByCod(numerar.getValuta().getCod())
                .flatMap(valuta -> numerarRepository.findByValutaIdAndOperatorIdAndData(valuta.getId(), numerar.getOperatorId(), numerar.getData()))
                .flatMap(fnumerar -> {
                    fnumerar.setSuma(numerar.getSuma());
                    return numerarRepository.save(fnumerar);
                }).switchIfEmpty(Mono.error(new IllegalArgumentException("Valuta, operatorul sau data sunt incorecte!")));

        return numerarMono;
    }
}
