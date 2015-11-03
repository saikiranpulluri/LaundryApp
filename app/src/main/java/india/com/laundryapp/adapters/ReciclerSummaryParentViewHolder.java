package india.com.laundryapp.adapters;

import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;

import india.com.laundryapp.R;

/**
 * Created by luis on 28/10/15.
 */
public class ReciclerSummaryParentViewHolder extends ParentViewHolder {
    public TextView txtName;
    public TextView txtTotal;
    public ReciclerSummaryParentViewHolder(View itemView) {
        super(itemView);
        txtName = (TextView)itemView.findViewById(R.id.txtName);
        txtTotal =(TextView)itemView.findViewById(R.id.txtTotal);
    }
}
