package credentials;

public class Credentials {

    private static final String URL = "jdbc:postgresql://localhost:5432/inventario_productos";
    private static final   String USER = "postgres";
    private static final String PASSWORD = "jhonatan2025sql";

    public String getUrl(){
        return URL;
    }
    public String getUser() {
        return USER;
    }
    public String getPassword(){
        return PASSWORD;
    }
}
