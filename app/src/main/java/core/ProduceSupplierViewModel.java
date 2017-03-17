package core;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Gilos on 3/9/2017.
 */
public class ProduceSupplierViewModel implements Parcelable{

    public String productOffers;
    public String name;

    public ProduceSupplierViewModel(String name, String productOffers) {
        this.name = name;
        this.productOffers = productOffers;
    }

    protected ProduceSupplierViewModel(Parcel in) {
        productOffers = in.readString();
        name = in.readString();
    }

    public static final Creator<ProduceSupplierViewModel> CREATOR = new Creator<ProduceSupplierViewModel>() {
        @Override
        public ProduceSupplierViewModel createFromParcel(Parcel in) {
            return new ProduceSupplierViewModel(in);
        }

        @Override
        public ProduceSupplierViewModel[] newArray(int size) {
            return new ProduceSupplierViewModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(productOffers);
        dest.writeString(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProduceSupplierViewModel that = (ProduceSupplierViewModel) o;

        if (productOffers.equals(that.productOffers) && (name.equals(that.name)))
            return true;
        else
            return false;
    }
}
