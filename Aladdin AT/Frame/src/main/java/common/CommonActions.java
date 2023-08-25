package common;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

import java.time.Duration;

import static common.Config.PLATFORM_AND_BROWSER;
import static constans.Constant.TimeoutVariable.IMPLICIT_WAIT;

public class CommonActions {
    public static WebDriver createDriver(){
        FirefoxOptions options;
        ProfilesIni profile;
        FirefoxProfile aeca;
        WebDriver driver = null;

        switch (PLATFORM_AND_BROWSER) {
            case "win_fox":
                    options = new FirefoxOptions();
                    options.setAcceptInsecureCerts(true);
                    profile = new ProfilesIni();
                    aeca = profile.getProfile("default");
                    options.setProfile(aeca);
                    driver = new FirefoxDriver(options);
                    break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
        return driver;
    }


}
