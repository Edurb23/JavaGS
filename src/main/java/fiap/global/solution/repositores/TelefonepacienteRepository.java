package fiap.global.solution.repositores;

import fiap.global.solution.infrastructure.database.DataBaseConfig;
import fiap.global.solution.models.Telefonepaciente;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class TelefonepacienteRepository {

    public  void  add(Telefonepaciente telefonepaciente) throws SQLException{
        var sql = "INSERT INTO T_JS_TELEFONE_PACIENTE (" +
                "id_telefone," +
                "id_paciente," +
                "nr_ddi," +
                "nr_ddd," +
                "nr_telefone," +
                "nm_operadora" +
                ") VALUES(S_T_JS_TELEFONE_PACIENTE.NEXTVAL,?,?,?,?,?)";
        try(
            var conn = DataBaseConfig.getConnection();
            var statement = conn.prepareStatement(sql)
        )
        {
            statement.setLong(1, telefonepaciente.getId_paciente());
            statement.setLong(2, telefonepaciente.getNr_ddi());
            statement.setLong(3, telefonepaciente.getNr_ddd());
            statement.setLong(4, telefonepaciente.getNr_telefone());
            statement.setString(5, telefonepaciente.getNm_operadora());
            statement.executeUpdate();
        }catch (SQLException e)
        {
            throw new SQLException(e);
        }
    }

    public Optional<Telefonepaciente> find(int id) throws SQLException{
        var sql = "SELECT * FROM T_JS_TELEFONE_PACIENTE WHERE ID_TELEFONE = ?";
        var telefonepaciente = new Telefonepaciente();
        try (
            Connection conn = DataBaseConfig.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)
        ){
            statement.setInt(1, id);
            try (ResultSet rs = statement.executeQuery()){
                if (rs.next())
                    telefonepaciente = new Telefonepaciente(
                            rs.getLong("id_telefone"),
                            rs.getLong("id_paciente"),
                            rs.getLong("nr_ddi"),
                            rs.getLong("nr_ddd"),
                            rs.getLong("nr_telefone"),
                            rs.getString("nm_operadora")
                    );
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }catch (SQLException e)
        {
            throw new SQLException(e);
        }
        return Optional.of(telefonepaciente);
    }
    public Optional<ArrayList<Telefonepaciente>> findAll() throws SQLException{
        var emailpacientes = new ArrayList<Telefonepaciente>();
        var sql = "SELECT * FROM T_JS_TELEFONE_PACIENTE";

        try (
            Connection conn = DataBaseConfig.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
        ) {
            var rs = statement.executeQuery();
            while (rs.next()) {
                emailpacientes.add(new Telefonepaciente(
                        rs.getLong("id_telefone"),
                        rs.getLong("id_paciente"),
                        rs.getLong("nr_ddi"),
                        rs.getLong("nr_ddd"),
                        rs.getLong("nr_telefone"),
                        rs.getString("nm_operadora")
                ));
            }

        }catch (SQLException e)
        {
            throw new SQLException(e);
        }
        return Optional.of(emailpacientes);
    }

    public void update(Telefonepaciente telefonepaciente){

        var sql = "UPDATE T_JS_TELEFONE_PACIENTE SET " +
                "id_paciente = ?," +
                "nr_ddi = ?," +
                "nr_ddd = ?," +
                "nr_telefone = ?," +
                "nm_operadora = ?" +
                " WHERE id_telefone = ? ";
        try (
            var conn = DataBaseConfig.getConnection();
            var statement = conn.prepareStatement(sql)
        ){
            statement.setLong(1, telefonepaciente.getId_paciente());
            statement.setLong(2, telefonepaciente.getNr_ddi());
            statement.setLong(3, telefonepaciente.getNr_ddd());
            statement.setLong(4, telefonepaciente.getNr_telefone());
            statement.setString(5, telefonepaciente.getNm_operadora());
            statement.setLong(6, telefonepaciente.getId_telefone());
            statement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void delete(int id_telefonepaciente){
        String sql = "DELETE FROM T_JS_TELEFONE_PACIENTE WHERE ID_TELEFONE = ?";

        try (
            var conn = DataBaseConfig.getConnection();
            var statement = conn.prepareStatement(sql)
        ){
            statement.setInt(1, id_telefonepaciente);
            statement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
