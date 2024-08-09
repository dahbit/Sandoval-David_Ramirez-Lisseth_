package servicio;

import daos.IDao;
import modelo.Odontologo;
import daos.implementacion.OdontologoDAOH2;
import org.apache.log4j.Logger;

import java.util.List;

public class OdontologoService {


    private IDao<Odontologo> odontologoIDao;
    private static final Logger logger = Logger.getLogger(OdontologoService.class);



        public void guardar(Odontologo e){
            odontologoIDao.guardar(e);
        }


    public List<Odontologo> ListarTodo(){

        return odontologoIDao.ListarTodo();
    }

}
