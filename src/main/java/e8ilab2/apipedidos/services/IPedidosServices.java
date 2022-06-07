package e8ilab2.apipedidos.services;

import e8ilab2.apipedidos.models.Pedidos;

import java.util.List;

public interface IPedidosServices {
    public List<Pedidos> recuperarTodos();

    public Pedidos recuperarPorIdPedido(Integer id);

    public List<Pedidos> recuperarPorIdDoUsuario(Integer id);

    public Pedidos novoPedido(Pedidos novoPedido);

    public Pedidos alterarDadosPedido(Pedidos dadosAlterados, Integer id);

    public Boolean deletarPedido(Integer id);
}
