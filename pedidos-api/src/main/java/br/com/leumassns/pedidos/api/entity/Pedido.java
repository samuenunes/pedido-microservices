package br.com.leumassns.pedidos.api.entity;

import br.com.leumassns.pedidos.api.entity.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
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
public class Pedido {
    private UUID id = UUID.randomUUID();
    private String cliente;
    private List<ItemPedido> itens = new ArrayList<>();
    private Double total;
    private String emailNotificacao;
    private Status status = Status.EM_PROCESSAMENTO;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataHora = LocalDateTime.now();

}
