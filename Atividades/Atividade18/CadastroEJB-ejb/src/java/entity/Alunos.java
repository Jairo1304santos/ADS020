package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "alunos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alunos.findAll", query = "SELECT a FROM Alunos a")
    , @NamedQuery(name = "Alunos.findByIdaluno", query = "SELECT a FROM Alunos a WHERE a.idaluno = :idaluno")
    , @NamedQuery(name = "Alunos.findByNome", query = "SELECT a FROM Alunos a WHERE a.nome = :nome")
    , @NamedQuery(name = "Alunos.findByMatricula", query = "SELECT a FROM Alunos a WHERE a.matricula = :matricula")})
public class Alunos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idaluno")
    private Integer idaluno;
    @Size(max = 45)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "matricula")
    private int matricula;

    public Alunos() {
    }

    public Alunos(Integer idaluno) {
        this.idaluno = idaluno;
    }

    public Alunos(Integer idaluno, int matricula) {
        this.idaluno = idaluno;
        this.matricula = matricula;
    }

    public Integer getIdaluno() {
        return idaluno;
    }

    public void setIdaluno(Integer idaluno) {
        this.idaluno = idaluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idaluno != null ? idaluno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alunos)) {
            return false;
        }
        Alunos other = (Alunos) object;
        if ((this.idaluno == null && other.idaluno != null) || (this.idaluno != null && !this.idaluno.equals(other.idaluno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Alunos[ idaluno=" + idaluno + " ]";
    }

}
