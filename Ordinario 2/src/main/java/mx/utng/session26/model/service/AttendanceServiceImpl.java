package mx.utng.session26.model.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.session26.model.dao.IAttendanceDao;
import mx.utng.session26.model.entity.Attendance;

@Service
public class AttendanceServiceImpl implements IAttendanceService {
    @Autowired
    private IAttendanceDao dao;

    @Transactional(readOnly = true)
    @Override
    public List<Attendance> list() {
        return dao.list();
    }

    @Transactional
    @Override
    public void save(Attendance attendance) {
        dao.save(attendance);
    }

    @Transactional(readOnly = true)
    @Override
    public Attendance getById(Long id) {
        return dao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }


}