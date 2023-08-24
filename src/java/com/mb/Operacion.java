/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mb;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import com.rmiServer.RemoteInterface;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Cristhian
 */
@ManagedBean
@ViewScoped
public class Operacion implements Serializable {

    /**
     * Creates a new instance of Operacion
     */
    private RemoteInterface stub;
    private double operandoUno, operandoDos, resultado;
    private String usuario;
    private String clave;
    private String email;

    
    private String telmovil;
    private List<Usuario> registros;

    public Operacion() {
        stub = null;
        Registry registry;
        try {
            registry = LocateRegistry.getRegistry("localhost", 8888);
            try {
                // Looking up the registry for the remote object
                stub = (RemoteInterface) registry.lookup("metodosRmi");
            } catch (RemoteException | NotBoundException ex) {
                Logger.getLogger(Operacion.class.getName()).log(Level.SEVERE, null, ex);
                stub = null;
            }
        } catch (RemoteException ex) {
            Logger.getLogger(Operacion.class.getName()).log(Level.SEVERE, null, ex);
            stub = null;
        }
    }

    public String sumar() throws RemoteException {
        resultado = stub.suma(operandoUno, operandoDos);
        return "#";
    }

    public String restar() throws RemoteException {
        resultado = stub.resta(operandoUno, operandoDos);
        return "#";
    }

    public String multiplicar() throws RemoteException {
        resultado = stub.multiplicacion(operandoUno, operandoDos);
        return "#";
    }

    public String dividir() throws RemoteException {
        resultado = stub.division(operandoUno, operandoDos);
        return "#";
    }

    public void insertar() throws Exception {
        try {
            stub.insertar(usuario, clave, email, telmovil);
            //DIALOGO DE ACEPTADO
            boolean showSuccessDialog = true;
            RequestContext.getCurrentInstance().execute("PF('successDialog').show(); cleanFields();");

        } catch (RemoteException ex) {
            Logger.getLogger(Operacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminar(String usuario) {
        try {
            stub.eliminar(usuario);
        } catch (RemoteException ex) {
            Logger.getLogger(Operacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualizar(String usuarioAActualizar, String nuevaClave, String nuevoEmail, String nuevoTelmovil) {
        try {
            stub.actualizar(usuarioAActualizar, nuevaClave, nuevoEmail, nuevoTelmovil);
        } catch (RemoteException ex) {
            Logger.getLogger(Operacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getRegistros(ActionEvent actionEvent) throws RemoteException {
        try {
            registros = (ArrayList) stub.getUsuarios();
        } catch (Exception ex) {
            Logger.getLogger(Operacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList getRegistros() throws RemoteException {
        try {
            List<Usuario> listaUsuarios = stub.getUsuarios();
            return (ArrayList) listaUsuarios;
        } catch (Exception e) {
            return null;
        }
    }

    public double getOperandoUno() {
        return operandoUno;
    }

    public void setOperandoUno(double operandoUno) {
        this.operandoUno = operandoUno;
    }

    public double getOperandoDos() {
        return operandoDos;
    }

    public void setOperandoDos(double operandoDos) {
        this.operandoDos = operandoDos;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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
    
    public void cleanFields() {
    usuario = "";
    clave = "";
    email = "";
    telmovil = "";
}

}
