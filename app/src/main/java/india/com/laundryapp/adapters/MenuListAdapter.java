package india.com.laundryapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import india.com.laundryapp.R;

/**
 * Created by luis on 21/10/15.
 */
public class MenuListAdapter extends ArrayAdapter<String> {

    private final ArrayList<String> menu;
    private final Context ctx;
    public MenuListAdapter(Context context, ArrayList<String> menuOptions ) {
        super(context, R.layout.category_menu_list_item, menuOptions);
        this.menu = menuOptions;
        this.ctx = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater in = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = in.inflate(R.layout.category_menu_list_item, parent, false);
        TextView title =(TextView) v.findViewById(R.id.txtTitle);
        title.setText(menu.get(position));
        return v;
    }

}
