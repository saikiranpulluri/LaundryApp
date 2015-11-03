package india.com.laundryapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;


import java.util.List;

import india.com.laundryapp.R;
import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;
/**
 * Created by luis on 28/10/15.
 */
public class ReciclerSummaryAdapter extends ExpandableRecyclerAdapter<ReciclerSummaryParentViewHolder, ReciclerSummaryChildViewHolder> {
    private LayoutInflater mInflater;
    public ReciclerSummaryAdapter(Context context, List<ParentListItem> itemList){
        super(itemList);
        mInflater = LayoutInflater.from(context);

    }
    @Override
    public ReciclerSummaryParentViewHolder onCreateParentViewHolder(ViewGroup viewGroup) {
        View view = mInflater.inflate(R.layout.recicler_view_summary_parent, viewGroup, false);
        return new ReciclerSummaryParentViewHolder(view);
    }

    @Override
    public ReciclerSummaryChildViewHolder onCreateChildViewHolder(ViewGroup viewGroup) {
        View view = mInflater.inflate(R.layout.recicler_view_summary_child,viewGroup,false);
        return new ReciclerSummaryChildViewHolder(view);
    }

    @Override
    public void onBindParentViewHolder(ReciclerSummaryParentViewHolder reciclerSummaryParentViewHolder, int i, ParentListItem parentListItem) {
        ReciclerSummaryParent parent =(ReciclerSummaryParent) parentListItem;
        reciclerSummaryParentViewHolder.txtName.setText(parent.getName());
        reciclerSummaryParentViewHolder.txtTotal.setText(parent.getTotalAmount());
    }

    @Override
    public void onBindChildViewHolder(ReciclerSummaryChildViewHolder reciclerSummaryChildViewHolder, int i, Object childList) {
        ReciclerSummaryChild child = (ReciclerSummaryChild)childList;
        reciclerSummaryChildViewHolder.productName.setText(child.getProductName());
        reciclerSummaryChildViewHolder.productValue.setText(child.getProductValue());
        reciclerSummaryChildViewHolder.totalProductsInCart.setText(child.getTotalProductsInCart());
    }
}
