package mx.utng.session26.model.service;

import mx.utng.session26.model.entity.ReservaHotel;
import java.util.List;

public interface IReservaHotelService {
    List<ReservaHotel> list();
    void save(ReservaHotel reserva);
    ReservaHotel getById(Long id);
    void delete(Long id);
}
