package orange.test.exchange.repository;

import orange.test.exchange.model.domain.CursValutar;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Repository
public interface CursValutarRepository extends ReactiveCrudRepository<CursValutar, Integer> {
    Mono<CursValutar> findByValutaIdAndData(int valutaId, LocalDate data);
    Mono<CursValutar> findByCursAndData(float curs, LocalDate data);
}
