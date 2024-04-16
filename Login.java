
import java.util.HashMap;
import java.util.Map;

public class Login {
    private Map<String, String> userDatabase;

    public LoginManager() {
        userDatabase = new HashMap<>();


    }

    public boolean authorizePass(String username, String password) {
        String passwordOk = userDatabase.get(username);
        return passwordOk != null && passwordOk.equals(password);
    }
}
