package orange.test.exchange.repository;

import orange.test.exchange.model.domain.Operator;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorRepository extends ReactiveCrudRepository<Operator, Integer> {
}
