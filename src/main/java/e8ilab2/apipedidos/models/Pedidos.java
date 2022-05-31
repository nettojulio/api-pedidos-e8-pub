package e8ilab2.apipedidos.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_pedidos")
public class Pedidos {

    @Id
    @Column(name = "id", nullable = false, columnDefinition = "SERIAL")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "usuario_id", nullable = false, columnDefinition = "INTEGER")
    private Integer usuarioId;

    @Column(name = "valor_total", nullable = false, columnDefinition = "DECIMAL")
    private Double valorTotal;

    @Column(name = "descricao", nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "data_pedido", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime dataPedido;

    @Column(name = "status", nullable = false, length = 50, columnDefinition = "VARCHAR")
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Pedidos() {
    }

    public Pedidos(Integer id, Integer usuarioId, Double valorTotal, String descricao, LocalDateTime dataPedido, String status) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.valorTotal = valorTotal;
        this.descricao = descricao;
        this.dataPedido = dataPedido;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Pedidos{" +
                "id=" + id +
                ", usuarioId=" + usuarioId +
                ", valorTotal=" + valorTotal +
                ", descricao='" + descricao + '\'' +
                ", dataPedido=" + dataPedido +
                ", status='" + status + '\'' +
                '}';
    }


}
