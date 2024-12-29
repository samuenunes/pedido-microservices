package br.com.leumassns.pedidos.processador.service;

import br.com.leumassns.pedidos.processador.entity.ItemPedido;
import br.com.leumassns.pedidos.processador.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public void save(List<ItemPedido> itens) {
        itens.forEach(iten -> {
            produtoRepository.save(iten.getProduto());
        });

    }
}
