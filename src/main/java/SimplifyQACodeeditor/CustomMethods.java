package SimplifyQACodeeditor;

import com.simplifyqa.customMethod.SqaAutowired;
import com.simplifyqa.customMethod.Sqabind;
import com.simplifyqa.sqadrivers.webdriver;
import com.simplifyqa.sqaobject.sqaobject;

public class CustomMethods {

    @SqaAutowired
    public Object demo_object;

    @Sqabind(object_template = {
            "sqa_record" }, action_description = "Logs in to the DemoQA application with username and password", action_displayname = "Login to AUT", actionname = "logontoAUT", paraname_equals_curobj = "false", paramnames = {
                    "Username", "Password" }, paramtypes = { "String",
                            "String" }, paramdescription = { "Username of the AUT", "Password of AUT" })
    public boolean logontoaut(String username, String password) {
        try {
            String URL = "https://demoqa.com/login";
            webdriver.launchapplication(URL);
            webdriver.entertext("xpath", "//input[@id='userName']", username);
            webdriver.entertext("xpath", "//input[@id='password']", password);
            webdriver.click("xpath", "//button[text()='Login']");
            sqaobject.getwebobjects("Invalid Cred").exists();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
