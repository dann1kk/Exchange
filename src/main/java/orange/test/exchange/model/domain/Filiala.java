package orange.test.exchange.model.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
@Data
@Table
public class Filiala {
    @Id
    Integer id;

    String denumire;

}
