package br.inatel.dm112.logistica.service;

import br.inatel.dm112.logistica.model.Pedido;
import br.inatel.dm112.logistica.repository.RepositorioPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
