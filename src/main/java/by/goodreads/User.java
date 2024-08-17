package by.goodreads;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class User {
    private final String name, email, password;
    private final WebDriver driver;

    public User(String name, String email, String password, WebDriver driver) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.driver = driver;
    }

    public static User loadUserFromFile(String fileLocation, String userName, WebDriver driver) {
        File file = new File(fileLocation);
        String jsonString;
        try {
            jsonString = new String(Files.readAllBytes(Paths.get(file.toURI())));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JSONObject object = new JSONObject(jsonString);
        JSONObject user = object.getJSONObject("users").getJSONObject(userName);
        return new User(user.getString("name"), user.getString("email"), user.getString("password"), driver);
    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
