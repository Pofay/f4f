package giancarlogilos.com.f4f;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import core.InMemoryUserGateway;
import core.LoginModel;
import core.LoginPresenter;
import core.LoginView;
import core.SessionManager;
import core.AuthorizationGateway;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private AuthorizationGateway gateway;
    private SessionManager sessionManager;
    private LoginModel model;
    private LoginPresenter presenter;

    @BindView(R.id.username_field)
    EditText usernameField;
    @BindView(R.id.password_field)
    EditText passwordField;
    @BindView(R.id.login_button)
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        gateway = new InMemoryUserGateway();
        sessionManager = new AndroidSessionManager();
        model = new LoginModel(sessionManager, gateway);
        presenter = new LoginPresenter(model, this);
    }

    @OnClick(R.id.login_button)
    public void onLoginClick() {
        String username = usernameField.getText().toString();
        String password = passwordField.getText().toString();
        presenter.onLogin(username, password);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void goToProfile() {
        Intent i = new Intent(getApplicationContext(), ProfileActivity.class);
        startActivity(i);
    }

    @Override
    public void showFailureMessage(String message) {

    }
}
