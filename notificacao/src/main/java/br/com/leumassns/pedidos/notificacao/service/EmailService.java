package br.com.leumassns.pedidos.notificacao.service;

import br.com.leumassns.pedidos.notificacao.entity.Pedido;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void enviarEmail(Pedido pedido){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("sns@aluno.ueg.br");
        message.setTo(pedido.getEmailNotificacao());
        message.setSubject("Pedido de Compra");
        message.setText(gerarMensagem(pedido));
        mailSender.send(message);
    }

    private String gerarMensagem(Pedido pedido) {
        String pedidoID = pedido.getId().toString();
        String cliente = pedido.getCliente();
        String valor = String.valueOf(pedido.getTotal());
        String status = pedido.getStatus().name();

        return String.format("Olá, %s. Seu pedido de n° %s no valor de R$ %s foi realizado com sucesso!\nStatus: %s", cliente, pedidoID, valor, status);
    }
}
