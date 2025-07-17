package configs;

import constants.Constants;
import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties",
        "classpath:default.properties"
})
public interface TestPropertiesConfig extends org.aeonbits.owner.Config{
    @Key("browser")
    @DefaultValue("chrome")
    String browser();

    @Key("remoteUrl")
    String remoteUrl();

    @Key("baseUrl")
    @DefaultValue(Constants.BASE_URL)
    String getBaseUrl();

    @Key("username")
    String getUsername();

    @Key("password")
    String getPassword();

    @Key("apiBaseUrl")
    String getApiBaseUrl();

    @Key("login")
    String getLogin();

    @Key("password_login")
    String getPasswordLogin();

    @Key("selenium.remote.url")
    String getSeleniumRemoteUrl();
}
