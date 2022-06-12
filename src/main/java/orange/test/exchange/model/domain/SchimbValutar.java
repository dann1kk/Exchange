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
public class SchimbValutar {
    @Id
    Integer id;

    float sumaPrimita;
    float sumaEliberata;

    Integer valutaId;
    Integer operatorId;
    Integer cursValutarId;
    Integer filialaId;

    @Transient
    Valuta valuta;

    @Transient
    Operator operator;

    @Transient
    CursValutar cursValutar;

    @Transient
    Filiala filiala;

    @Column
    @CreatedDate
    LocalDate data;
}
