package mx.utng.session26.model.dao;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import mx.utng.session26.model.entity.ListaDeseos;

@Repository
public class ListaDeseosDaoImpl implements IListaDeseosDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<ListaDeseos> list() {
        return em.createQuery("from ListaDeseos", ListaDeseos.class).getResultList();
    }

    @Override
    public void save(ListaDeseos deseo) {
        if (deseo.getId() != null && deseo.getId() > 0) {
            em.merge(deseo);
        } else {
            em.persist(deseo);
        }
    }

    @Override
    public ListaDeseos getById(Long id) {
        return em.find(ListaDeseos.class, id);
    }

    @Override
    public void delete(Long id) {
        ListaDeseos deseo = getById(id);
        if (deseo != null) {
            em.remove(deseo);
        }
    }
}