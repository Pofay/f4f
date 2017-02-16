package core;

/**
 * Created by pofay on 2/16/17.
 */
public class LoginPresenter {
    private final LoginView view;

    public LoginPresenter(LoginModel model, LoginView view) {
        if (model == null)
            throw new NullPointerException();

        if (view == null)
            throw new NullPointerException();
        this.view = view;
    }

    public void onVerifyCredentials(String invalid_username, String invalid_password) {

        view.showCredentialsAreInvalid();

    }
}
