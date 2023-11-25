package fiap.global.solution.repositores;

import fiap.global.solution.infrastructure.database.DataBaseConfig;
import fiap.global.solution.models.Paciente;

import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

public class PacienteRepository {

    public  void  add(Paciente paciente) throws SQLException {
        var sql = "INSERT INTO T_JS_PACIENTE (" +
                "id_paciente," +
                "nm_paciente," +
                "nr_cpf," +
                "nr_rg," +
                "fl_sexo_biologico," +
                "nr_altura," +
                "nr_peso," +
                "dt_nascimento" +
                ") VALUES(S_T_JS_PACIENTE.NEXTVAL,?,?,?,?,?,?,?)";
        try (
                var conn = DataBaseConfig.getConnection();
                var statement = conn.prepareStatement(sql)
        ){
            statement.setString(1, paciente.getNm_paciente());
            statement.setString(2, paciente.getNr_cpf());
            statement.setString(3, paciente.getNr_rg());
            statement.setString(4, paciente.getFl_sexo_biologico());
            statement.setFloat(5, paciente.getNr_altura());
            statement.setFloat(6, paciente.getNr_peso());
            statement.setDate(7, Date.valueOf(paciente.getDt_nascimento().toString()));
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public Optional<Paciente> find(int id) throws SQLException {
        var sql = "SELECT * FROM T_JS_PACIENTE WHERE ID_PACIENTE = ?";
        var paciente = new Paciente();
        try (
                var conn = DataBaseConfig.getConnection();
                PreparedStatement statement = conn.prepareStatement(sql)
        ) {
            statement.setInt(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next())
                    paciente = new Paciente(
                            rs.getLong("id_paciente"),
                            rs.getString("nm_paciente"),
                            rs.getString("nr_cpf"),
                            rs.getString("nr_rg"),
                            rs.getString("fl_sexo_biologico"),
                            rs.getFloat("nr_altura"),
                            rs.getFloat("nr_peso"),
                            rs.getDate("dt_nascimento").toLocalDate()
                    );
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return Optional.of(paciente);
    }
    public Optional<ArrayList<Paciente>> findAll() throws SQLException{
        var pacientes = new ArrayList<Paciente>();
        var sql = "SELECT * FROM T_JS_PACIENTE";

        try (
            Connection conn = DataBaseConfig.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)
        ) {
            var rs = statement.executeQuery();
            while (rs.next()) {
                pacientes.add(new Paciente(

                        rs.getLong("id_paciente"),
                        rs.getString("nm_paciente"),
                        rs.getString("nr_cpf"),
                        rs.getString("nr_rg"),
                        rs.getString("fl_sexo_biologico"),
                        rs.getFloat("nr_altura"),
                        rs.getFloat("nr_peso"),
                        rs.getDate("dt_nascimento").toLocalDate()
                ));
            }

        }catch (SQLException e)
        {
            throw new SQLException(e);
        }
        return Optional.of(pacientes);
    }

    public void update(Paciente paciente){

        var sql = "UPDATE T_JS_PACIENTE SET " +
                "nm_paciente = ?," +
                "nr_cpf = ?," +
                "nr_rg = ?," +
                "fl_sexo_biologico = ?," +
                "nr_altura = ?," +
                "nr_peso = ?," +
                "dt_nascimento = ?" +
                " WHERE ID_PACIENTE = ? ";
        try (
            var conn = DataBaseConfig.getConnection();
            var statement = conn.prepareStatement(sql)
        ){
            statement.setString(1, paciente.getNm_paciente());
            statement.setString(2, paciente.getNr_cpf());
            statement.setString(3, paciente.getNr_rg());
            statement.setString(4, paciente.getFl_sexo_biologico());
            statement.setFloat(5, paciente.getNr_altura());
            statement.setFloat(6, paciente.getNr_peso());
            statement.setDate(7, Date.valueOf(paciente.getDt_nascimento().toString()));
            statement.setLong(8, paciente.getId_paciente());
            statement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void delete(int id_paciente){
        String sql = "DELETE FROM T_JS_PACIENTE WHERE ID_PACIENTE = ?";

        try (
            var conn = DataBaseConfig.getConnection();
            var statement = conn.prepareStatement(sql)
        ){
            statement.setInt(1, id_paciente);
            statement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
