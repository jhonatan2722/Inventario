package credentials;

public class Credentials {

    private static final String URL = "jdbc:postgresql://localhost:5432/bd";
    private static final   String USER = "user";
    private static final String PASSWORD = "password";

    public static  String getUrl(){
        return URL;
    }
    public static  String getUser() {
        return USER;
    }
    public static String getPassword(){
        return PASSWORD;
    }
}
