package mx.utng.session26.model.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.session26.model.entity.GaleriaArte;


@Repository
public class GaleriaArteDaoImpl implements IGaleriaArteDao{
     //Entity Manager y contexto de persistencia
    //Guarda internamente todas las entidads y
    //utiliza como una cache datos de BD
    //@PersistenceContext
    @Autowired
    private EntityManager em;


    @SuppressWarnings("unchecked")
    @Override
    public List<GaleriaArte> list() {
        return em.createQuery("from GaleriaArte").getResultList();
    }

    @Override
    public void save(GaleriaArte galeria) {
        if(galeria.getId() != null && galeria.getId() >0){
            em.merge(galeria);
        }else{
            em.persist(galeria);
        }
    }

    @Override
    public GaleriaArte getById(Long id) {
        return em.find(GaleriaArte.class, id);
    }

    @Override
    public void delete(Long id) {
        GaleriaArte galeria = getById(id);
        em.remove(galeria);
    }

    
}
