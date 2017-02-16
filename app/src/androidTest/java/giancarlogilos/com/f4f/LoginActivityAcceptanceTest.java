package giancarlogilos.com.f4f;

import android.app.Activity;
import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.widget.Button;
import android.widget.EditText;

import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;

/**
 * Created by Gilos on 2/16/2017.
 */

public class LoginActivityAcceptanceTest {

    @Rule
    public ActivityTestRule<LoginActivity> loginRule = new ActivityTestRule<LoginActivity>(LoginActivity.class, true, false);

    @Test
    public void ItHasItsComponentsSetup() {
        loginRule.launchActivity(new Intent());


        assertThat(usernameField(), instanceOf(EditText.class));
        assertThat(passwordField(), instanceOf(EditText.class));
        assertThat(loginButton(), instanceOf(Button.class));
    }

    private EditText usernameField() {
        return (EditText) loginRule.getActivity().findViewById(R.id.username_field);
    }

    private Button loginButton() {
        return (Button) loginRule.getActivity().findViewById(R.id.login_button);
    }

    private EditText passwordField() {
        return (EditText) loginRule.getActivity().findViewById(R.id.password_field);
    }

}
