package core;

/**
 * Created by pofay on 2/16/17.
 */
public class LoginPresenter {
    private final LoginView view;
    private final LoginModel model;

    public LoginPresenter(LoginModel model, LoginView view) {
        if (model == null)
            throw new NullPointerException();

        if (view == null)
            throw new NullPointerException();
        this.model = model;
        this.view = view;

    }

    public void onLogin(String username, String password) {

    }
}
