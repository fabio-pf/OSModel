package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Tipo_Usuario;
import br.edu.ifsul.modelo.Usuario;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestePersistirTipoUsuario {
    
  EntityManagerFactory emf;
    EntityManager em;
    

    public TestePersistirTipoUsuario() {

    }

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("OS-PU");
        em = emf.createEntityManager();
    }
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    @Test
    public void testePersistirPais() {
        boolean exception = false;
        try {
             Usuario obj = new Usuario();
            obj.setNome("Fabio Vedoy");
            obj.setEmail("vedoy30@gmail.com");
            obj.setNascimento(Calendar.getInstance());
            obj.setUsuario("fabio");
            obj.setSenha("123");
            Tipo_Usuario t = em.find(Tipo_Usuario.class, "ADMINISTRADOR");
            obj.getTipos_usuarios().add(t);
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            exception = true;
            
        }
        // verificando se o resultado é igual ao esperado
        Assert.assertEquals(false, exception);
    }
    
}
