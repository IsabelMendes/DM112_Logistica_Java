package br.inatel.dm112.logistica.model;

import javax.persistence.*;

@Entity //indica que será uma entidade na tabela do BD
public class Pedido {

    @Id // indica que esse atributo é a primary key
    @GeneratedValue(strategy=GenerationType.AUTO)//o BD que gerará o id único.
    private long id;

    @Column(nullable = false)//diz que o cpf não pode ser nulo.
    private String cpf;

    @Column(nullable = false)
    private String nome;

    private String dataEntrega;
    private boolean statusEntrega;

    @Column(nullable = false)
    private String enderecoEntrega;

    @Column(nullable = false)
    private String email;
    private boolean emailEnviado;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public boolean isStatusEntrega() {
        return statusEntrega;
    }

    public void setStatusEntrega(boolean statusEntrega) {
        this.statusEntrega = statusEntrega;
    }

    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(String enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEmailEnviado() {
        return emailEnviado;
    }

    public void setEmailEnviado(boolean emailEnviado) {
        this.emailEnviado = emailEnviado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
