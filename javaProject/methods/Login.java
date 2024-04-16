package javaProject.methods;

import java.util.HashMap;
import java.util.Map;

public class Login {
    private Map<String, String> userDatabase;

    public Login() {
        userDatabase = new HashMap<>();
        userDatabase.put("Bobby", "purple");
        userDatabase.put("Greedo", "chinese");
    }

    public boolean authorizePass(String username, String password) {
        String passwordOk = userDatabase.get(username);
        return passwordOk != null && passwordOk.equals(password);
    }
}
