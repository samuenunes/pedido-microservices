package br.com.leumassns.pedidos.processador.service;

import br.com.leumassns.pedidos.processador.entity.ItemPedido;
import br.com.leumassns.pedidos.processador.entity.Pedido;
import br.com.leumassns.pedidos.processador.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPedidoService {

    private final ItemPedidoRepository itemPedidoRepository;

    public ItemPedidoService(ItemPedidoRepository itemPedidoRepository) {
        this.itemPedidoRepository = itemPedidoRepository;
    }

    public List<ItemPedido> save(List<ItemPedido> itens) {
        return itemPedidoRepository.saveAll(itens);
    }

    public void save(ItemPedido item) {
        itemPedidoRepository.save(item);
    }

    public void updatedItemPedido(List<ItemPedido> itens, Pedido pedido) {
        itens.forEach(itemPedido -> {
            itemPedido.setPedido(pedido);
            save(itemPedido);
        });
    }
}
