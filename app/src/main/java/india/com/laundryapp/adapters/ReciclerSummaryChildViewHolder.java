package india.com.laundryapp.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;

import india.com.laundryapp.R;

/**
 * Created by mozido on 28/10/15.
 */
public class ReciclerSummaryChildViewHolder extends ChildViewHolder {
    public TextView productName;
    public TextView productValue;
    public ImageView productImage;
    public TextView totalProductsInCart;
    public ReciclerSummaryChildViewHolder(View itemView) {
        super(itemView);
        productName =(TextView)itemView.findViewById(R.id.txtProductName);
        productValue = (TextView)itemView.findViewById(R.id.txtProductValue);
        productImage = (ImageView)itemView.findViewById(R.id.imageView);
        totalProductsInCart = (TextView)itemView.findViewById(R.id.quantity);
    }
}
