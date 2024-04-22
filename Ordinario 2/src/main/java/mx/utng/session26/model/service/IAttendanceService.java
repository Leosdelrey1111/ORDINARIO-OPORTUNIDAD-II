package mx.utng.session26.model.service;
import mx.utng.session26.model.entity.Attendance;
import java.util.List;

public interface IAttendanceService {
    List<Attendance> list();
    void save(Attendance attendance);
    Attendance getById(Long id);
    void delete(Long id);
}