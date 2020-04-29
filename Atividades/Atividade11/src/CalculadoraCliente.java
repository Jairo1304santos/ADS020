
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;


public class CalculadoraCliente {
    
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        CalculadoraRemota obj = (CalculadoraRemota) Naming.lookup("//127.0.0.1:1099/CalculadoraServer");
        
        System.out.println("2 + 2 é igual a " + obj.somar(2,2));
System.out.println("2 - 2 é igual a " + obj.subtrair(2,2));
System.out.println("2 x 2 é igual a " + obj.multiplicar(2,2));
System.out.println("2 / 2 é igual a " + obj.dividir(2,2));

try {
        LocateRegistry.createRegistry(1099);
        Naming.rebind("CalculadoraServer", obj);
        System.out.println("Calculadora ligada");
} catch (Exception ex) {
	System.err.println("Erro: " + ex.getMessage());
}
    }
    
}
