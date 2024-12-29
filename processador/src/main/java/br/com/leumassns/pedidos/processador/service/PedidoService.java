package br.com.leumassns.pedidos.processador.service;

import br.com.leumassns.pedidos.processador.entity.ItemPedido;
import br.com.leumassns.pedidos.processador.entity.Pedido;
import br.com.leumassns.pedidos.processador.repository.PedidoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final PedidoRepository pedidoRepository;
    private final ProdutoService produtoService;
    private final ItemPedidoService itemPedidoService;


    public PedidoService(PedidoRepository pedidoRepository, ProdutoService produtoService, ItemPedidoService itemPedidoService) {
        this.pedidoRepository = pedidoRepository;
        this.produtoService = produtoService;
        this.itemPedidoService = itemPedidoService;
    }

    public void save(Pedido pedido) {

        produtoService.save(pedido.getItens());

        List<ItemPedido> itens = itemPedidoService.save(pedido.getItens());

        pedidoRepository.save(pedido);

        itemPedidoService.updatedItemPedido(itens, pedido);
    }
}
