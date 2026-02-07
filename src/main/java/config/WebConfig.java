package config;

public class WebConfig {

    public static final String BASE_URL = "https://gist.github.com";
    public static final String BROWSER =
            System.getenv("BROWSER") != null ? System.getenv("BROWSER") : "chrome";

    public static final int TIMEOUT = 15;
}
