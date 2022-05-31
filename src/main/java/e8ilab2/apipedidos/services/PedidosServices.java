package e8ilab2.apipedidos.services;

import e8ilab2.apipedidos.dao.PedidosDAO;
import e8ilab2.apipedidos.models.Pedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class PedidosServices implements IPedidosServices {
    @Autowired
    private PedidosDAO dao;

    @Override
    public List<Pedidos> recuperarTodos() {
        return dao.recuperarTodos();
    }

    @Override
    public Pedidos recuperarPorIdPedido(Integer id) {
        return dao.recuperarPorIdPedido(id);
    }

    @Override
    public List<Pedidos> recuperarPorIdDoUsuario(Integer id) {
        return dao.recuperarPorIdDoUsuario(id);
    }

    @Override
    public Pedidos novoPedido(Pedidos novoPedido) {
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
    public Pedidos alterarDadosPedido(Pedidos dadosAlterados, Integer id) {
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
