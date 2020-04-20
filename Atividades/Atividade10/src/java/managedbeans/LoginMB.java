
package managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@ManagedBean
@RequestScoped
public class LoginMB {

    
    private String usuario;
    private String senha;

    public LoginMB() {

                        
   }
    
    public String login(){
        
        if (this.usuario != null && this.senha != null) {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpSession sessao = request.getSession();
            sessao.setAttribute("autenticado", true);
            return "lista";
        } else {
            return "login";
        }
    }
    

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
