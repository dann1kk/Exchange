package orange.test.exchange.model.domain;


import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


import java.time.LocalDate;

@Table
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Numerar {
    @Id
    Integer id;

    Integer valutaId;
    Integer operatorId;

    @Transient
    Valuta valuta;

    float suma;

    @Transient
    Operator operator;

    @Column
    @CreatedDate
    LocalDate data;
}
