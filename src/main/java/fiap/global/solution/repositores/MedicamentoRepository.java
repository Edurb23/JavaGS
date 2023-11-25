package fiap.global.solution.repositores;

import fiap.global.solution.infrastructure.database.DataBaseConfig;
import fiap.global.solution.models.Medicamento;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class MedicamentoRepository {

    public  void  add(Medicamento medicamento) throws SQLException{
        var sql = "INSERT INTO T_JS_MEDICAMENTO (" +
                "id_medicamento," +
                "nm_medicamento," +
                "ds_detalhada_medicamento," +
                "nr_codigo_barras," +
                "ds_via" +
                ") VALUES(S_T_JS_MEDICAMENTO.NEXTVAL,?,?,?,?)";
        try(
            var conn = DataBaseConfig.getConnection();
            var statement = conn.prepareStatement(sql)
        )
        {
            statement.setString(1, medicamento.getNm_medicamneto());
            statement.setString(2, medicamento.getDs_detalhada_medicamento());
            statement.setLong(3, medicamento.getNr_codigo_barras());
            statement.setString(4, medicamento.getDs_via());
            statement.executeUpdate();
        }catch (SQLException e)
        {
            throw new SQLException(e);
        }
    }

    public Optional<Medicamento> find(int id) throws SQLException{
        var sql = "SELECT * FROM T_JS_MEDICAMENTO WHERE ID_MEDICAMENTO = ?";
        var medicamento = new Medicamento();
        try (
            Connection conn = DataBaseConfig.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)
        ){
            statement.setInt(1, id);
            try (ResultSet rs = statement.executeQuery()){
                if (rs.next())
                    medicamento = new Medicamento(
                            rs.getLong("id_medicamento"),
                            rs.getString("nm_medicamento"),
                            rs.getString("ds_detalhada_medicamento"),
                            rs.getLong("nr_codigo_barras"),
                            rs.getString("ds_via")
                    );
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }catch (SQLException e)
        {
            throw new SQLException(e);
        }
        return Optional.of(medicamento);
    }
    public Optional<ArrayList<Medicamento>> findAll() throws SQLException{
        var medicamentos = new ArrayList<Medicamento>();
        var sql = "SELECT * FROM T_JS_MEDICAMENTO";

        try (
            Connection conn = DataBaseConfig.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
        ){
            var rs = statement.executeQuery();
            while (rs.next()) {
                medicamentos.add(new Medicamento(
                        rs.getLong("id_medicamento"),
                        rs.getString("nm_medicamento"),
                        rs.getString("ds_detalhada_medicamento"),
                        rs.getLong("nr_codigo_barras"),
                        rs.getString("ds_via")
                ));
            }

        }catch (SQLException e)
        {
            throw new SQLException(e);
        }
        return Optional.of(medicamentos);
    }

    public void update(Medicamento medicamento){

        var sql = "UPDATE T_JS_MEDICAMENTO SET " +
                "nm_medicamento =?," +
                "ds_detalhada_medicamento = ?," +
                "nr_codigo_barras = ?," +
                "ds_via = ?" +
                " WHERE ID_MEDICAMENTO = ? ";
        try (
            var conn = DataBaseConfig.getConnection();
            var statement = conn.prepareStatement(sql)
        ){
            statement.setString(1, medicamento.getNm_medicamneto());
            statement.setString(2, medicamento.getDs_detalhada_medicamento());
            statement.setLong(3, medicamento.getNr_codigo_barras());
            statement.setString(4, medicamento.getDs_via());
            statement.setLong(5, medicamento.getId_medicamneto());
            statement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void delete(int id_medicamento){
        String sql = "DELETE FROM T_JS_MEDICAMENTO WHERE ID_MEDICAMENTO = ?";
        try (
            var conn = DataBaseConfig.getConnection();
            var statement = conn.prepareStatement(sql)
        ){
            statement.setInt(1, id_medicamento);
            statement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
