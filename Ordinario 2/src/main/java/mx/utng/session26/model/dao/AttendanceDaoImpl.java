package mx.utng.session26.model.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import java.util.List;

import mx.utng.session26.model.entity.Attendance;

@Repository
public class AttendanceDaoImpl implements IAttendanceDao {
    @Autowired
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Attendance> list() {
        return em.createQuery("from Attendance").getResultList();
    }

    @Override
    public void save(Attendance attendance) {
        if (attendance.getId() != null && attendance.getId() > 0) {
            em.merge(attendance);
        } else {
            em.persist(attendance);
        }
    }

    @Override
    public Attendance getById(Long id) {
        return em.find(Attendance.class, id);
    }

    @Override
    public void delete(Long id) {
        Attendance attendance = getById(id);
        em.remove(attendance);
    }    
}