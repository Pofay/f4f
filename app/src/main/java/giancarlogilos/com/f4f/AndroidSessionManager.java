package giancarlogilos.com.f4f;

import android.content.SharedPreferences;

import core.AuthorizationToken;
import core.SessionManager;

/**
 * Created by Gilos on 2/23/2017.
 */

public class AndroidSessionManager implements SessionManager {
    private final SharedPreferences preferences;

    public AndroidSessionManager(SharedPreferences sharedPreferences) {
        this.preferences = sharedPreferences;
    }

    @Override
    public void createSessionFor(AuthorizationToken token) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("token", token.token);
        editor.commit();
    }
}
