package india.com.laundryapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.iconics.IconicsDrawable;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        ImageView imgPrivacyPolicyItem = (ImageView)findViewById(R.id.imageView2);
        ImageView imgTermsAndConditionsItem = (ImageView) findViewById(R.id.imageView3);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_back_white));
        imgPrivacyPolicyItem.setImageDrawable(new IconicsDrawable(this, GoogleMaterial.Icon.gmd_keyboard_arrow_right));
        imgTermsAndConditionsItem.setImageDrawable(new IconicsDrawable(this, GoogleMaterial.Icon.gmd_keyboard_arrow_right));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
