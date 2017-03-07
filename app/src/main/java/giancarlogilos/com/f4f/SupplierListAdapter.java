package giancarlogilos.com.f4f;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Gilos on 3/6/2017.
 */
public class SupplierListAdapter extends RecyclerView.Adapter<SupplierListAdapter.ViewHolder>{
    private final List<Supplier> suppliers;

    public SupplierListAdapter(List<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.supplier_row_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.supplierName.setText(suppliers.get(position).getName());
        holder.supplierItems.setText(String.format("Offers: %s", suppliers.get(position).itemOffers()));
        holder.
    }

    @Override
    public int getItemCount() {
        return suppliers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView supplierName;
        public TextView supplierItems;

        public ImageView supplierPicture;
        public ViewHolder(View itemView) {
            super(itemView);
            supplierPicture = (ImageView)  itemView.findViewById(R.id.supplier_picture);
            supplierName = (TextView) itemView.findViewById(R.id.name_section);
            supplierItems = (TextView) itemView.findViewById(R.id.offers_section);
        }
    }
}
