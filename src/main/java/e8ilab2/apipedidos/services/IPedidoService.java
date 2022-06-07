package e8ilab2.apipedidos.services;

import e8ilab2.apipedidos.models.Pedido;

import java.util.List;

public interface IPedidoService {
    public List<Pedido> recuperarTodos();

    public Pedido recuperarPorIdPedido(Integer id);

    public List<Pedido> recuperarPorIdDoUsuario(Integer id);

    public Pedido novoPedido(Pedido novoPedido);

    public Pedido alterarDadosPedido(Pedido dadosAlterados, Integer id);

    public Boolean deletarPedido(Integer id);
}
