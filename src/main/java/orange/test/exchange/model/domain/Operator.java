package orange.test.exchange.model.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table
public class Operator {
    @Id
    Integer id;

    String nume;
    String prenume;
}
