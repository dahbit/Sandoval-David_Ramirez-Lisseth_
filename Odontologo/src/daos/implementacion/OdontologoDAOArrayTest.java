package daos.implementacion;

import daos.implementacion.OdontologoDAOArray;
import modelo.Odontologo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;


class OdontologoDAOArrayTest {

    private OdontologoDAOArray odontologoDAO;
    @BeforeEach
    void setUp() {

        odontologoDAO = new OdontologoDAOArray();
    }



    @Test
    void guardar() {
        Odontologo odontologo = new Odontologo("Sandoval", "David", "12345");

        odontologoDAO.guardar(odontologo);

        List<Odontologo> deontologist = odontologoDAO.ListarTodo();
        assertEquals(1, deontologist.size());
        assertTrue(deontologist.contains(odontologo));
    }
}