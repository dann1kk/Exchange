package orange.test.exchange.repository;

import orange.test.exchange.model.domain.Valuta;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ValutaRepository extends ReactiveSortingRepository<Valuta, Integer> {
    Mono<Valuta> findByCod(String cod);
}
