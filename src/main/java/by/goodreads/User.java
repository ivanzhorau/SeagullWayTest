package by.goodreads;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class User {
    private String login, email, password;

    public User(String login, String email, String password){
        this.email = email;
        this.login = login;
        this.password = password;
    }

    public static User loadUserFromFile(String fileLocation, String userName){
        File file = new File(fileLocation);
        String jsonString = null;
        try {
            jsonString = new String(Files.readAllBytes(Paths.get(file.toURI())));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JSONObject object = new JSONObject(jsonString);
        JSONObject user = object.getJSONObject("users").getJSONObject(userName);
        return new User(user.getString("login"), user.getString("email"), user.getString("password"));
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
