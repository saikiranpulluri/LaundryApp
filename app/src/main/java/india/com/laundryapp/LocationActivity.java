package india.com.laundryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import india.com.laundryapp.adapters.AddressAdapter;
import india.com.laundryapp.model.Address;

public class LocationActivity extends AppCompatActivity {
private ListView lstAddresses;
    private ArrayList<Address> address = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_back_white));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        lstAddresses = (ListView)findViewById(R.id.lstAddresses);
        address.add(new Address("Home","Sai Kiran Pulluri","23 AV, street 45 L.A"));
        AddressAdapter adapter = new AddressAdapter(this,address);
        lstAddresses.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
