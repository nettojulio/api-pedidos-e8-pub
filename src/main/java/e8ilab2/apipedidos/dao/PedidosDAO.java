package e8ilab2.apipedidos.dao;

import e8ilab2.apipedidos.models.Pedidos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PedidosDAO extends CrudRepository<Pedidos, Integer> {
    @Query("SELECT new e8ilab2.apipedidos.models.Pedidos(pedidos.id, pedidos.usuarioId, pedidos.valorTotal, pedidos.descricao, pedidos.dataPedido, pedidos.status) FROM Pedidos as pedidos ORDER BY pedidos.id")
    public List<Pedidos> recuperarTodos();

    @Query("SELECT new e8ilab2.apipedidos.models.Pedidos(pedidos.id, pedidos.usuarioId, pedidos.valorTotal, pedidos.descricao, pedidos.dataPedido, pedidos.status) FROM Pedidos as pedidos WHERE pedidos.id = :id")
    public Pedidos recuperarPorIdPedido(@Param("id") Integer id);

    @Query("SELECT new e8ilab2.apipedidos.models.Pedidos(pedidos.id, pedidos.usuarioId, pedidos.valorTotal, pedidos.descricao, pedidos.dataPedido, pedidos.status) FROM Pedidos as pedidos WHERE pedidos.usuarioId = :id")
    public List<Pedidos> recuperarPorIdDoUsuario(@Param("id") Integer id);

}
