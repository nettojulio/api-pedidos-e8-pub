package e8ilab2.apipedidos.models;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PedidosTest {

    Pedidos pedido = new Pedidos(1, 1, 2.99, "Teste", LocalDateTime.of(2022,5,30,22,30,59), "Ok");

    @Test
    void getId() {
        assertEquals(1, pedido.getId());
    }

    @Test
    void setId() {
        pedido.setId(2);
        assertEquals(2,pedido.getId());
    }

    @Test
    void getUsuarioId() {
        assertEquals(1, pedido.getUsuarioId());
    }

    @Test
    void setUsuarioId() {
        pedido.setId(2);
        assertEquals(2,pedido.getId());
    }

    @Test
    void getValorTotal() {
    }

    @Test
    void setValorTotal() {
    }

    @Test
    void getDescricao() {
    }

    @Test
    void setDescricao() {
    }

    @Test
    void getDataPedido() {
    }

    @Test
    void setDataPedido() {
    }

    @Test
    void getStatus() {
    }

    @Test
    void setStatus() {
    }

    @Test
    void testToString() {
    }
}