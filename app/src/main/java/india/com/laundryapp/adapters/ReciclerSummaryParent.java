package india.com.laundryapp.adapters;


import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;

import java.util.List;

/**
 * Created by luis on 28/10/15.
 */
public class ReciclerSummaryParent implements ParentListItem {
    private String name;
    private String totalAmount;

    public ReciclerSummaryParent(String name, String totalAmount){
        setName(name);
        setTotalAmount(totalAmount);
    }

    private List<ReciclerSummaryChild> mChildItemList;
    /**
     * You can either return a newly created list of children here or attach them later
     */
    @Override
    public List<?> getChildItemList() {
        return mChildItemList;
    }

    /**
     * Allows you to specify if the list item should be expanded when first shown to the user
     */
    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setChildItemList(List<ReciclerSummaryChild> list) {
        mChildItemList = list;
    }
}
