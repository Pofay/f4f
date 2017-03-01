package giancarlogilos.com.f4f;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.test.rule.ActivityTestRule;
import android.widget.Button;
import android.widget.EditText;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertEquals;
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

    @Test
    public void ItShouldSaveTheAccessTokenToTheSharedPreferences() {
        loginRule.launchActivity(new Intent());
        SharedPreferences preferences = loginRule.getActivity()
                .getSharedPreferences("accountPreferences", Context.MODE_PRIVATE);
        String validUsername = "VALID_USERNAME";
        String validPassword = "VALID_PASSWORD";

        onView(withId(R.id.username_field)).perform(typeText(validUsername));
        onView(withId(R.id.password_field)).perform(typeText(validPassword));
        onView(withId(R.id.login_button)).perform(click());
        String actual = preferences.getString("token", "");

        assertEquals("accesstoken", actual);
    }

    @Ignore
    @Test
    public void ItShouldMoveToUserProfileOnLoggingIn() {
        loginRule.launchActivity(new Intent());

        String validUsername = "VALID_USERNAME";
        String validPassword = "VALID_PASSWORD";

        onView(withId(R.id.username_field)).perform(typeText(validUsername));
        onView(withId(R.id.password_field)).perform(typeText(validPassword));

        onView(withId(R.id.login_button)).perform(click());

        onView(withId(R.id.finder_view)).check(matches(withText("FINDER")));
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
