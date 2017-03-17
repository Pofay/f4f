package giancarlogilos.com.f4f;

import android.content.Intent;
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
import core.ProduceSupplierViewModel;
import core.SupplierFinderView;
import core.SupplierProfilePresenter;
import core.SupplierProfileView;

public class SupplierProfileActivity extends AppCompatActivity implements SupplierProfileView{

    @BindView(R.id.user_profile_photo)
    ImageButton userProfilePhotoButton;

    @BindView(R.id.user_available_products)
    TextView availableProductsText;

    @BindView(R.id.user_profile_name)
    TextView userProfileName;

    @BindView(R.id.user_comments_and_reviews)
    TextView commentsAndReviews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        Intent i = getIntent();

        ProduceSupplierViewModel vm = i.getParcelableExtra("supplier");

        userProfileName.setText(vm.name);

        SupplierProfilePresenter presenter = new SupplierProfilePresenter(this);

        availableProductsText.setOnClickListener((view) -> presenter.onDisplayAvailableItemsFor(vm));
    }

    @Override
    public void displayAvailableItemsFor(ProduceSupplierViewModel supplier) {
        Intent i = new Intent(this, SupplierProductsActivity.class);
        i.putExtra("supplier", supplier);
        startActivity(i);
    }
}
