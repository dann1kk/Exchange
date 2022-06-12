package orange.test.exchange.repository;

import orange.test.exchange.model.domain.Filiala;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;

public interface FilialaRepository extends ReactiveSortingRepository<Filiala, Integer> {
}
