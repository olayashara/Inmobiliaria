package com.example.models;

import java.io.Serializable;

public class Cuenta implements Serializable {
    private static final long serialVersionUID = 1L;

    private int idCuenta;
    private int idUsuario;
    private int saldo;

    public Cuenta() {
    }

    public Cuenta(int idUsuario, int saldo) {
        this.idUsuario = idUsuario;
        this.saldo = saldo;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}