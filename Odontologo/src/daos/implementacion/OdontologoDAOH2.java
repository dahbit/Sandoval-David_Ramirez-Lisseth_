package daos.implementacion;

import daos.IDao;
import modelo.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2 implements IDao<Odontologo> {

    private static final Logger LOGGER = Logger.getLogger(OdontologoDAOH2.class);
    private static final String URL = "jdbc:h2:~/test";
    private static final String USER = "sa";
    private static final String PASSWORD = "";


    private Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        LOGGER.info("Guardando odontólogo: " + odontologo.getNombre() + " " + odontologo.getApellido());

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            String sql = "INSERT INTO ODONTOLOGOST (Nombre, Apellido, NoMatricula) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, odontologo.getNombre());
            preparedStatement.setString(2, odontologo.getApellido());
            preparedStatement.setString(3, odontologo.getNoMatricula());
            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                odontologo.setId(rs.getInt(1));
                LOGGER.info("Odontólogo guardado con ID: " + odontologo.getId());
            }
        } catch (Exception e) {
            LOGGER.error("Error al guardar el odontólogo", e);
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                LOGGER.error("Error al cerrar la conexión", e);
                e.printStackTrace();
            }
        }

        return odontologo;
    }

    @Override
    public List<Odontologo> ListarTodo() {
        List<Odontologo> odontologos = new ArrayList<>();
        LOGGER.info("Listando todos los odontólogos");

        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        try {
            connection = getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery("SELECT * FROM ODONTOLOGOST");

            while (rs.next()) {
                Odontologo odontologo = new Odontologo(
                        rs.getString("Apellido"),
                        rs.getString("Nombre"),
                        rs.getString("NoMatricula")
                );
                odontologo.setId(rs.getInt("ID"));
                odontologos.add(odontologo);
            }
        } catch (Exception e) {
            LOGGER.error("Error al listar los odontólogos", e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                LOGGER.error("Error al cerrar la conexión", e);
            }
        }

        return odontologos;
    }
}
