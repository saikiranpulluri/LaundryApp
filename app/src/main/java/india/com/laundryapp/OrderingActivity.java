package india.com.laundryapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import india.com.laundryapp.adapters.OrdersAdapter;
import india.com.laundryapp.model.Product;

/**
 * Created by saikiran on 22/10/15.
 */
public class OrderingActivity extends AppCompatActivity {
    private ArrayList<Product> products;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordering);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_back_white));
        TextView txtTitle = (TextView) toolbar.findViewById(R.id.toolbarTitle);
        ListView lstOrders = (ListView) findViewById(R.id.lstOrders);
        Bundle bundle = getIntent().getExtras();
        int position = bundle.getInt("position");
        int menuOption = bundle.getInt("option");
        switch (position) {
            case 0:
                switch (menuOption) {
                    case 0:
                        txtTitle.setText(getString(R.string.washable_men));
                        break;
                    case 1:
                        txtTitle.setText(getString(R.string.washable_women));
                        break;
                    case 2:
                        txtTitle.setText(getString(R.string.washable_children));
                        break;
                    case 3:
                        txtTitle.setText(getString(R.string.washable_others));
                        break;
                }

                break;
            case 1:
                switch (menuOption) {
                    case 0:
                        txtTitle.setText(getString(R.string.washandlaundry_men));
                        break;
                    case 1:
                        txtTitle.setText(getString(R.string.washable_women));
                        break;
                    case 2:
                        txtTitle.setText(getString(R.string.washandlaundry_children));
                        break;
                    case 3:
                        txtTitle.setText(getString(R.string.washandlaundry_others));
                        break;

                }
                break;
            case 2:
                switch (menuOption) {
                    case 0:
                        txtTitle.setText(getString(R.string.laundry_men));
                        break;
                    case 1:
                        txtTitle.setText(getString(R.string.laundry_women));
                        break;
                    case 2:
                        txtTitle.setText(getString(R.string.laundry_children));
                        break;
                    case 3:
                        txtTitle.setText(getString(R.string.laundry_others));
                        break;
                }
                break;
            case 3:
                switch (menuOption) {
                    case 0:
                        txtTitle.setText(getString(R.string.dryclean_men));
                        break;
                    case 1:
                        txtTitle.setText(getString(R.string.dryclean_women));
                        break;
                    case 2:
                        txtTitle.setText(getString(R.string.dryclean_children));
                        break;
                    case 3:
                        txtTitle.setText(getString(R.string.dryclean_others));
                        break;
                }
                break;
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("pressed", "true");
                onBackPressed();
            }
        });
        products = new ArrayList<>();
        products.add(0, new Product("Shirt/Tshirt", "RS.20", ""));
        products.add(1, new Product("Trouser/Denim/Jeans", "Rs.30", ""));
        products.add(2, new Product("Jacket", "Rs.40", ""));
        products.add(3, new Product("Sweater/Sweatshirt", "Rs.20", ""));
        OrdersAdapter adapter = new OrdersAdapter(this, products);
        lstOrders.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void imageClick(View view){
        Intent intent = new Intent(OrderingActivity.this, SummaryActivity.class);
        startActivity(intent);
    }

}
