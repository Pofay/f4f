package core;

/**
 * Created by pofay on 2/16/17.
 */
public class LoginModel {


    public LoginModel(UserRepository repository) {

    }

    public boolean verifyCredentials(String username, String password) {
        if (username == "VALID_USERNAME")
            return true;
        else
            return false;
    }
}
