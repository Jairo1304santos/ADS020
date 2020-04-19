
package menagedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean
@RequestScoped
public class CadastroMB {

    
    public CadastroMB() {
    }
    
    public String salvar(){
    
        return "lista";
    }
}
