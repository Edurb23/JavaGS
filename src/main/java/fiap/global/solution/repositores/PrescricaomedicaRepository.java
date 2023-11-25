package fiap.global.solution.repositores;

import fiap.global.solution.infrastructure.database.DataBaseConfig;
import fiap.global.solution.models.Prescricaomedica;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

public class PrescricaomedicaRepository {

    public  void  add(Prescricaomedica prescricaomedica) throws SQLException{
        var sql = "INSERT INTO T_JS_PRESCRICAO_MEDICA (" +
                "id_prescricao," +
                "id_paciente," +
                "id_medicamento," +
                "ds_posologia," +
                "ds_instrucoes," +
                "qt_medicamento," +
                "dt_prescricao" +
                ") VALUES(S_T_JS_PRESCRICAO_MEDICA.NEXTVAL,?,?,?,?,?,?)";
        try(
            var conn = DataBaseConfig.getConnection();
            var statement = conn.prepareStatement(sql)
        )
        {
            statement.setLong(1, prescricaomedica.getId_paciente());
            statement.setLong(2, prescricaomedica.getId_medicamento());
            statement.setString(3, prescricaomedica.getDs_posologia());
            statement.setString(4, prescricaomedica.getDs_instrucoes());
            statement.setLong(5, prescricaomedica.getQt_medicamento());
            statement.setDate(6, Date.valueOf(prescricaomedica.getDt_prescricao().toString()));
            statement.executeUpdate();
        }catch (SQLException e)
        {
            throw new SQLException(e);
        }
    }

    public Optional<Prescricaomedica> find(int id) throws SQLException{
        var sql = "SELECT * FROM T_JS_PRESCRICAO_MEDICA WHERE ID_PRESCRICAO = ?";
        var prescricaomedica = new Prescricaomedica();
        try (
            Connection conn = DataBaseConfig.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)
        ){
            statement.setInt(1, id);
            try (ResultSet rs = statement.executeQuery()){
                if (rs.next())
                    prescricaomedica = new Prescricaomedica(
                            rs.getLong("id_prescricao"),
                            rs.getLong("id_paciente"),
                            rs.getLong("id_medicamento"),
                            rs.getString("ds_posologia"),
                            rs.getString("ds_instrucoes"),
                            rs.getInt("qt_medicamento"),
                            rs.getDate("dt_prescricao").toLocalDate()
                    );
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }catch (SQLException e)
        {
            throw new SQLException(e);
        }
        return Optional.of(prescricaomedica);
    }
    public Optional<ArrayList<Prescricaomedica>> findAll() throws SQLException{
        var prescricaomedicas = new ArrayList<Prescricaomedica>();
        var sql = "SELECT * FROM T_JS_PRESCRICAO_MEDICA";

        try (
            Connection conn = DataBaseConfig.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
        ) {
            var rs = statement.executeQuery();
            while (rs.next()) {
                prescricaomedicas.add(new Prescricaomedica(
                        rs.getLong("ID_PRESCRICAO"),
                        rs.getLong("ID_PACIENTE"),
                        rs.getLong("ID_MEDICAMENTO"),
                        rs.getString("DS_POSOLOGIA"),
                        rs.getString("DS_INSTRUCOES"),
                        rs.getInt("QT_MEDICAMENTO"),
                        rs.getDate("DT_PRESCRICAO").toLocalDate()
                ));
            }

        }catch (SQLException e)
        {
            throw new SQLException(e);
        }
        return Optional.of(prescricaomedicas);
    }

    public void update(Prescricaomedica prescricaomedica){

        var sql = "UPDATE T_JS_PRESCRICAO_MEDICA SET "+
                "id_paciente = ?," +
                "id_medicamento = ?," +
                "ds_posologia = ?," +
                "ds_instrucoes = ?," +
                "qt_medicamento = ?," +
                "dt_prescricao = ?" +
                " WHERE id_prescricao = ?";
        try (
            var conn = DataBaseConfig.getConnection();
            var statement = conn.prepareStatement(sql)
        ){
            statement.setLong(1, prescricaomedica.getId_paciente());
            statement.setLong(2, prescricaomedica.getId_medicamento());
            statement.setString(3, prescricaomedica.getDs_posologia());
            statement.setString(4, prescricaomedica.getDs_instrucoes());
            statement.setLong(5, prescricaomedica.getQt_medicamento());
            statement.setDate(6, Date.valueOf(prescricaomedica.getDt_prescricao().toString()));
            statement.setLong(7, prescricaomedica.getId_prescricao());
            statement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void delete(int id_prescricao){
        String sql = "DELETE FROM T_JS_PRESCRICAO_MEDICA WHERE ID_PRESCRICAO = ?";

        try (
            var conn = DataBaseConfig.getConnection();
            var statement = conn.prepareStatement(sql)
        ){
            statement.setInt(1, id_prescricao);
            statement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
