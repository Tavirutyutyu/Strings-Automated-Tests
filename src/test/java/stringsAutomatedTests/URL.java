package stringsAutomatedTests;

public enum URL {
    MAIN("http://localhost:5173"),
    LOGIN("http://localhost:5173/login"),
    SIGNUP("http://localhost:5173/signup"),
    CREATE("http://localhost:5173/posts/create"),
    ADMIN("http://localhost:5173/admin-dashboard");
    private final String url;

    URL(String url) {
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
