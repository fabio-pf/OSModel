
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "OS")
public class OS implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_os", sequenceName = "seq_os_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_os", strategy = GenerationType.SEQUENCE)    
    private Integer id;
    @NotNull(message = "Campo inicio não pode ser nulo")
    @Temporal(TemporalType.DATE)
    @Column(name = "data_inicio", nullable = false)     
    private Calendar inicio;
    @Temporal(TemporalType.DATE)
    @Column(name = "data_fim")     
    private Calendar fim;
    @Column(name = "concluido")    
    private Boolean concluido;
    @NotNull(message = "O Usuário não pode ser nulo")
    @ManyToOne
    @JoinColumn(name = "usuario", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_usuario_usuario"))    
    private Usuario usuario;
    @NotNull(message = "O serviço não pode ser nulo")
    @ManyToOne
    @JoinColumn(name = "servico", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_serviço_nome"))        
    private Servico servico;

    public OS() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getInicio() {
        return inicio;
    }

    public void setInicio(Calendar inicio) {
        this.inicio = inicio;
    }

    public Calendar getFim() {
        return fim;
    }

    public void setFim(Calendar fim) {
        this.fim = fim;
    }

    public Boolean getConcluido() {
        return concluido;
    }

    public void setConcluido(Boolean concluido) {
        this.concluido = concluido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OS other = (OS) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    

   
   
}
