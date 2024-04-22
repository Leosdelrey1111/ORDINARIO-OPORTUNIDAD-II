package mx.utng.session26.model.dao;
import java.util.List;
import mx.utng.session26.model.entity.Beca;

public interface IBecaDao {
    List<Beca> list();
    void save(Beca beca);
    Beca getById(Long id);
    void delete(Long id);
    
}