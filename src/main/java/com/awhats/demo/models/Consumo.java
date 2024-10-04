package com.awhats.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="consumo")
public class Consumo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int idCliente;
    int mes;
    float costo;
    float descuento;
    float costo_t;
    String descripcion;

    public Consumo() {

    }

    public Consumo(int id, int idCliente, int mes, float costo, float descuento, float costo_t, String descripcion) {
        this.id = id;
        this.idCliente = idCliente;
        this.mes = mes;
        this.costo = costo;
        this.descuento = descuento;
        this.costo_t = costo_t;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setId_cliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public float getCosto_t() {
        return costo_t;
    }

    public void setCosto_t(float costo_t) {
        this.costo_t = costo_t;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public void setDescripcion(String descripcion){
        this.descripcion=descripcion;
    }
}