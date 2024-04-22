package mx.utng.session26.model.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.utng.session26.model.dao.IBecaDao;
import mx.utng.session26.model.entity.Beca;

@Service
public class BecaServiceImpl implements IBecaService {

    @Autowired
    private IBecaDao dao;

    @Transactional(readOnly = true)
    @Override
    public List<Beca> list() {
        return dao.list();
    }

    @Transactional
    @Override
    public void save(Beca beca) {
        dao.save(beca);
    }

    @Transactional(readOnly = true)
    @Override
    public Beca getById(Long id) {
        return dao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }
}