package mx.utng.session26.model.dao;
import java.util.List;
import mx.utng.session26.model.entity.Attendance;


public interface IAttendanceDao {
    List<Attendance> list();
    void save(Attendance attendance);
    Attendance getById(Long id);
    void delete(Long id);
}