package llkjhgfdsa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends PageTemplate implements DarkModePage{
    @FindBy(className = "App")
    private WebElement AppDiv;

    @FindBy(className = "darkLightBtn")
    private WebElement darkLightButton;

    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    @Override
    public boolean isDark() {
        return AppDiv.getAttribute("id").equals("dark");
    }

    @Override
    public void clickDarkModeButton() {
        darkLightButton.click();
    }
}
