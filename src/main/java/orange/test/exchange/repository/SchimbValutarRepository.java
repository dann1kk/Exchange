package orange.test.exchange.repository;

import orange.test.exchange.model.domain.SchimbValutar;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

@Repository
public interface SchimbValutarRepository extends ReactiveCrudRepository<SchimbValutar, Integer> {
    Flux<SchimbValutar> findAllByValutaIdAndData(int valutaId, LocalDate data);
}
