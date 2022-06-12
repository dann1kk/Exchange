package orange.test.exchange.service;

import lombok.RequiredArgsConstructor;
import orange.test.exchange.model.domain.*;
import orange.test.exchange.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class SchimbValutarService {

    private final ValutaRepository valutaRepository;
    private final SchimbValutarRepository schimbValutarRepository;
    private final CursValutarRepository cursValutarRepository;
    private final OperatorRepository operatorRepository;
    private final NumerarRepository numerarRepository;

    @Transactional
    public Mono<SchimbValutar> create(SchimbValutar schimbValutar) {

        final String codValuta = schimbValutar.getValuta().getCod();
        float cursSchimb = schimbValutar.getCursValutar().getCurs();
        final int operatorId = schimbValutar.getOperatorId();

        Mono<SchimbValutar> schimbValutarMono = Mono.just(schimbValutar);

        schimbValutarMono = schimbValutarMono.zipWith(valutaRepository.findByCod(codValuta))
                .map(tuple -> {
                    tuple.getT1().setValutaId(tuple.getT2().getId());
                    tuple.getT1().setValuta(tuple.getT2());
                    return tuple.getT1();
                }).switchIfEmpty(Mono.error(new IllegalArgumentException("Cod valuta invalid!")));

        schimbValutarMono = schimbValutarMono.zipWith(cursValutarRepository.findByCursAndData(cursSchimb, LocalDate.now()))
                .map(tuple -> {
                    tuple.getT1().setCursValutarId(tuple.getT2().getId());
                    tuple.getT1().setCursValutar(tuple.getT2());
                    return tuple.getT1();
                }).switchIfEmpty(Mono.error(new IllegalArgumentException("Curs inexistent!")));

        schimbValutarMono = schimbValutarMono.zipWith(operatorRepository.findById(operatorId))
                .map(tuple -> {
                    tuple.getT1().setOperator(tuple.getT2());
                    return tuple.getT1();
                }).switchIfEmpty(Mono.error(new IllegalArgumentException("ID Operator invalid!!")));

        Mono<Float> numerarDisponibilMono = schimbValutarMono
                .flatMap(sv -> numerarRepository.findByValutaIdAndOperatorIdAndData(sv.getValutaId(), sv.getOperatorId(), LocalDate.now()))
                .map(Numerar::getSuma);

        Mono<Float> totalEliberatMono = valutaRepository.findByCod(codValuta)
                .map(valuta -> schimbValutarRepository.findAllByValutaIdAndData(valuta.getId(), LocalDate.now()))
                .flatMap(schimbValutarFlux -> schimbValutarFlux
                        .map(SchimbValutar::getSumaEliberata)
                        .reduce(0f, Float::sum)
                        .defaultIfEmpty(0f));

        schimbValutarMono = schimbValutarMono
                .zipWith(Mono.zip(numerarDisponibilMono, totalEliberatMono))
                .map(tuple -> {
                    final float numerarInitialDisponibil = tuple.getT2().getT1();
                    final float totalEliberat = tuple.getT2().getT2();
                    final float curs = tuple.getT1().getCursValutar().getCurs();
                    final float rata = tuple.getT1().getCursValutar().getRata();
                    final float sumaPrimita = tuple.getT1().getSumaPrimita();
                    final float sumaEliberata = (sumaPrimita / curs / rata);
                    final float numerarDisponibil = numerarInitialDisponibil - totalEliberat;

                    if (sumaEliberata <= numerarDisponibil) {
                        tuple.getT1().setSumaEliberata(sumaEliberata);
                    } else {
                        throw new IllegalArgumentException("Conflict: suma eliberata depaseste numerarul disponibil!");
                    }

                    return tuple.getT1();
                }).flatMap(schimbValutarRepository::save);


        return schimbValutarMono;
    }
}
