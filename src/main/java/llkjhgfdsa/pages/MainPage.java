package llkjhgfdsa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends PageTemplate implements DarkModePage{
    @FindBy(className = ".App")
    private WebElement AppDiv;

    @FindBy(css = ".darkLightBtn")
    private WebElement darkLightButton;

    public MainPage(WebDriver driver) {
        super(driver);
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
