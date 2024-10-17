package stringsAutomatedTests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

    @FindBy(xpath = "//section[div[contains(@class, 'onePost')] and img[contains(@class, 'cloud')]]")
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

    public void likePicturePost(String postDescription) {
        WebElement post = findPost(postDescription);
        Actions actions = new Actions(driver);
        if (post != null) {
            WebElement picture = post.findElement(By.xpath("//*[@class='picture']"));
            String src = picture.getAttribute("src");
            if (src != null && !src.isEmpty()) {
                actions.doubleClick(picture).perform();
            } else {
                System.out.println("Picture not uploaded for the post");
            }
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

    public boolean isPostInFeed(String postDescription) {
        WebElement post = findPost(postDescription);
        return post != null;
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

    public void reportAllPosts(){
        for (WebElement post : sectionList) {
            WebElement titleElement = post.findElement(By.xpath("//p[not(@*)]"));

            JavascriptExecutor js = (JavascriptExecutor) driver;
            String postTitle = (String) js.executeScript(
                    "return arguments[0].childNodes[1].nodeValue.trim();", titleElement
            );
            reportPost(postTitle);
        }
    }

    public void reportPost(String postDescription) {
        WebElement post = findPost(postDescription);
        if (post != null) {
            WebElement threeDot = post.findElement(By.xpath("//button[@class='threeDot']"));
            threeDot.click();
            WebElement reportButton = driver.findElement(By.xpath("//button[@class='reportButton']"));
            reportButton.click();
            WebElement reportText = post.findElement(By.xpath("//*[@class='reportReasonsBtn' and text()='Drugs']"));
            reportText.click();
        }
    }
}
