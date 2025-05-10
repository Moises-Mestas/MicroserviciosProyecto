package com.example.pedido_db.entity;

import com.example.pedido_db.dto.Producto;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class DetallePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer pedidoId;   // ID del pedido asociado
    private Integer productoId; // ID del producto asociado
    private Integer cantidad;   // Cantidad de producto en el pedido

    @Column(precision = 10, scale = 2)
    private BigDecimal precioUnitario; // Precio por unidad del producto

    @Column(precision = 10, scale = 2)
    private BigDecimal total; // Total por este detalle (cantidad * precioUnitario)

    @Transient
    private Producto producto; // Relación con Producto, que se llena mediante Feign

    // Métodos Getter y Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Integer pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "DetallePedido{" +
                "id=" + id +
                ", pedidoId=" + pedidoId +
                ", productoId=" + productoId +
                ", cantidad=" + cantidad +
                ", precioUnitario=" + precioUnitario +
                ", total=" + total +
                '}';
    }
}
