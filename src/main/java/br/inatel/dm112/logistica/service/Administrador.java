package br.inatel.dm112.logistica.service;

import br.inatel.dm112.logistica.mail.MailImpl;
import br.inatel.dm112.logistica.mail.MailService;
import br.inatel.dm112.logistica.mail.MailStatusResponse;
import br.inatel.dm112.logistica.model.Pedido;
import br.inatel.dm112.logistica.repository.RepositorioPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping(path="/administrador")
public class Administrador {
    @Autowired
    private RepositorioPedido repositorioPedido;

    @PostMapping(path = "/criarPedido")
    public Pedido criarPedido(@RequestBody Pedido pedido) {
        return repositorioPedido.save(pedido);
    }

    @GetMapping(path = "/pedidosEntegues")
    public List<Pedido> consultarPedidosEntregues() {
        return repositorioPedido.findByStatusEntregaTrue();
    }

    @PostMapping(path= "/enviarEmailDeEntrega/{id}")
    public boolean enviarEmailDeEntrega (@PathVariable Long id) throws UnsupportedEncodingException { //Path, pois não tem caracteres especiais.
        Pedido pedido = repositorioPedido.findOne(id);
        if (pedido != null && pedido.isStatusEntrega() == true && pedido.isEmailEnviado() == false){

            //Consome o serviço legado de envio de e-mails do professor, que só envia boleto
            MailService service = new MailService();
            MailImpl port = service.getMailImplPort();
            String content = "Olá " + pedido.getNome() + "!\r\n Seu pedido acabou de ser entregue!";
            MailStatusResponse result = port.sendMail("robertorr9@gmail.com", "robertodm112", pedido.getEmail(),
                    content.getBytes("UTF-8"));

            pedido.setEmailEnviado(true);
            repositorioPedido.save(pedido);
            return true;
        } else{
            return false;
        }
    }
}
