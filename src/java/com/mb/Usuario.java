/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mb;



/**
 *
 * @author Cristhian
 */

public class Usuario {
    private String nombre;
    private String clave;
    private String email;
    private String telmovil;

    public Usuario(String nombre, String clave, String email, String telmovil) {
        this.nombre = nombre;
        this.clave = clave;
        this.email = email;
        this.telmovil = telmovil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelmovil() {
        return telmovil;
    }

    public void setTelmovil(String telmovil) {
        this.telmovil = telmovil;
    }

}
 


