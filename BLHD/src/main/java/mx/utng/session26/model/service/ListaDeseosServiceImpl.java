package mx.utng.session26.model.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.utng.session26.model.dao.IListaDeseosDao;
import mx.utng.session26.model.entity.ListaDeseos;

@Service
public class ListaDeseosServiceImpl implements IListaDeseosService {

    @Autowired
    private IListaDeseosDao dao;

    @Transactional(readOnly = true)
    @Override
    public List<ListaDeseos> list() {
        return dao.list();
    }

    @Transactional
    @Override
    public void save(ListaDeseos deseo) {
        dao.save(deseo);
    }

    @Transactional(readOnly = true)
    @Override
    public ListaDeseos getById(Long id) {
        return dao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }
}