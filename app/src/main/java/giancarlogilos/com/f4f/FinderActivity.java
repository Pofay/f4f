package giancarlogilos.com.f4f;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import core.FilledGateway;
import core.ProduceSupplier;
import core.SupplierFinderModel;
import core.SupplierFinderPresenter;
import core.SupplierFinderView;
import core.SupplierGateway;
import core.TokenContainer;

/**
 * Created by Gilos on 2/23/2017.
 */

public class FinderActivity extends AppCompatActivity implements SupplierFinderView{

    @BindView(R.id.finder_view)
    TextView profileView;
    private SupplierFinderPresenter presenter;
    RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_finder);
        ButterKnife.bind(this);

        List<ProduceSupplier> suppliers = new ArrayList<>();
        suppliers.add(new ProduceSupplier());
        suppliers.add(new ProduceSupplier());
        SupplierGateway gateway = new FilledGateway(suppliers);
          String accountPreferences = "accountPreferences";
        TokenContainer tokenContainer = new TokenContainerImpl(getApplicationContext().
                getSharedPreferences(accountPreferences, Context.MODE_PRIVATE));
        SupplierFinderModel model = new SupplierFinderModel(gateway, tokenContainer);
        presenter = new SupplierFinderPresenter(this,model);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView = (RecyclerView) findViewById(R.id.supplier_recycler_view);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);

        Intent intent = getIntent();
        if(Intent.ACTION_SEARCH.equals(intent.getAction())){

        }

        



        //profileView.setText("FINDER");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.options_menu, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();

        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false);

        return true;
    }

    @Override
    public void loadSuppliers(List<ProduceSupplier> expected) {

    }
}
