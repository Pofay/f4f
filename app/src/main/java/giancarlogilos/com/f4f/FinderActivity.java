package giancarlogilos.com.f4f;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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

/**
 * Created by Gilos on 2/23/2017.
 */

public class FinderActivity extends AppCompatActivity {

    @BindView(R.id.finder_view)
    TextView profileView;

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_finder);
        ButterKnife.bind(this);

        layoutManager = new LinearLayoutManager(this);
        List<Supplier> suppliers = new ArrayList<>();
        suppliers.add(new Supplier("Pofay"));
        suppliers.add(new Supplier("Pofire"));
        adapter = new SupplierListAdapter(suppliers);

        recyclerView = (RecyclerView) findViewById(R.id.supplier_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


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
}
