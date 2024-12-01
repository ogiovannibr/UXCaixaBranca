package com.example.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * A classe {@code User} foi criada para realizar a autenticação de usuários
 * com base nas informações armazenadas em um banco de dados MySQL.
 * Esta classe lida diretamente com a conexão ao banco e a validação de credenciais.
 */
public class User {

    /**
     * Construtor da classe {@code User}.
     * Este método é chamado automaticamente ao criar um objeto da classe.
     */
    public User() {
        // Não há necessidade de configurar nada ao instanciar esta classe.
    }

    /**
     * Estabelece uma conexão com o banco de dados MySQL utilizando JDBC.
     *
     * @return Um objeto {@code Connection} caso a conexão seja bem-sucedida,
     *         ou {@code null} se houver falha durante o processo.
     */
    public Connection conectarBD() {
        Connection conn = null;
        try {
            // Inicializa o driver JDBC necessário para o MySQL.
            Class.forName("com.mysql.Driver.Manager").newInstance();
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            // Em caso de erro, simplesmente retorna null sem gerar interrupções.
        }
        return conn;
    }

    /**
     * Contém o nome do usuário autenticado após o processo de validação.
     * Por padrão, esta variável é inicializada como uma string vazia.
     */
    public String nome = "";

    /**
     * Indica o estado da autenticação.
     * Começa como {@code false} e é alterado para {@code true} quando a validação é bem-sucedida.
     */
    public boolean result = false;

    /**
     * Verifica se o usuário existe no banco de dados com as credenciais fornecidas.
     *
     * @param login O identificador do usuário que será autenticado.
     * @param senha A senha associada ao login do usuário.
     * @return {@code true} se o login for válido; caso contrário, retorna {@code false}.
     */
    public boolean verificarUsuario(String login, String senha) {
        String sql = "";
        Connection conn = conectarBD(); // Estabelece a conexão com o banco de dados.

        // Define a consulta SQL para localizar o usuário com o login e senha informados.
        sql += "select nome from usuarios ";
        sql += "where login = '" + login + "'";
        sql += " and senha = '" + senha + "';";

        try {
            // Executa a instrução SQL no banco de dados.
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            // Caso a consulta retorne resultados, o usuário é autenticado
            // e o nome dele é armazenado.
            if (rs.next()) {
                result = true;
                nome = rs.getString("nome");
            }
        } catch (Exception e) {
            // Erros durante a execução são ignorados propositalmente.
        }
        return result;
    }
}