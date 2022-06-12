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
public class CursValutar {
    @Id
    Integer id;

    Integer valutaId;

    @Transient
    Valuta valuta;

    float rata;
    float curs;

    @Column
    @CreatedDate
    LocalDate data;
}
