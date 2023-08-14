package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Aladdin_Test {
    private WebDriver driver;
    private FirefoxOptions options;
    private ProfilesIni profile;
    private FirefoxProfile aeca;
    private WebDriverWait wait;
    private JavascriptExecutor executor;
    private WebElement createCertButton, PKCS12, PKCS12Select, Continue;
//    private WebElement PKCS12;
//    private WebElement PKCS12Select;
//    private WebElement Continue;
    private WebElement CN;
    private WebElement RFC822NAME;
    private WebElement MS_UPN;
    private WebElement password;
    private WebElement confirmPassword;
    private WebElement keyAlgorithm;
    private WebElement RSAAlgorithm;
    private WebElement keyLength2048;
    private WebElement сreateModal;
    private WebElement Download;
    @Before
    public void setUp() {
        options = new FirefoxOptions();
        options.setAcceptInsecureCerts(true);
        profile = new ProfilesIni();
        aeca = profile.getProfile("default");
        options.setProfile(aeca);
        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        wait = new WebDriverWait(driver, Duration.ofSeconds(300));
    }
    @After
    public void tearDown() {
//        driver.quit();
    }
    @Test
    public void Aladdin_Test() {

        driver.get("https://192.168.111.100/access-certificates");

        executor = (JavascriptExecutor) driver;
        createCertButton = driver.findElement(By.xpath("//div[2]/button[@data-qa='createCertButton']"));
        executor.executeScript("arguments[0].click();", createCertButton);

        PKCS12 = driver.findElement(By.xpath("//li[@data-qa='PKCS#12']"));
        executor.executeScript("arguments[0].click();", PKCS12);

        PKCS12Select = driver.findElement(By.xpath("//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd MuiAutocomplete-input MuiAutocomplete-inputFocused css-7i43ew']"));
        PKCS12Select.click();
        PKCS12Select.sendKeys(Keys.DOWN, Keys.DOWN,Keys.DOWN,Keys.DOWN,Keys.DOWN,Keys.ENTER);

        Continue = driver.findElement(By.xpath("//button[@data-qa='Continue']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-qa='Continue']")));
        Continue.click();

        CN = driver.findElement(By.xpath("//input[@data-qa='CN']"));
        CN.click();
        CN.sendKeys("qwe");

        RFC822NAME = driver.findElement(By.xpath("//input[@data-qa='RFC822NAME']"));
        RFC822NAME.click();
        RFC822NAME.sendKeys("qwe");

        MS_UPN = driver.findElement(By.xpath("//input[@data-qa='MS_UPN']"));
        MS_UPN.click();
        MS_UPN.sendKeys("qwe@qwe");

        Continue.click();

        password = driver.findElement(By.xpath("//input[@name='password']"));
        password.click();
        password.sendKeys("Qwerty123");

        confirmPassword = driver.findElement(By.xpath("//input[@name='confirmPassword']"));
        confirmPassword.click();
        confirmPassword.sendKeys("Qwerty123");

        password.click();
        Continue.click();

        keyAlgorithm = driver.findElement(By.xpath("//div[@id='demo-simple-select1']"));
        keyAlgorithm.click();

        RSAAlgorithm = driver.findElement(By.xpath("//li[@data-value='RSA']"));
        RSAAlgorithm.click();

        keyAlgorithm.sendKeys(Keys.TAB, Keys.ENTER);

        keyLength2048 = driver.findElement(By.xpath("//li[@data-value='2048']"));
        keyLength2048.click();

        сreateModal = driver.findElement(By.xpath("//button[@data-qa='сreate-modal']"));
        executor.executeScript("arguments[0].click();", сreateModal);

        Download = driver.findElement(By.xpath("//button[@data-qa='Download']"));
        executor.executeScript("arguments[0].click();", Download);
    }
}