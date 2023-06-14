public class ConexaoBanco {

    private  String url = "jdbc:postgresql://localhost/BDLivrariaLP";
    private  String user = "postgres";
    private  String password = "123456";

    private static  String Inserir_produto = "INSERT INTO cadastro" +
            "  (nome, quantidade, val_unit, dta) VALUES " +
            " (?, ?, ?, ?);";


    public static String getDeleteUsers() {
        return deleteUsers;
    }

    private static String deleteUsers = "delete from cadastro where id_cadastro = ?;";


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

