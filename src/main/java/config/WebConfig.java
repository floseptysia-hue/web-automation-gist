package config;

import io.github.cdimascio.dotenv.Dotenv;

public class WebConfig {
    private static final Dotenv dotenv = Dotenv.load();
    public static final String BASE_URL = "https://gist.github.com";
    public static final String BROWSER =
            System.getenv("BROWSER") != null ? System.getenv("BROWSER") : "chrome";
    public static final int TIMEOUT = 15;
    public static final String USERNAME = dotenv.get("USERNAME");
    public static final String EMAIL_GITHUB = dotenv.get("EMAIL_GITHUB");
    public static final String PASSWORD_GITHUB = dotenv.get("PASSWORD_GITHUB");
}
