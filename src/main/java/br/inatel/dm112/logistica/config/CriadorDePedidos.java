package br.inatel.dm112.logistica.config;

import br.inatel.dm112.logistica.model.Pedido;
import br.inatel.dm112.logistica.repository.RepositorioPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class CriadorDePedidos {

    @Autowired
    private RepositorioPedido repositorioPedido;

    @PostConstruct
    public void init(){
        if(repositorioPedido.count()==0){
            System.out.println("Criando pedidos...");
            for(int i=1; i<=5; i++){
                Pedido pedido = new Pedido();
                pedido.setCpf("111.111.111-0" + i);
                pedido.setNome("User" +i);
                pedido.setEmail("user" + i +"@gmail.com");
                pedido.setEnderecoEntrega("Avenida" +i);
                repositorioPedido.save(pedido);
            }
        }
    }
}
