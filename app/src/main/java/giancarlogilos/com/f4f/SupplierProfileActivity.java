package giancarlogilos.com.f4f;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Gilos on 3/7/2017.
 */

public class SupplierProfileActivity extends AppCompatActivity {

    TextView supplierName;

    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        setContentView(R.layout.supplier_profile);

       // supplierName = (TextView) findViewById(R.id.user_profile_name);
        //Intent i = getIntent();
        //supplierName.setText(i.getStringExtra("name"));
    }
}
