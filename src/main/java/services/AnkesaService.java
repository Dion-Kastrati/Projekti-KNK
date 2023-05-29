package services;

import models.Ankesa;
import models.dto.StoreAnkesaDto;
import repository.AnkesaRepository;

import java.sql.SQLException;

public class AnkesaService {
    public static Ankesa register(String email, String ankesa){

        StoreAnkesaDto storeankesa=new StoreAnkesaDto(email, ankesa);
        AnkesaRepository ankesaRepository=new AnkesaRepository();
        try {
            return ankesaRepository.insert(storeankesa);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
