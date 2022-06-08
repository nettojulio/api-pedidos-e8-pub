package e8ilab2.apipedidos.services;

import e8ilab2.apipedidos.models.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPedidoService {
    public Page<Pedido> recuperarTodos(Pageable p);

    public Pedido recuperarPorIdPedido(Integer id);

    public List<Pedido> recuperarPorIdDoUsuario(Integer id);

    public Pedido novoPedido(Pedido novoPedido);

    public Pedido alterarDadosPedido(Pedido dadosAlterados, Integer id);

    public Boolean deletarPedido(Integer id);

}
