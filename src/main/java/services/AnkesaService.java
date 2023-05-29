package services;

import models.Ankesa;
import models.dto.storeAnkesa;
import repository.AnkesaRepository;

import java.sql.SQLException;

public class AnkesaService {
    public static Ankesa register(String email, String ankesa){

        storeAnkesa storeankesa=new storeAnkesa(email, ankesa);
        AnkesaRepository ankesaRepository=new AnkesaRepository();
        try {
            return ankesaRepository.insert(storeankesa);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
