package com.dio.live.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class BancoHoras {
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public class BancoHorasID implements Serializable {
        private Long bancoHorasId;
        private Long movimentoId;
        private Long usuarioId;

    }
    @Id
    @EmbeddedId
    private BancoHorasID bancoHorasId;
    //@ManyToOne
    //private CategoriaUsuario categoriaUsuario;
    private LocalDateTime dataTrabalhada;
    private BigDecimal quantidadeHoraTrabalhada;
    private BigDecimal saldoHoraTrabalhada;

}
