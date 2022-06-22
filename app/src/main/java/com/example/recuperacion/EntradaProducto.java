package com.example.recuperacion;

import java.io.Serializable;

public class EntradaProducto implements Serializable {
    private String codigo;
    private String descripcion;
    private int cantidad;
    private float compra;
    private float venta;

    public EntradaProducto(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }
    public EntradaProducto(){

    };

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getCompra() {
        return compra;
    }

    public void setCompra(float compra) {
        this.compra = compra;
    }

    public float getVenta() {
        return venta;
    }

    public void setVenta(float venta) {
        this.venta = venta;
    }

    public float calcularPrecioVenta(){

         return venta*cantidad;
    }
    public float calcularPrecioCompra(){
        return compra*cantidad;
    }
    public float calcularGanancia(){

        return calcularPrecioVenta() - calcularPrecioCompra();
    }
}
