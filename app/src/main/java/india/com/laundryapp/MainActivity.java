package india.com.laundryapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import java.util.ArrayList;
import java.util.List;

import india.com.laundryapp.adapters.MenuListAdapter;
import india.com.laundryapp.fragments.ChildrenFragment;
import india.com.laundryapp.fragments.MenFragment;
import india.com.laundryapp.fragments.OthersFragment;
import india.com.laundryapp.fragments.WomenFragment;

public class MainActivity extends AppCompatActivity implements OnClickListener{
    private Drawer result;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ArrayList<String> menuOptions = new ArrayList<String>();
    private MenuListAdapter adapter = null;
    private ListView menuList;
    private ImageButton drawerButton;
    private ImageButton marketButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
       // setupTabIcons();
        TextView toolbarTitle = (TextView)toolbar.findViewById(R.id.toolbarTitle);
       drawerButton =(ImageButton)toolbar.findViewById(R.id.iconDrawerButton);
        marketButton =(ImageButton)toolbar.findViewById(R.id.iconMarketButton);

        menuList = (ListView)findViewById(R.id.menuList);
        toolbarTitle.setText(getString(R.string.app_name));
        drawerButton.setOnClickListener(this);
        marketButton.setOnClickListener(this);
        SecondaryDrawerItem item1 = new SecondaryDrawerItem().withName(R.string.title_section1).withIcon(GoogleMaterial.Icon.gmd_location_on);
        SecondaryDrawerItem item2 = new SecondaryDrawerItem().withName(R.string.title_section2).withIcon(FontAwesome.Icon.faw_bus);



        // Create the AccountHeader
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.degrade_blue)
                .addProfiles(
                        new ProfileDrawerItem().withName("Saikiran Pulluri | +91-9030955263").
                                withEmail("psk.knr@gmail.com").
                                withIcon(getResources().getDrawable(R.drawable.profile_picture))
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();

          result = new DrawerBuilder().withAccountHeader(headerResult).withActivity(this).
                addDrawerItems(
                        new PrimaryDrawerItem().withName(R.string.title_section_title1).withEnabled(false),
                        item1,
                        item2,
                        new SecondaryDrawerItem().withName(R.string.title_section3).withIcon(GoogleMaterial.Icon.gmd_directions_car),
                        new DividerDrawerItem(),
                        new PrimaryDrawerItem().withName(R.string.title_section_title2).withEnabled(false),
                        new SecondaryDrawerItem().withName(R.string.title_section4).withIcon(GoogleMaterial.Icon.gmd_help),
                        new SecondaryDrawerItem().withName(R.string.title_section5).withIcon(GoogleMaterial.Icon.gmd_info_outline),
                        new SecondaryDrawerItem().withName(R.string.title_section6).withIcon(GoogleMaterial.Icon.gmd_exit_to_app)
                ).
                withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem iDrawerItem) {
                        Log.d("valor de i", position + "");
                        switch (position) {
                            case 2:
                                // Address
                                Intent intentAddress = new Intent(MainActivity.this, LocationActivity.class);
                                startActivity(intentAddress);
                                break;
                            case 3:
                                //Orders

                                break;
                            case 4:
                                //Order Track

                                break;
                            case 7:
                                //FAQs

                                break;
                            case 8:
                                //About LWorks
                                Intent intent = new Intent(MainActivity.this, AboutUsActivity.class);
                                startActivity(intent);
                                break;
                            case 9:
                                //Logout

                                break;
                        }
                        return false;
                    }
                }).build();
        result.setSelection(1);
       configureAdapterToListView();
    }

    private void configureAdapterToListView(){
        menuOptions.add(0, "Wash & Fold");
        menuOptions.add(1,"Wash & Laundry");
        menuOptions.add(2, "Laundry");
        menuOptions.add(3, "Dry Cleaning");
        adapter = new MenuListAdapter(this,menuOptions);
        menuList.setAdapter(adapter);
        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, OrderingActivity.class);
                intent.putExtra("position", position);
                intent.putExtra("option", viewPager.getCurrentItem());
                startActivity(intent);
            }
        });
    }
    /*private void setupTabIcons() {

        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabOne.setText("ONE");
       // tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_tab_favourite, 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTwo.setText("TWO");
       // tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_tab_call, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabThree.setText("THREE");
      //  tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_tab_contacts, 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabThree);
    }*/

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new MenFragment(), getString(R.string.tab_title_1));
        adapter.addFrag(new WomenFragment(), getString(R.string.tab_title_2));
        adapter.addFrag(new ChildrenFragment(), getString(R.string.tab_title_3));
        adapter.addFrag(new OthersFragment(), getString(R.string.tab_title_4));

        viewPager.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iconDrawerButton:
                result.openDrawer();
                break;
            case R.id.iconMarketButton:
                goToCarShopScreen();
                break;
        }
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        //MENU DEACTIVATED
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void goToCarShopScreen(){
        Intent intent = new Intent(MainActivity.this, SummaryActivity.class);
        startActivity(intent);
    }


}
