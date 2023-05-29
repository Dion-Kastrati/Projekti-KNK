package repository.interfaces;

import models.Ankesa;
import models.dto.StoreAnkesaDto;

import java.sql.SQLException;

public interface AnkesaRepositoryInterface {
    public Ankesa insert (StoreAnkesaDto ankesa) throws SQLException;
}
