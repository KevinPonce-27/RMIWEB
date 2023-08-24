
package com.rmiServer;

/**
 *
 * @author Cristhian
 */
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

// Creating Remote interface for our application
public interface RemoteInterface extends Remote {
    
    double suma (double a, double b) throws RemoteException;
    double resta (double a, double b) throws RemoteException;
    double multiplicacion (double a, double b) throws RemoteException;
    double division (double a, double b) throws RemoteException;
    public List getUsuarios() throws Exception;
    public int insertar(String usuario, String clave, String email, String telmovil) throws RemoteException;
    public int actualizar(String usuario, String clave, String email, String telmovil) throws RemoteException;
    public int eliminar(String usuario) throws RemoteException;
    
}