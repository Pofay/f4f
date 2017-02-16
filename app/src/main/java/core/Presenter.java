package core;

/**
 * Created by pofay on 2/16/17.
 */
public class Presenter {
    public Presenter(LoginModel model, LoginView view) {
        if (model == null)
            throw new NullPointerException();

        if (view == null)
            throw new NullPointerException();
    }
}
