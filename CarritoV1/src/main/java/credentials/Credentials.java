package credentials;

public class Credentials {

    private static final String URL = "jdbc:postgresql://localhost:5432/name_bd";
    private static final   String USER = "user_bd";
    private static final String PASSWORD = "password_bd";

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
