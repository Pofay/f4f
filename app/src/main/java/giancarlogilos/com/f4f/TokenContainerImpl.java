package giancarlogilos.com.f4f;

import android.content.SharedPreferences;

import core.TokenContainer;

/**
 * Created by Gilos on 3/8/2017.
 */
public class TokenContainerImpl implements TokenContainer {

    private final SharedPreferences sharedPreferences;

    public TokenContainerImpl(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    public String getToken() {
        return sharedPreferences.getString("token", "");
    }
}
