package fiap.global.solution.repositores;

import fiap.global.solution.infrastructure.database.DataBaseConfig;
import fiap.global.solution.models.Medico;


import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

public class MedicoRepository {

    public  void  add(Medico medico) throws SQLException{
        var sql = "INSERT INTO T_JS_MEDICO (" +
                "id_medico," +
                "nm_medico," +
                "nr_crm," +
                "ds_especialidade," +
                "nr_rg," +
                "fl_sexo_biologico" +
                ") VALUES(S_T_JS_MEDICO.NEXTVAL,?,?,?,?,?)";
        try(
            var conn = DataBaseConfig.getConnection();
            var statement = conn.prepareStatement(sql)
        )
        {
            statement.setString(1, medico.getNm_medico());
            statement.setLong(2, medico.getNr_crm());
            statement.setString(3, medico.getDs_especialidade());
            statement.setString(4, medico.getNr_rg());
            statement.setString(5, medico.getFl_sexo_biologico());
            statement.executeUpdate();
        }catch (SQLException e)
        {
            throw new SQLException(e);
        }
    }

    public Optional<Medico> find(int id) throws SQLException{
        var sql = "SELECT * FROM T_JS_MEDICO WHERE ID_MEDICO = ?";
        var medico = new Medico();
        try (
            Connection conn = DataBaseConfig.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)
        ){
            statement.setInt(1, id);
            try (ResultSet rs = statement.executeQuery()){
                if (rs.next())
                    medico = new Medico(
                            rs.getLong("id_medico"),
                            rs.getString("nm_medico"),
                            rs.getLong("nr_crm"),
                            rs.getString("ds_especialidade"),
                            rs.getString("nr_rg"),
                            rs.getString("fl_sexo_biologico")
                    );
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }catch (SQLException e)
        {
            throw new SQLException(e);
        }
        return Optional.of(medico);
    }
    public Optional<ArrayList<Medico>> findAll() throws SQLException{
        var medicos = new ArrayList<Medico>();
        var sql = "SELECT * FROM T_JS_MEDICO";

        try (
            Connection conn = DataBaseConfig.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
        ) {
            var rs = statement.executeQuery();
            conn.close();
            while (rs.next()) {
                medicos.add(new Medico(

                        rs.getLong("id_medico"),
                        rs.getString("nm_medico"),
                        rs.getLong("nr_crm"),
                        rs.getString("ds_especialidade"),
                        rs.getString("nr_rg"),
                        rs.getString("fl_sexo_biologico")
                ));
            }

        }catch (SQLException e)
        {
            throw new SQLException(e);
        }
        return Optional.of(medicos);
    }

    public void update(Medico medico){

        var sql = "UPDATE T_JS_MEDICO SET " +
                "nm_medico = ?," +
                "nr_crm = ?," +
                "ds_especialidade = ?," +
                "nr_rg = ?," +
                "fl_sexo_biologico = ?" +
                " WHERE ID_MEDICO = ? ";
        try (
            var conn = DataBaseConfig.getConnection();
            var statement = conn.prepareStatement(sql)
        ){
            statement.setString(1, medico.getNm_medico());
            statement.setLong(2, medico.getNr_crm());
            statement.setString(3, medico.getDs_especialidade());
            statement.setString(4, medico.getNr_rg());
            statement.setString(5, medico.getFl_sexo_biologico());
            statement.setLong(6, medico.getId_medico());
            statement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void delete(int id_medico){
        String sql = "DELETE FROM T_JS_MEDICO WHERE ID_MEDICO = ?";

        try (
            var conn = DataBaseConfig.getConnection();
            var statement = conn.prepareStatement(sql)
        ){
            statement.setInt(1, id_medico);
            statement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
