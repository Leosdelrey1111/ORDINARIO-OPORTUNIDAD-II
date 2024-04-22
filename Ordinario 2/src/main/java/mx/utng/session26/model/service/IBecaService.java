package mx.utng.session26.model.service;
import mx.utng.session26.model.entity.Beca;
import java.util.List;

public interface IBecaService {
    List<Beca> list();
    void save(Beca beca);
    Beca getById(Long id);
    void delete(Long id);
}