package com.example.pedido_db.entity;

import com.example.pedido_db.dto.Cliente;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer clienteId;   // ID del cliente que realizó el pedido
    private Timestamp fechaPedido; // Fecha y hora del pedido

    @Column(precision = 10, scale = 2)
    private BigDecimal total;  // Total del pedido

    private String estado; // Estado del pedido (pendiente, enviado, etc.)

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "pedido_id")
    private List<DetallePedido> detalle; // Lista de detalles del pedido (productos asociados)

    @Transient
    private Cliente cliente;  // Relación con Cliente, que se llena mediante Feign

    public Pedido() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public Timestamp getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Timestamp fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<DetallePedido> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<DetallePedido> detalle) {
        this.detalle = detalle;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pedido(Integer id, Integer clienteId, Timestamp fechaPedido, BigDecimal total, String estado, List<DetallePedido> detalle, Cliente cliente) {
        this.id = id;
        this.clienteId = clienteId;
        this.fechaPedido = fechaPedido;
        this.total = total;
        this.estado = estado;
        this.detalle = detalle;
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", clienteId=" + clienteId +
                ", fechaPedido=" + fechaPedido +
                ", total=" + total +
                ", estado='" + estado + '\'' +
                ", detalle=" + detalle +
                ", cliente=" + cliente +
                '}';
    }



}
