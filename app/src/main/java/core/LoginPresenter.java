package core;

/**
 * Created by pofay on 2/16/17.
 */
public class LoginPresenter {
    public LoginPresenter(LoginModel model, LoginView view) {
        if (model == null)
            throw new NullPointerException();

        if (view == null)
            throw new NullPointerException();
        view.showCredentialsAreInvalid();
    }

    public void onVerifyCredentials(String invalid_username, String invalid_password) {

    }
}
