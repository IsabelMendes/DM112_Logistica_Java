package br.inatel.dm112.logistica.service;

import br.inatel.dm112.logistica.mail.MailImpl;
import br.inatel.dm112.logistica.mail.MailService;
import br.inatel.dm112.logistica.mail.MailStatusResponse;
import br.inatel.dm112.logistica.model.Pedido;
import br.inatel.dm112.logistica.repository.RepositorioPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping(path="/administrador")
public class Administrador {
    @Autowired
    private RepositorioPedido repositorioPedido;

    @GetMapping(path = "/pedidosEntegues")
    public List<Pedido> consultarPedidosEntregues() {
        return repositorioPedido.findByStatusEntregaTrue();
    }

    @PostMapping(path= "/enviarEmailDeEntrega/{id}")
    public boolean enviarEmailDeEntrega (@PathVariable Long id){ //Path, pois não tem caracteres especiais.
        Pedido pedido = repositorioPedido.findOne(id);
        if (pedido != null && pedido.isStatusEntrega() == true && pedido.isEmailEnviado() == false){

            //Consome o serviço legado de envio de e-mails do professor, que só envia boleto
            MailService service = new MailService();
            MailImpl port = service.getMailImplPort();
            MailStatusResponse result = port.sendMail("robertorr9@gmail.com", "robertodm112", pedido.getEmail(),
                    "Pedido entregue!".getBytes());

            pedido.setEmailEnviado(true);
            repositorioPedido.save(pedido);
            return true;
        } else{
            return false;
        }
    }
}
