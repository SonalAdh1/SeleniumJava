import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// test cases
//        wrong username wrong pass
//        wrong username right pass
//        right user wrong pass
//        right user right pass
//
//        empty user empty pass
//        empty user correct pass
//        right user empty pass

//       check for all users

//check invalid characters , case sensitivity



public class Login {
    static WebDriver driver = new ChromeDriver();

    public static void Cases(String user, String pass){
        WebElement username = driver.findElement(By.id("user-name"));
        username.clear();
        username.sendKeys(user);

        WebElement password = driver.findElement(By.id("password"));
        password.clear();
        password.sendKeys(pass);

        WebElement login = driver.findElement(By.id("login-button"));
        login.click();


//       to display error message
//        String err_msg = driver.findElement(By.xpath("//*[@data-test='error']")).getText();
//        System.out.println(err_msg);
    }
    public static void Logout(){
        WebElement hamburger_icon = driver.findElement(By.id("react-burger-menu-btn"));
        hamburger_icon.click();
        driver.get("https://www.saucedemo.com/inventory.html#");
        WebElement clicking = driver.findElement(By.xpath("//*[@id='logout_sidebar_link']"));
        clicking.click();
    }
    public static void details(int x){
        String path = driver.findElement(By.xpath("//*[@id='item_"+x+"_title_link']/div")).getText();
        System.out.println(path);
    }
    public static void main(String[] args) {
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        Cases("standard_user","secret_sauce");
        System.out.println("Item Details: \n");

        for (int i=1; i<=5; i++)
        {
            details(i);
        }
        Logout();


    }
}
//        Cases("","");
//        Cases("", "secret_sauce");
////      Cases("standard_user","");
//        Cases("sonal", "passwordtest");
//        Cases("standard_user", "wrong pass");
//        Cases("performance_glitch_user", "wrong");
//        Cases("wrong_user", "secret_sauce");
//      other users
//        Cases("performance_glitch_user","secret_sauce");
//        Cases("problem_user","secret_sauce");
//        Cases("locked_out_user","secret_sauce");