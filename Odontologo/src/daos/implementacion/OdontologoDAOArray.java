package daos.implementacion;
import daos.IDao;
import modelo.Odontologo;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOArray implements IDao<Odontologo> {
    private final List<Odontologo> deontologist = new ArrayList<>();
    private static final Logger LOGGER = Logger.getLogger(OdontologoDAOH2.class);


    @Override
    public Odontologo guardar(Odontologo odontologo)  {
        deontologist.add(odontologo);
        System.out.println("Odontólogo guardado en la colección ARRAY.");
        LOGGER.info("Odontólogo guardado con ID: " + odontologo.getId());
        return odontologo;
    }

    @Override
    public List<Odontologo> ListarTodo() {
        return new ArrayList<>(deontologist);
    }
}