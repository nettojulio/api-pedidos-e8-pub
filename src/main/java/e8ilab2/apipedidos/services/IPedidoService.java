package e8ilab2.apipedidos.services;

import e8ilab2.apipedidos.models.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPedidoService {
    public Page<Pedido> recuperarTodos(Pageable p);

    public Pedido recuperarPorIdPedido(Integer id);

    public Page<Pedido> recuperarPedidosPeloIdDoUsuario(Integer id, Pageable p);

    public Pedido novoPedido(Pedido novoPedido);

    public Pedido alterarDadosPedido(Pedido dadosAlterados, Integer id);

    public Boolean deletarPedido(Integer id);

}
