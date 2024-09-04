package llkjhgfdsa.pages;

public interface DarkModePage {
    void clickDarkModeButton();
    boolean isDark();

    default public void setDarkMode() {
        if (!isDark()) {
            clickDarkModeButton();
        }
    }

    default public void setLightMode() {
        if (isDark()) {
            clickDarkModeButton();
        }
    }

}
