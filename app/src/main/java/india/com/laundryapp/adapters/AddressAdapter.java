package india.com.laundryapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import india.com.laundryapp.R;
import india.com.laundryapp.model.Address;

/**
 * Created by luis on 3/11/15.
 */
public class AddressAdapter extends ArrayAdapter<Address> {
    private final ArrayList<Address> addres;
    private final Context ctx;

    public AddressAdapter(Context context, ArrayList<Address> addresses) {
        super(context, R.layout.addresses_list_item, addresses);
        this.addres = addresses;
        this.ctx = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater in = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = in.inflate(R.layout.addresses_list_item, parent, false);
        TextView txtAddressName = (TextView)v.findViewById(R.id.txtAddressName);
        TextView txtAddressOwner = (TextView)v.findViewById(R.id.txtAddressOwner);
        TextView txtAddressDescription = (TextView)v.findViewById(R.id.txtAdressDescription);
        txtAddressName.setText(addres.get(position).getAddressName());
        txtAddressOwner.setText(addres.get(position).getAddressPerson());
        txtAddressDescription.setText(addres.get(position).getAddressDirection());
        return v;
    }
}
