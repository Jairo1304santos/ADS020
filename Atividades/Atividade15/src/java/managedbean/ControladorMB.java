package managedbean;

import ejb.StatefulEJB;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value = "controladorMB")
@RequestScoped
public class ControladorMB implements Serializable {

    public ControladorMB() {
        System.out.println("Criando o controlador...");
    }

    @EJB
    private StatefulEJB ejb;

    public StatefulEJB getEjb() {
        return ejb;
    }

    public void setEjb(StatefulEJB ejb) {
        this.ejb = ejb;
    }

}
