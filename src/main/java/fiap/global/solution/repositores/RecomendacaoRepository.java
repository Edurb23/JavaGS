package fiap.global.solution.repositores;

import fiap.global.solution.infrastructure.database.DataBaseConfig;
import fiap.global.solution.models.Recomendacao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

public class RecomendacaoRepository {

    public  void  add(Recomendacao recomendacao) throws SQLException{
        var sql = "INSERT INTO T_JS_RECOMENDACAO (" +
                "id_recomendacao," +
                "id_prescricao," +
                "tp_recomendacao," +
                "ds_recomendacao," +
                "dt_inicio," +
                "dt_fim" +
                ") VALUES(S_T_JS_RECOMENDACAO.NEXTVAL,?,?,?,?,?)";
        try(
            var conn = DataBaseConfig.getConnection();
            var statement = conn.prepareStatement(sql)
        ){

            statement.setLong(1, recomendacao.getId_prescricao());
            statement.setString(2, recomendacao.getTp_recomendacao());
            statement.setString(3, recomendacao.getDs_recomendacao());
            statement.setDate(4, Date.valueOf(recomendacao.getDt_inicio().toString()));
            statement.setDate(5, recomendacao.getDt_fim() !=null ? Date.valueOf(Date.valueOf(recomendacao.getDt_fim().toString()).toLocalDate()) : null);
            statement.executeUpdate();

        }catch (SQLException e)
        {
            throw new SQLException(e);
        }
    }

    public Optional<Recomendacao> find(int id) throws SQLException{
        var sql = "SELECT * FROM T_JS_RECOMENDACAO WHERE ID_RECOMENDACAO = ?";
        var recomendacao = new Recomendacao();
        try (
            Connection conn = DataBaseConfig.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)
        ){
            statement.setInt(1, id);
            try (var rs = statement.executeQuery()){
                if (rs.next())
                    recomendacao = new Recomendacao(
                            rs.getLong("id_recomendacao"),
                            rs.getLong("id_prescricao"),
                            rs.getString("tp_recomendacao"),
                            rs.getString("ds_recomendacao"),
                            rs.getObject("dt_inicio")!=null ? rs.getDate("dt_inicio").toLocalDate() : null,
                            rs.getObject("dt_fim")!=null ? rs.getDate("dt_fim").toLocalDate() : null
                    );
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }catch (SQLException e)
        {
            throw new SQLException(e);
        }
        return Optional.of(recomendacao);
    }
    public Optional<ArrayList<Recomendacao>> findAll() throws SQLException{
        var recomendacaos = new ArrayList<Recomendacao>();
        var sql = "SELECT * FROM T_JS_RECOMENDACAO";

        try (
            Connection conn = DataBaseConfig.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
        ) {
            var rs = statement.executeQuery();
            while (rs.next()) {
                recomendacaos.add(new Recomendacao(
                        rs.getLong("id_recomendacao"),
                        rs.getLong("id_prescricao"),
                        rs.getString("tp_recomendacao"),
                        rs.getString("ds_recomendacao"),
                        rs.getObject("dt_inicio")!=null ? rs.getDate("dt_inicio").toLocalDate() : null,
                        rs.getObject("dt_fim")!=null ? rs.getDate("dt_fim").toLocalDate() : null
                ));
            }

        }catch (SQLException e)
        {
            throw new SQLException(e);
        }
        return Optional.of(recomendacaos);
    }

    public void update(Recomendacao recomendacao){

        var sql = "UPDATE T_JS_RECOMENDACAO SET " +
                "id_prescricao = ? ," +
                "tp_recomendacao = ? ," +
                "ds_recomendacao = ? ," +
                "dt_inicio = ? ," +
                "dt_fim = ?" +
                " WHERE ID_RECOMENDACAO = ? ";
        try (
            var conn = DataBaseConfig.getConnection();
            var statement = conn.prepareStatement(sql)
        ){
            statement.setLong(1, recomendacao.getId_prescricao());
            statement.setString(2, recomendacao.getTp_recomendacao());
            statement.setString(3, recomendacao.getDs_recomendacao());
            statement.setDate(4, Date.valueOf(recomendacao.getDt_inicio().toString()));
            statement.setDate(5, recomendacao.getDt_fim() !=null ? Date.valueOf(Date.valueOf(recomendacao.getDt_fim().toString()).toLocalDate()) : null);
            statement.setLong(6, recomendacao.getId_recomendacao());
            statement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void delete(int id_recomendacao){
        String sql = "DELETE FROM T_JS_RECOMENDACAO WHERE ID_RECOMENDACAO = ?";

        try (
            var conn = DataBaseConfig.getConnection();
            var statement = conn.prepareStatement(sql)
        ){
            statement.setInt(1, id_recomendacao);
            statement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
