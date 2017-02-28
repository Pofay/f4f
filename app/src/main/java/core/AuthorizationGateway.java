package core;

import android.util.Log;

/**
 * Created by Gilos on 2/28/2017.
 */
public interface AuthorizationGateway {
    void authorize(LoginModel model, UserCredentials credentials);
}
