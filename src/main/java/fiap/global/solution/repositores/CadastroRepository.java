package fiap.global.solution.repositores;

import fiap.global.solution.infrastructure.database.DataBaseConfig;
import fiap.global.solution.models.Cadastro;
import fiap.global.solution.models.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class CadastroRepository {

    public  void  add(Cadastro cadastro) throws SQLException{
        var sql = "INSERT INTO T_JS_CADASTRO (" +
                "id_cadastro," +
                "id_paciente," +
                "id_email," +
                "cd_senha" +
                ") VALUES(S_T_JS_CADASTRO.NEXTVAL,?,?,?)";
        try(
            var conn = DataBaseConfig.getConnection();
            var statement = conn.prepareStatement(sql)
        ){
            statement.setLong(1, cadastro.getId_paciente());
            statement.setLong(2, cadastro.getId_email());
            statement.setString(3, cadastro.getCd_senha());
            statement.executeUpdate();

        }catch (SQLException e)
        {
            throw new SQLException(e);
        }
    }

    public Optional<Cadastro> find(int id) throws SQLException{
        var sql = "SELECT * FROM T_JS_CADASTRO WHERE ID_CADASTRO = ?";
        var cadastro = new Cadastro();
        try (
                Connection conn = DataBaseConfig.getConnection();
                PreparedStatement statement = conn.prepareStatement(sql);
            ){
            statement.setInt(1, id);
            try (ResultSet rs = statement.executeQuery()){
                if (rs.next())
                    cadastro = new Cadastro(
                            rs.getLong("id_cadastro"),
                            rs.getLong("id_paciente"),
                            rs.getLong("id_email"),
                            rs.getString("cd_senha")
                    );
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }catch (SQLException e)
        {
            throw new SQLException(e);
        }
        return Optional.of(cadastro);
    }

    public Cadastro getUser(Login login) throws SQLException{
        var sql = "SELECT * FROM T_JS_CADASTRO C INNER JOIN T_JS_EMAIL_PACIENTE EMP ON C.ID_PACIENTE = EMP.ID_EMAIL WHERE EMP.DS_EMAIL = ? ";
        var cadastro = new Cadastro();
        try (
                Connection conn = DataBaseConfig.getConnection();
                PreparedStatement statement = conn.prepareStatement(sql)
            ){
            statement.setString(1, login.getEmail());
            try (ResultSet rs = statement.executeQuery()){
                if (rs.next())
                    cadastro = new Cadastro(
                            rs.getLong("id_cadastro"),
                            rs.getLong("id_paciente"),
                            rs.getLong("id_email"),
                            rs.getString("cd_senha")
                    );
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }catch (SQLException e)
        {
            throw new SQLException(e);
        }
        return login.getSenha().equals(cadastro.getCd_senha()) ? cadastro:null;
    }



    public Optional<ArrayList<Cadastro>> findAll() throws SQLException{
        var cadastros = new ArrayList<Cadastro>();
        var sql = "SELECT * FROM T_JS_CADASTRO";

        try (
            Connection conn = DataBaseConfig.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
        ){
            var rs = statement.executeQuery();
            while (rs.next()) {
                cadastros.add(new Cadastro(
                        rs.getLong("id_cadastro"),
                        rs.getLong("id_paciente"),
                        rs.getLong("id_email"),
                        rs.getString("cd_senha")
                ));
            }
        }catch (SQLException e)
        {
            throw new SQLException(e);
        }
        return Optional.of(cadastros);
    }

    public void update(Cadastro cadastro){

        var sql = "UPDATE T_JS_CADASTRO SET " +
                "id_paciente = ?," +
                "id_email = ?," +
                "cd_senha = ?" +
                " WHERE ID_CADASTRO = ? ";
        try (
                var conn = DataBaseConfig.getConnection();
                var statement = conn.prepareStatement(sql)
            ){
            statement.setLong(1, cadastro.getId_paciente());
            statement.setLong(2, cadastro.getId_email());
            statement.setString(3, cadastro.getCd_senha());
            statement.setLong(4, cadastro.getId_cadastro());
            statement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void delete(int id_cadastro){
        String sql = "DELETE FROM T_JS_CADASTRO WHERE ID_CADASTRO = ?";

        try (
            var conn = DataBaseConfig.getConnection();
            var statement = conn.prepareStatement(sql)
        ){
            statement.setInt(1, id_cadastro);
            statement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
