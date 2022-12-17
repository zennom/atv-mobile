package app.modelo.meusclientes.datamodel;

public class ClienteDataModel {
    /**
     * Modelo Objeto Relacional
     **/

    /* Toda Classe Data Model tem esta estrutura */

    // 1 - Atributo nome da tabela
    public static final String TABELA = "cliente";

    //2 - Atributos um para um com os nomes dos campos
    public static final String ID = "id"; // integer
    public static final String NOME = "nome"; // text
    public static final String TELEFONE = "telefone"; // text
    public static final String EMAIL = "email"; // text
    public static final String CEP = "cep"; // integer
    public static final String LOGRADOURO = "logradouro"; // text
    public static final String NUMERO = "numero"; // text
    public static final String BAIRRO = "bairro"; // text
    public static final String CIDADE = "cidade"; // text
    public static final String ESTADO = "estado"; // text
    public static final String TERMOS_DE_USO = "termos_de_uso"; // integer

    //3 - Query para criar a tabela no banco de dados
    public static String queryCriarTabela = "";

    //4 - Método para gerar o Script para criar a tabela.
    public static String criarTabela() {
        //Concatenação de String
        queryCriarTabela += "CREATE TABLE " + TABELA + " (";
        queryCriarTabela += ID + " integer primary key autoincrement, ";
        queryCriarTabela += NOME + " text, ";
        queryCriarTabela += TELEFONE + " text, ";
        queryCriarTabela += EMAIL + " text, ";
        queryCriarTabela += CEP + " integer, ";
        queryCriarTabela += LOGRADOURO + " text, ";
        queryCriarTabela += NUMERO + " text, ";
        queryCriarTabela += BAIRRO + " text, ";
        queryCriarTabela += CIDADE + " text, ";
        queryCriarTabela += ESTADO + " text, ";
        queryCriarTabela += TERMOS_DE_USO + " integer ";
        queryCriarTabela += ")";

        return queryCriarTabela;
    }

}
