package orange.test.exchange.service;

import lombok.RequiredArgsConstructor;
import orange.test.exchange.model.domain.CursValutar;
import orange.test.exchange.model.domain.Valuta;
import orange.test.exchange.repository.CursValutarRepository;
import orange.test.exchange.repository.ValutaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class CursValutarService {

    private final CursValutarRepository cursValutarRepository;
    private final ValutaRepository valutaRepository;


    @Transactional
    public Mono<CursValutar> create(CursValutar cursValutar, String codValuta) {
        return valutaRepository.findByCod(codValuta).flatMap(valuta -> {
            cursValutar.setValutaId(valuta.getId());
            cursValutar.setValuta(valuta);
            return cursValutarRepository.save(cursValutar);
        }).switchIfEmpty(Mono.error(new IllegalArgumentException("Valuta inexistenta!")));
    }

    @Transactional
    public Mono<CursValutar> getByValuta(String codValuta) {
        Mono<Valuta> valutaMono = valutaRepository.findByCod(codValuta);

        Mono<CursValutar> cursValutarMono = valutaMono.flatMap(valuta -> cursValutarRepository.findByValutaIdAndData(valuta.getId(), LocalDate.now()));

        return cursValutarMono.zipWith(valutaMono)
                .map(tuple -> {
                    tuple.getT1().setValuta(tuple.getT2());
                    return tuple.getT1();
                });
    }


    @Transactional
    public Flux<CursValutar> getAll() {
        return cursValutarRepository.findAll();
    }

}
