package e8ilab2.apipedidos.controllers;

import com.google.gson.Gson;
import e8ilab2.apipedidos.dto.PedidoDTO;
import e8ilab2.apipedidos.models.Pedido;
import e8ilab2.apipedidos.services.IPedidoService;
import e8ilab2.apipedidos.services.SQSService;
import e8ilab2.apipedidos.utils.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static e8ilab2.apipedidos.utils.DateConverter.stringToDate;

@RestController
public class PedidoController {

    @Autowired
    private IPedidoService service;

    @GetMapping("/pedidos")
    public ResponseEntity<?> recuperarTodos() {
        List<Pedido> pedidos = service.recuperarTodos();

        if (pedidos.size() != 0) {
            return ResponseEntity.ok(service.recuperarTodos());
        }
        return null;
    }

    @GetMapping("/pedidos/{id}")
    public ResponseEntity<?> recuperarPorIdPedido(@PathVariable Integer id) {
        Pedido pedido = service.recuperarPorIdPedido(id);
        if (pedido != null) {
            return ResponseEntity.ok(pedido);
        }
        return ResponseEntity.status(404).body(new Messages(404, "Pedido não encontrado"));
    }

    @GetMapping("/pedidos/usuario/{id}")
    public ResponseEntity<?> recuperarPorIdDoUsuario(@PathVariable Integer id) {
        List<Pedido> pedido = service.recuperarPorIdDoUsuario(id);
        if (pedido.size() != 0) {
            return ResponseEntity.ok(pedido);
        }
        return ResponseEntity.status(404).body(new Messages(404, "Não foram encontrados pedidos para este usuário"));
    }

    @PostMapping("/pedidos")
    public ResponseEntity<?> cadastrarNovoPedido(@RequestBody PedidoDTO pedidoDTO) throws Exception {

        Pedido pedidoNew = new Pedido(pedidoDTO.getUsuarioId(), pedidoDTO.getValorTotal(), pedidoDTO.getDescricao(), stringToDate(pedidoDTO.getDataPedido()), pedidoDTO.getStatus());
        Pedido pedido = service.novoPedido(pedidoNew);

        if (pedido != null) {
            String pedidoDTOParsed = new Gson().toJson(pedidoDTO);
            System.out.println(pedidoDTOParsed);
            SQSService.sendMessage(pedidoDTOParsed);
            return ResponseEntity.status(201).body(pedido);
        }
        return ResponseEntity.badRequest().body(new Messages(400, "Dados Invalidos"));
    }

    @PutMapping("/pedidos/{id}")
    public ResponseEntity<?> alterarDados(@RequestBody Pedido dadosAlterados, @PathVariable Integer id) {
        if (service.recuperarPorIdPedido(id) == null) {
            return ResponseEntity.status(404).body(new Messages(404, "Pedido não encontrado"));
        }

        dadosAlterados.setId(id);

        Pedido pedidoAlterado = service.alterarDadosPedido(dadosAlterados, id);
        if (pedidoAlterado != null) {
            return ResponseEntity.ok(pedidoAlterado);
        }
        return ResponseEntity.badRequest().body(new Messages(400, "Dados invalidos para atualizacao"));
    }

    @DeleteMapping("/pedidos/{id}")
    public ResponseEntity<?> deletarPedido(@PathVariable Integer id) {
        if (service.recuperarPorIdPedido(id) == null) {
            return ResponseEntity.status(404).body(new Messages(404, "Pedido não encontrado"));
        }

        if (service.deletarPedido(id)) {
            return ResponseEntity.ok(new Messages(200, "Pedido deletado com sucesso"));
        }
        return ResponseEntity.badRequest().body(new Messages(400, "Erro ao deletar pedido"));
    }
}
