package mx.utng.session26.model.dao;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import mx.utng.session26.model.entity.Beca;

@Repository
public class BecaDaoImpl implements IBecaDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Beca> list() {
        return em.createQuery("from Beca", Beca.class).getResultList();
    }

    @Override
    public void save(Beca beca) {
        System.out.println("Beca id=" + beca.getId());
        if (beca.getId() != null && beca.getId() > 0) {
            em.merge(beca);
        } else {
            em.persist(beca);
        }
    }

    @Override
    public Beca getById(Long id) {
        return em.find(Beca.class, id);
    }

    @Override
    public void delete(Long id) {
        Beca beca = getById(id);
        if (beca != null) {
            em.remove(beca);
        }
    }
}