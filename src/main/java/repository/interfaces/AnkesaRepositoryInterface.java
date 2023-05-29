package repository.interfaces;

import models.Ankesa;
import models.dto.storeAnkesa;

import java.sql.SQLException;

public interface AnkesaRepositoryInterface {
    public Ankesa insert (storeAnkesa ankesa) throws SQLException;
}
