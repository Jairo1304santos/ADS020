
import dao.ContatoDAO;
import entidades.Contato;
import java.util.List;


public class TestaJPA {
    
    public static void main(String[] args) {
        
        ContatoDAO dao = new ContatoDAO();
        
        Contato contato = new Contato();
        
        contato.setNome("Victor");
        contato.setTelefone(98234567);
        dao.persist(contato);
        
        contato = new Contato();
        
        contato.setNome("Natan");
        contato.setTelefone(98254322);
        dao.persist(contato);
        
        contato = new Contato();
        
        contato.setNome("Arthur");
        contato.setTelefone(982521356);
        dao.persist(contato);
        
        contato.setNome("Jose Alvarenga");
        dao.merge(contato);
        
        contato = dao.find(2);
        dao.remove(contato);
        
        List<Contato> lista = (List<Contato>) dao.list();
         for( Contato cont: lista) {
            System.out.println(cont);
         }
        
        
        System.exit(0);
    }
}
