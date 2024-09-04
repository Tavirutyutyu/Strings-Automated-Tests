package llkjhgfdsa;

import llkjhgfdsa.pages.LoginPage;
import llkjhgfdsa.pages.MainPage;
import llkjhgfdsa.pages.PageTemplate;
import llkjhgfdsa.pages.SignupPage;

public enum URL {
    MAIN( "http://localhost:5173"),
    LOGIN( "http://localhost:5173/login"),
    SIGNUP( "http://localhost:5173/signup");
    private final String url;
    private URL(String url) {
        this.url = url;
    }
    public String getUrl() {
        return url;
    }

    public static String getUrlByName(String name) {
        String cleanName = name.strip().toUpperCase();
        return URL.valueOf(cleanName).getUrl();
    }
}
