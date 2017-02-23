package giancarlogilos.com.f4f;

import core.LoginModel;
import core.LoginPresenter;
import core.LoginView;

import static org.mockito.Mockito.mock;

/**
 * Created by Gilos on 2/23/2017.
 */

public class LoginPresenterBuilder {

    private LoginView view;
    private LoginModel model;

    public LoginPresenterBuilder() {
        this.view = mock(LoginView.class);
        this.model = mock(LoginModel.class);
    }

    public LoginPresenterBuilder withModel(LoginModel model) {
        this.model = model;
        return this;
    }

    public LoginPresenterBuilder withView(LoginView view) {
        this.view = view;
        return this;
    }

    public LoginPresenter build() {
        return new LoginPresenter(model, view);
    }
}
