package br.com.leumassns.pedidos.api.controller;

import br.com.leumassns.pedidos.api.entity.Pedido;
import br.com.leumassns.pedidos.api.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name="Pedidos", description = "Rota para criar um novo pedido")
@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidoController {
    private final Logger logger = LoggerFactory.getLogger(PedidoController.class);

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @Operation(summary = "Criar um novo pedido", description = "Método que cria novo pedido",
            responses = @ApiResponse(responseCode = "201", description = "pedido criado com sucesso",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Pedido.class)))
    )
    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido) {
        logger.info("Criando pedido: {}", pedido.toString());
        pedidoService.enfileirarPedido(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
    }
}
