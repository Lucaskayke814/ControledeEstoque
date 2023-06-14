public class ConexaoBanco {

    private  String url = "jdbc:postgresql://localhost/BDLivrariaLP";
    private  String user = "postgres";
    private  String password = "123456";

    private static  String Inserir_produto = "INSERT INTO produto" +
            "  (nome_produto, quantidade, valor, dta, nome_fornecedor) VALUES " +
            " (?, ?, ?, ?, ?);";


    public static String getInserir_Fornecedor() {
        return Inserir_Fornecedor;
    }

    private static  String Inserir_Fornecedor = "INSERT INTO fornecedor" +
            "  (nome_fornecedor, cnpj) VALUES " +
            " (?, ?);";


    public static String getDeleteUsers() {
        return deleteUsers;
    }

    private static String deleteUsers = "delete from produto where id_produto = ?;";


    public  String getInserir_produto() {
        return Inserir_produto;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

}

