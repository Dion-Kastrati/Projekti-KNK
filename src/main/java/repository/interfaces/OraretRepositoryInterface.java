package repository.interfaces;

import models.Oraret;
import models.dto.CreateOraretDto;

import java.sql.SQLException;

public interface OraretRepositoryInterface{
    public Oraret insert(CreateOraretDto oraret) throws SQLException;
}
