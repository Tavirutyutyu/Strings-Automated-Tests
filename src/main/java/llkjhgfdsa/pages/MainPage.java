package llkjhgfdsa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainPage extends PageTemplate implements DarkModePage {
    @FindBy(className = "App")
    private WebElement AppDiv;

    @FindBy(className = "darkLightBtn")
    private WebElement darkLightButton;

    @FindBy(xpath = "//span[contains(text(), 'Create new Post')]")
    private WebElement createPostButton;

    @FindBy(tagName = "section")
    private List<WebElement> sectionList;

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

    public void likePost(String postDescription) {
        WebElement post = findPost(postDescription);
        if (post != null) {
            WebElement likeButton = post.findElement(By.xpath("//*[@class='heart']"));
            likeButton.click();
        } else {
            System.out.println("Post not found");
        }
    }
    public boolean isPostLiked(String postDescription) {
        WebElement post = findPost(postDescription);
        if (post != null) {
            WebElement likeButton = post.findElement(By.xpath("//*[@class='heart']"));
            WebElement pathElement = likeButton.findElement(By.tagName("path"));
            String fillValue = pathElement.getAttribute("fill");
            return "#F44336".equals(fillValue);
        } else {
            return false;
        }
    }

    public void clickCreatePostButton() {
        createPostButton.click();
    }

    private WebElement findPost(String postDescription) {
        for (WebElement post : sectionList) {
            WebElement titleElement = post.findElement(By.xpath("//p[not(@*)]"));

            JavascriptExecutor js = (JavascriptExecutor) driver;
            String postTitle = (String) js.executeScript(
                    "return arguments[0].childNodes[1].nodeValue.trim();", titleElement
            );
            if (postTitle.equals(postDescription)) {
                return post;
            }
        }
        return null;
    }
}
