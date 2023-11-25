package fiap.global.solution.repositores;

import fiap.global.solution.infrastructure.database.DataBaseConfig;
import fiap.global.solution.models.Prescricaodata;


import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

public class PrescricaodataRepository {

    public  void  add(Prescricaodata prescricaodata) throws SQLException{
        var sql = "INSERT INTO T_JS_PRESCRICAO_DATA (" +
                "id_prescricao_data," +
                "id_prescricao," +
                "id_medico," +
                "ds_laudo_medico," +
                "dt_inicio," +
                "dt_fim" +
                ") VALUES(S_T_JS_PRESCRICAO_DATA.NEXTVAL,?,?,?,?,?)";
        try(
            var conn = DataBaseConfig.getConnection();
            var statement = conn.prepareStatement(sql)
        ){
            statement.setLong(1, prescricaodata.getId_prescricao());
            statement.setLong(2, prescricaodata.getId_medico());
            statement.setString(3, prescricaodata.getDs_laudo_medico());
            statement.setDate(4, Date.valueOf(prescricaodata.getDt_inicio().toString()));
            statement.setDate(5, prescricaodata.getDt_fim() !=null ? Date.valueOf(Date.valueOf(prescricaodata.getDt_fim().toString()).toLocalDate()) : null);
            statement.executeUpdate();
        }catch (SQLException e)
        {
            throw new SQLException(e);
        }
    }

    public Optional<Prescricaodata> find(int id) throws SQLException{
        var sql = "SELECT * FROM T_JS_PRESCRICAO_DATA WHERE ID_PRESCRICAO_DATA = ?";
        var prescricaodata = new Prescricaodata();
        try (
            Connection conn = DataBaseConfig.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)
        ){
            statement.setInt(1, id);
            try (ResultSet rs = statement.executeQuery()){
                if (rs.next())
                    prescricaodata = new Prescricaodata(
                            rs.getLong("id_prescricao_data"),
                            rs.getLong("id_prescricao"),
                            rs.getLong("id_medico"),
                            rs.getString("ds_laudo_medico"),
                            rs.getDate("dt_fim")!=null ? rs.getDate("dt_fim").toLocalDate() : null,
                            rs.getDate("dt_inicio")!=null ? rs.getDate("dt_inicio").toLocalDate() : null

                    );
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }catch (SQLException e)
        {
            throw new SQLException(e);
        }
        return Optional.of(prescricaodata);
    }
    public Optional<ArrayList<Prescricaodata>> findAll() throws SQLException{
        var prescricaodatas = new ArrayList<Prescricaodata>();
        var sql = "SELECT * FROM T_JS_PRESCRICAO_DATA";

        try (
            Connection conn = DataBaseConfig.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
        ) {
            var rs = statement.executeQuery();
            while (rs.next()) {
                LocalDate dt_inicio = null;
                LocalDate dt_fim = null;
                dt_fim = rs.getDate("dt_fim")!=null ? rs.getDate("dt_fim").toLocalDate() : null;
                dt_inicio = rs.getDate("dt_inicio")!=null ? rs.getDate("dt_fim").toLocalDate() : null;
                prescricaodatas.add(new Prescricaodata(
                        rs.getLong("id_prescricao_data"),
                        rs.getLong("id_prescricao"),
                        rs.getLong("id_medico"),
                        rs.getString("ds_laudo_medico"),
                        dt_fim,
                        dt_inicio
                ));
            }

        }catch (SQLException e)
        {
            throw new SQLException(e);
        }
        return Optional.of(prescricaodatas);
    }

    public void update(Prescricaodata prescricaodata){

        var sql = "UPDATE T_JS_PRESCRICAO_DATA SET " +
                "id_prescricao = ?,"+
                "id_medico = ?,"+
                "ds_laudo_medico = ?," +
                "dt_inicio = ?," +
                "dt_fim = ?" +
                " WHERE id_prescricao_data = ?";
        try (
            var conn = DataBaseConfig.getConnection();
            var statement = conn.prepareStatement(sql)
        ){
            statement.setLong(1, prescricaodata.getId_prescricao());
            statement.setLong(2, prescricaodata.getId_medico());
            statement.setString(3, prescricaodata.getDs_laudo_medico());
            statement.setDate(4, Date.valueOf(prescricaodata.getDt_inicio().toString()));
            statement.setDate(5, prescricaodata.getDt_fim() !=null ? Date.valueOf(Date.valueOf(prescricaodata.getDt_fim().toString()).toLocalDate()) : null);
            statement.setLong(6, prescricaodata.getId_prescricao_data());
            statement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void delete(int id_prescricaodata){
        String sql = "DELETE FROM T_JS_PRESCRICAO_DATA WHERE ID_PRESCRICAO_DATA = ?";

        try (
            var conn = DataBaseConfig.getConnection();
            var statement = conn.prepareStatement(sql)
        ){
            statement.setInt(1, id_prescricaodata);
            statement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
