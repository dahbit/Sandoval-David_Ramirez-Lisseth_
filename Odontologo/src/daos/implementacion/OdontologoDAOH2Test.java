package daos.implementacion;

import modelo.Odontologo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OdontologoDAOH2Test {

    private OdontologoDAOH2 odontologoDAO;

    @BeforeEach
    public void setUp() {

        odontologoDAO = new OdontologoDAOH2();


    }

    @Test
    public void testGuardarYListarOdontologos() {

        Odontologo odontologo1 = new Odontologo("Sandoval", "David", "12345");
        Odontologo odontologo2 = new Odontologo("Ramirez", "Lisseth ", "67890");

        odontologoDAO.guardar(odontologo1);
        odontologoDAO.guardar(odontologo2);


        List<Odontologo> odontologos = odontologoDAO.ListarTodo();





        assertEquals("Sandoval", odontologos.get(0).getApellido());
        assertEquals("David", odontologos.get(0).getNombre());
        assertEquals("12345", odontologos.get(0).getNoMatricula());

        assertEquals("Ramirez", odontologos.get(1).getApellido());
        assertEquals("Lisseth ", odontologos.get(1).getNombre());
        assertEquals("67890", odontologos.get(1).getNoMatricula());
    }
}
