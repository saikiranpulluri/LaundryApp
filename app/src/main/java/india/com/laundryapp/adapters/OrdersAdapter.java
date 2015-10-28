package india.com.laundryapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import india.com.laundryapp.R;
import india.com.laundryapp.model.Product;

/**
 * Created by mozido on 22/10/15.
 */
public class OrdersAdapter extends ArrayAdapter<Product>{
    private final ArrayList<Product> products;
    private final Context ctx;
    public OrdersAdapter(Context context, ArrayList<Product> products) {
        super(context, R.layout.detail_list_item, products);
        this.products = products;
        this.ctx = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater in = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = in.inflate(R.layout.detail_list_item,parent,false);
        TextView txtProductName = (TextView)v.findViewById(R.id.txtProductName);
        TextView txtProductValue = (TextView)v.findViewById(R.id.txtProductValue);
        txtProductName.setText(products.get(position).getProductName());
        txtProductValue.setText(products.get(position).getProductValue());
        return v;
    }
}
