package e8ilab2.apipedidos.dao;

import e8ilab2.apipedidos.models.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PedidoDAO extends JpaRepository<Pedido, Integer> {

    @Query("SELECT new e8ilab2.apipedidos.models.Pedido(pedido.id, pedido.usuarioId, pedido.valorTotal, pedido.descricao, pedido.dataPedido, pedido.status) FROM Pedido as pedido WHERE pedido.id = :id")
    public Pedido recuperarPorIdPedido(@Param("id") Integer id);

    Page<Pedido> findByusuarioId(Integer id, Pageable p);
}
