
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;


public class CalculadoraServer extends UnicastRemoteObject implements CalculadoraRemota {
    public CalculadoraServer() throws RemoteException {
    
    
    }

    @Override
    public int somar(int a, int b) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public int subtrair(int a, int b) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public int multiplicar(int a, int b) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public int dividir(int a, int b) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    public static void main(String[] args) throws RemoteException {
        
        CalculadoraServer objeto = new CalculadoraServer();
        
        LocateRegistry.createRegistry(1099);
        String string;
        
        try {
        LocateRegistry.createRegistry(1099);
            Remote obj = null;
        Naming.rebind("CalculadoraServer", obj);
        System.out.println("Calculadora ligada");
} catch (Exception ex) {
	
    System.err.println("Erro: " + ex.getMessage());
}
    }
}
