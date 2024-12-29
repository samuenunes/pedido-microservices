package br.com.leumassns.pedidos.processador.entity;

import br.com.leumassns.pedidos.processador.entity.ItemPedido;
import br.com.leumassns.pedidos.processador.entity.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="pedido")
public class Pedido {

    @Id
    private UUID id = UUID.randomUUID();

    private String cliente;

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itens = new ArrayList<>();

    private Double total;

    @Column(name="email_notificacao")
    private String emailNotificacao;

    @Enumerated(EnumType.STRING)
    private Status status = Status.EM_PROCESSAMENTO;

    @Column(name="data_hora")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataHora = LocalDateTime.now();

}
