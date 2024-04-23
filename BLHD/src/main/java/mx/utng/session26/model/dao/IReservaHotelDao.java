package mx.utng.session26.model.dao;

import java.util.List;

import mx.utng.session26.model.entity.ReservaHotel;

public interface IReservaHotelDao {
    List<ReservaHotel> list();
    void save(ReservaHotel reserva);
    ReservaHotel getById(Long id);
    void delete(Long id);
}
