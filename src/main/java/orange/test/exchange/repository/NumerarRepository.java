package orange.test.exchange.repository;

import orange.test.exchange.model.domain.Numerar;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

public interface NumerarRepository extends ReactiveCrudRepository<Numerar, Integer> {
    Mono<Numerar> findByValutaIdAndOperatorIdAndData(int valutaId, int opeartorId, LocalDate data);
}
