package giancarlogilos.com.f4f;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Gilos on 2/23/2017.
 */

public class ProfileActivity extends AppCompatActivity {

    @BindView(R.id.profile_view)
    TextView profileView;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_user_profile);
        ButterKnife.bind(this);

        profileView.setText("PROFILE");
    }
}
