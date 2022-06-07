package e8ilab2.apipedidos.dao;

import e8ilab2.apipedidos.models.Pedido;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PedidoDAO extends CrudRepository<Pedido, Integer> {
    @Query("SELECT new e8ilab2.apipedidos.models.Pedido(pedido.id, pedido.usuarioId, pedido.valorTotal, pedido.descricao, pedido.dataPedido, pedido.status) FROM Pedido as pedido ORDER BY pedido.id")
    public List<Pedido> recuperarTodos();

    @Query("SELECT new e8ilab2.apipedidos.models.Pedido(pedido.id, pedido.usuarioId, pedido.valorTotal, pedido.descricao, pedido.dataPedido, pedido.status) FROM Pedido as pedido WHERE pedido.id = :id")
    public Pedido recuperarPorIdPedido(@Param("id") Integer id);

    @Query("SELECT new e8ilab2.apipedidos.models.Pedido(pedido.id, pedido.usuarioId, pedido.valorTotal, pedido.descricao, pedido.dataPedido, pedido.status) FROM Pedido as pedido WHERE pedido.usuarioId = :id")
    public List<Pedido> recuperarPorIdDoUsuario(@Param("id") Integer id);

}
