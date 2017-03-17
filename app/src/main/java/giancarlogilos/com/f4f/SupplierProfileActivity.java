package giancarlogilos.com.f4f;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SupplierProfileActivity extends AppCompatActivity {

    @BindView(R.id.user_profile_photo)
    ImageButton userProfilePhotoButton;

    @BindView(R.id.user_available_products)
    TextView avaibleProductsText;

    @BindView(R.id.user_comments_and_reviews)
    TextView commentsAndReviews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);





    }

}
