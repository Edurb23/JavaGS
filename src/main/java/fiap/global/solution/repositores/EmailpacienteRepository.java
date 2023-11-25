package fiap.global.solution.repositores;

import fiap.global.solution.infrastructure.database.DataBaseConfig;
import fiap.global.solution.models.Emailpaciente;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class EmailpacienteRepository {

    public  void  add(Emailpaciente emailpaciente) throws SQLException{
        var sql = "INSERT INTO T_JS_EMAIL_PACIENTE (" +
                "id_email," +
                "id_paciente," +
                "ds_email," +
                "st_email" +
                ") VALUES(S_T_JS_EMAIL_PACIENTE.NEXTVAL,?,?,?)";
        try(
            var conn = DataBaseConfig.getConnection();
            var statement = conn.prepareStatement(sql)
        )
        {
            statement.setLong(1, emailpaciente.getId_paciente());
            statement.setString(2, emailpaciente.getDs_email());
            statement.setString(3, emailpaciente.getSt_email());
            statement.executeUpdate();
        }catch (SQLException e)
        {
            throw new SQLException(e);
        }
    }

    public Optional<Emailpaciente> find(int id) throws SQLException{
        var sql = "SELECT * FROM T_JS_EMAIL_PACIENTE WHERE id_paciente = ?";
        var emailpaciente = new Emailpaciente();
        try (
            Connection conn = DataBaseConfig.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)
        ){
            statement.setInt(1, id);
            try (ResultSet rs = statement.executeQuery()){
                if (rs.next())
                    emailpaciente = new Emailpaciente(
                            rs.getLong("id_email"),
                            rs.getLong("id_paciente"),
                            rs.getString("ds_email"),
                            rs.getString("st_email")
                    );
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }catch (SQLException e)
        {
            throw new SQLException(e);
        }
        return Optional.of(emailpaciente);
    }
    public Optional<ArrayList<Emailpaciente>> findAll() throws SQLException{
        var emailpacientes = new ArrayList<Emailpaciente>();
        var sql = "SELECT * FROM T_JS_EMAIL_PACIENTE";

        try (
            Connection conn = DataBaseConfig.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
        ) {
            var rs = statement.executeQuery();
            while (rs.next()) {
                emailpacientes.add(new Emailpaciente(
                        rs.getLong("id_email"),
                        rs.getLong("id_paciente"),
                        rs.getString("ds_email"),
                        rs.getString("st_email")
                ));
            }

        }catch (SQLException e)
        {
            throw new SQLException(e);
        }
        return Optional.of(emailpacientes);
    }

    public void update(Emailpaciente emailpaciente){

        var sql = "UPDATE T_JS_EMAIL_PACIENTE SET " +
                "ds_email = ?"+
                " WHERE id_paciente = ? ";
        try (
            var conn = DataBaseConfig.getConnection();
            var statement = conn.prepareStatement(sql)
        ){
            statement.setString(1, emailpaciente.getDs_email());
            statement.setLong(2, emailpaciente.getId_paciente());
            statement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void delete(int id_paciente){
        String sql = "DELETE FROM T_JS_EMAIL_PACIENTE WHERE id_paciente = ?";
        try (
            var conn = DataBaseConfig.getConnection();
            var statement = conn.prepareStatement(sql)
        ) {
            statement.setInt(1, id_paciente);
            statement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
