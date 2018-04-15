package br.inatel.dm112.logistica.service;

import br.inatel.dm112.logistica.model.Pedido;
import br.inatel.dm112.logistica.repository.RepositorioPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController //é um serviço do tipo Rest.
@RequestMapping(path="/entregador")// endereço raiz do serviço. Usaremos no Postaman.
public class Entregador {

    @Autowired //cria uma instância de RepositorioPedido (é o mesmo do new)
    private RepositorioPedido repositorioPedido;

    /**
     * Consulta pedidos por CPF
     * @param cpf:String
     * @return lista de pedidos
     */
    @GetMapping(path = "/consultarPedido") // Get do Rest.
    public List<Pedido> consultarPedidosPorCpf(@RequestParam String cpf){//variável do caminho.
        List<Pedido> listaDePedidosByCpf = repositorioPedido.findByCpf(cpf);

        return listaDePedidosByCpf;
    }

    /**
     *
     * @param pedido:Pedido
     * @return boolean
     */
    @PostMapping(path = "/registrarEntrega")
    public boolean registraEntrega(@RequestBody Pedido pedido){//Esse valor vem dentro do body.
        if (repositorioPedido.exists(pedido.getId())) {
            pedido.setStatusEntrega(true);
            pedido.setDataEntrega(Calendar.getInstance().getTime().toString());//Pega hora e data do sistema e transforma em String.
            repositorioPedido.save(pedido);
            return true;
        } else {
            return false;
        }
    }
}
