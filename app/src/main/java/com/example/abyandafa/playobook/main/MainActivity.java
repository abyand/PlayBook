package com.example.abyandafa.playobook.main;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.ColorRes;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.aurelhubert.ahbottomnavigation.notification.AHNotification;
import com.example.abyandafa.playobook.R;
import com.example.abyandafa.playobook.main.create.CreateEventActivity;
import com.example.abyandafa.playobook.main.fragments.event.EventFragment;
import com.example.abyandafa.playobook.main.fragments.ProfilFragment;
import com.example.abyandafa.playobook.main.fragments.SettingFragment;
import com.example.abyandafa.playobook.main.fragments.venue.VenueFragment;
import com.example.abyandafa.playobook.main.navigation.BottomBarAdapter;
import com.example.abyandafa.playobook.main.navigation.NoSwipePager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final int[] colors = {R.color.blue_300, R.color.blue_300, R.color.blue_300, R.color.blue_300};
    private final int EVENTS = 0;
    private final int VENUE = 1;
    private final int PROFILE = 2;
    private final int SETTINGS = 3;

    List<String> list = new ArrayList<>();
    private Toolbar toolbar;
    private NoSwipePager viewPager;
    private AHBottomNavigation bottomNavigation;
    private BottomBarAdapter pagerAdapter;

    private boolean notificationVisible = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_AUTO);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setAllRegion();


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //noinspection ConstantConditions
        getSupportActionBar().setTitle("Play'O Book");

        setupViewPager();
        bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);
        setupBottomNavBehaviors();
        setupBottomNavStyle();

        createFakeNotification();


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CreateEventActivity.class));
            }
        });

        addBottomNavigationItems();
        bottomNavigation.setCurrentItem(0);


        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
//                fragment.updateColor(ContextCompat.getColor(MainActivity.this, colors[position]));

                if (!wasSelected)
                {
                    viewPager.setCurrentItem(position);

                }
                // remove notification badge
                int lastItemPos = bottomNavigation.getItemsCount() - 1;
                if (notificationVisible && position == lastItemPos)
                    bottomNavigation.setNotification(new AHNotification(), lastItemPos);

                customToolbar(lastItemPos);



                return true;
            }
        });

    }

    private void customToolbar(int lastItemPos) {
        if(lastItemPos==0)
            toolbar.inflateMenu(R.menu.event_menu);
//        else if(lastItemPos==1)
//            toolbar.inflateMenu(R.menu.venue_menu);
//        else if(lastItemPos==2)
//            toolbar.inflateMenu(R.menu.profil_menu);
//        else if(lastItemPos==3)
//            toolbar.inflateMenu(R.menu.setting_menu);
    }

    private void setupViewPager() {
        viewPager = (NoSwipePager) findViewById(R.id.viewpager);
        viewPager.setPagingEnabled(false);
        pagerAdapter = new BottomBarAdapter(getSupportFragmentManager());

        pagerAdapter.addFragments(new EventFragment());
        pagerAdapter.addFragments(new VenueFragment());
        pagerAdapter.addFragments(new ProfilFragment());
        pagerAdapter.addFragments(new SettingFragment());

        viewPager.setAdapter(pagerAdapter);
    }

    public void setupBottomNavBehaviors() {
        bottomNavigation.setBehaviorTranslationEnabled(false);

        /*
        Before enabling this. Change MainActivity theme to MyTheme.TranslucentNavigation in
        AndroidManifest.

        Warning: Toolbar Clipping might occur. Solve this by wrapping it in a LinearLayout with a top
        View of 24dp (status bar size) height.
         */
        bottomNavigation.setTranslucentNavigationEnabled(false);
    }

    /**
     * Adds styling properties to {@link AHBottomNavigation}
     */
    private void setupBottomNavStyle() {
        /*
        Set Bottom Navigation colors. Accent color for active item,
        Inactive color when its view is disabled.

        Will not be visible if setColored(true) and default current item is set.
         */
        bottomNavigation.setDefaultBackgroundColor(Color.WHITE);
        bottomNavigation.setAccentColor(fetchColor(R.color.blue_300));
        bottomNavigation.setInactiveColor(fetchColor(R.color.bottomtab_item_resting));

        // Colors for selected (active) and non-selected items.

        bottomNavigation.setColoredModeColors(Color.WHITE,
                fetchColor(R.color.bottomtab_item_resting));

        //  Enables Reveal effect
        bottomNavigation.setColored(true);

        //  Displays item Title always (for selected and non-selected items)
        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);
    }

    private int fetchColor(@ColorRes int color) {
        return ContextCompat.getColor(this, color);
    }

    private void createFakeNotification() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                AHNotification notification = new AHNotification.Builder()
                        .setText("1")
                        .setBackgroundColor(Color.YELLOW)
                        .setTextColor(Color.BLACK)
                        .build();
                // Adding notification to last item.

                bottomNavigation.setNotification(notification, bottomNavigation.getItemsCount() - 1);

                notificationVisible = true;
            }
        }, 1000);
    }

    private void addBottomNavigationItems() {
        AHBottomNavigationItem item1 = new AHBottomNavigationItem(R.string.event, R.mipmap.temp, colors[0]);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem(R.string.venue, R.mipmap.temp, colors[1]);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem(R.string.profile, R.mipmap.ic_profil_nav, colors[2]);
        AHBottomNavigationItem item4 = new AHBottomNavigationItem(R.string.settings, R.mipmap.ic_setting_nav, colors[3]);

        bottomNavigation.addItem(item1);
        bottomNavigation.addItem(item2);
        bottomNavigation.addItem(item3);
        bottomNavigation.addItem(item4);
    }

    @Override
    public void onClick(View view) {

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.event_filter:
                showFilterDialog();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showFilterDialog(){
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
        View mView = getLayoutInflater().inflate(R.layout.filter_dialog, null);

        Button apply =  mView.findViewById(R.id.apply);
        Button reset =  mView.findViewById(R.id.reset);
        mBuilder.setView(mView);
        final AlertDialog dialog = mBuilder.create();


        dialog.show();
        dialog.setCancelable(false);
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        final CharSequence[] options = list.toArray(new CharSequence[list.size()]);

        final TextView location = mView.findViewById(R.id.location);

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setSingleChoiceItems(options, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                location.setText(options[which]);
            }
        });
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.show();
            }
        });

        
    }

    public void onRadioButtonClicked(View view) {

    }

    public void setAllRegion(){

        list.add("All Location");
        list.add("Asemrowo");
        list.add("Benowo");
        list.add("Bubutan");
        list.add("Bulak");
        list.add("Dukuh Pakis");
        list.add("Gayungan");
        list.add("Genteng");
        list.add("Gubeng");
        list.add("Gunung Anyar");
        list.add("Kenjeran");
        list.add("Mulyorejo");
        list.add("Rungkut");
        list.add("Sawahan");
        list.add("Sukolilo");
        list.add("Tambaksari");
        list.add("Tandes");
        list.add("Tegalsari");
        list.add("Wonocolo");
        list.add("Wonokromo");

    }
}
