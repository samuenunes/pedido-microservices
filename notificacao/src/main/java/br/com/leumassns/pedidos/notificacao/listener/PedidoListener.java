package br.com.leumassns.pedidos.notificacao.listener;

import br.com.leumassns.pedidos.notificacao.entity.Pedido;
import br.com.leumassns.pedidos.notificacao.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PedidoListener {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final EmailService emailService;

    public PedidoListener(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = "pedidos.v1.pedido-criado.gerar-notificacao")
    public void enviarNotificacao(Pedido pedido){
        emailService.enviarEmail(pedido);
        logger.info("Notificacao gerada: {}", pedido);
    }
}
