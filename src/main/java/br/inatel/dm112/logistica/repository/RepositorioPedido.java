package br.inatel.dm112.logistica.repository;

import br.inatel.dm112.logistica.model.Pedido;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RepositorioPedido extends CrudRepository<Pedido, Long> { //contém as funções crud

    //Métodos de interface não tem modificador de acesso (public, private) e não tem implementação, logo não usa{}.

    /**
     * Devolve a lista de pedidos por cpf
     * @param cpf:String
     * @return List<Pedido> lista de pedidos
     */
    List<Pedido> findByCpf(String cpf);// (findBy..é implementado pelo Spring data)

    /**
     * Devolve todos os pedidos que já foram entregues
     * @return List<Pedido> lista de pedidos
     */
    List<Pedido> findByStatusEntregaTrue();
}
