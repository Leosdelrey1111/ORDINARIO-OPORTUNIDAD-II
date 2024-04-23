package mx.utng.session26.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.session26.model.entity.ReservaHotel;
/*
 * Clase repositorio o dao, utilizare la 
 * anotacion @Repository
 */

@Repository
public class ReservaHotelDaoImpl implements IReservaHotelDao{

    //Entity Manager y contexto de persistencia
    //Guarda internamente todas las entidads y
    //utiliza como una cache datos de BD
    //@PersistenceContext
    @Autowired
    private EntityManager em;


    @SuppressWarnings("unchecked")
    @Override
    public List<ReservaHotel> list() {
        return em.createQuery("from ReservaHotel").getResultList();
    }

    @Override
    public void save(ReservaHotel reserva) {
        if(reserva.getId() != null && reserva.getId() >0){
            //Actualizo estudiante
            em.merge(reserva);
        }else{
            //Creamos nuevo estudiante en la base
            em.persist(reserva);
        }
    }

    @Override
    public ReservaHotel getById(Long id) {
        return em.find(ReservaHotel.class, id);
    }

    @Override
    public void delete(Long id) {
        ReservaHotel reserva = getById(id);
        em.remove(reserva);
    }

    
}