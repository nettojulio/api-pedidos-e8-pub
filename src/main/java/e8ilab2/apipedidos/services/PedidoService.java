package e8ilab2.apipedidos.services;

import e8ilab2.apipedidos.dao.PedidoDAO;
import e8ilab2.apipedidos.models.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class PedidoService implements IPedidoService {
    @Autowired
    private PedidoDAO dao;

    @Override
    public List<Pedido> recuperarTodos() {
        return dao.recuperarTodos();
    }

    @Override
    public Pedido recuperarPorIdPedido(Integer id) {
        return dao.recuperarPorIdPedido(id);
    }

    @Override
    public List<Pedido> recuperarPorIdDoUsuario(Integer id) {
        return dao.recuperarPorIdDoUsuario(id);
    }

    @Override
    public Pedido novoPedido(Pedido novoPedido) {
        try {
            if (novoPedido.getDataPedido() == null) {
                novoPedido.setDataPedido(LocalDateTime.now());
            }

            if (novoPedido.getUsuarioId() != null || novoPedido.getValorTotal() != null || novoPedido.getDescricao() != null || novoPedido.getStatus() != null) {
                return dao.save(novoPedido);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Pedido alterarDadosPedido(Pedido dadosAlterados, Integer id) {
        try {
            return dao.save(dadosAlterados);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean deletarPedido(Integer id) {
        try {
            dao.deleteById(Integer.parseInt(String.valueOf(id)));
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
