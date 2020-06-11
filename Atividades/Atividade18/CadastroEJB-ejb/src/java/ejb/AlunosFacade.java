package ejb;

import entity.Alunos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jairo
 */
@Stateless
public class AlunosFacade extends AbstractFacade<Alunos> {

    @PersistenceContext(unitName = "cadastroPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AlunosFacade() {
        super(Alunos.class);
    }

}
