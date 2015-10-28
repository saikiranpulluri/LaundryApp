package india.com.laundryapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import india.com.laundryapp.adapters.ReciclerSummaryAdapter;
import india.com.laundryapp.adapters.ReciclerSummaryChild;
import india.com.laundryapp.adapters.ReciclerSummaryParent;

/**
 * Created by saikiran on 22/10/15.
 */
public class SummaryActivity extends AppCompatActivity {
    private Spinner spinnerCategories;
    private android.support.v7.widget.RecyclerView reciclerView;
    List<String> spinnerArray =  new ArrayList<String>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_back_white));
        TextView txtTitle = (TextView) toolbar.findViewById(R.id.toolbarTitle);
        txtTitle.setText(getString(R.string.mycart));

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("pressed", "true");
                onBackPressed();
            }
        });

        spinnerCategories =(Spinner)findViewById(R.id.spinner);
        spinnerArray.add(0, "Wash & Fold");
        spinnerArray.add(1, "Wash & Laundry");
        spinnerArray.add(2, "Laundry");
        spinnerArray.add(3, "Dry Cleaning");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategories.setAdapter(adapter);
        reciclerView = (android.support.v7.widget.RecyclerView)findViewById(R.id.summaryReciclerView);
        ReciclerSummaryAdapter adapter2 = new ReciclerSummaryAdapter(this,generateValues());

        reciclerView.setLayoutManager(new LinearLayoutManager(this));
        reciclerView.setAdapter(adapter2);

    }

    private ArrayList<ParentListItem> generateValues(){
        ArrayList<ReciclerSummaryParent> parent = new ArrayList<ReciclerSummaryParent>();

        parent.add(new ReciclerSummaryParent("Men","Rs.40"));
        parent.add(new ReciclerSummaryParent("Women","Rs.60"));
        ArrayList<ParentListItem> parentListItems = new ArrayList<>();

        for(int i=0;i<parent.size();i++) {
            Log.d("parentSize", parent.get(i) + "");
            if (i == 0) {
                ArrayList<ReciclerSummaryChild> childs = new ArrayList<>();
                childs.add(new ReciclerSummaryChild("Shirt", "RS.20", "img", "2"));
                childs.add(new ReciclerSummaryChild("Trowser Jeans", "RS.20", "img", "2"));
                ReciclerSummaryParent parents = parent.get(i);
                parents.setChildItemList(childs);
                parentListItems.add(parents);
            } else if (i == 1) {
                ArrayList<ReciclerSummaryChild> childs = new ArrayList<>();
                childs.add(new ReciclerSummaryChild("Shirt", "RS.20", "img", "2"));
                childs.add(new ReciclerSummaryChild("Shirt", "RS.20", "img", "2"));
                childs.add(new ReciclerSummaryChild("Shirt", "RS.20", "img", "2"));
                childs.add(new ReciclerSummaryChild("Shirt", "RS.20", "img", "2"));
                childs.add(new ReciclerSummaryChild("Shirt", "RS.20", "img", "2"));
                ReciclerSummaryParent parents = parent.get(i);
                parents.setChildItemList(childs);
                parentListItems.add(parents);
            }

        }
        return parentListItems;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(SummaryActivity.this, MainActivity.class));
        finish();
    }
}
