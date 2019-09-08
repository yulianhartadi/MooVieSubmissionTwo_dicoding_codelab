package com.rdstudio.mooviesubmissiontwo;

import android.app.AlertDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private static final String[] LANGUAGE = new String[]{
            "English", "Indonesia"
    };
    private View parent_view;

    private ViewPager viewPager;
    private SectionsPagerAdapter viewPagerAdapter;
    private TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        parent_view = findViewById(android.R.id.content);

        initToolbar();
        initContent();
    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.main_toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_logo);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(null);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    // Toolbar Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        //Search
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);

        if (searchManager != null) {
            SearchView searchView = (SearchView) (menu.findItem(R.id.search)).getActionView();
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
            searchView.setQueryHint(getResources().getString(R.string.search_hint));
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    Toast.makeText(MainActivity.this, query, Toast.LENGTH_SHORT).show();
                    return true;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    return false;
                }
            });
        }
        return true;
    }

    // Menu more action
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.choose_language) {
            // Choose Language menu
            showOptionLanguage();
        }
        return true;
    }

    // Dialog Language Option
    private String language_selected;

    private void showOptionLanguage() {
        language_selected = LANGUAGE[0];
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getText(R.string.choose_language));
        builder.setSingleChoiceItems(LANGUAGE, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                language_selected = LANGUAGE[i];
            }
        });

        builder.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Snackbar.make(parent_view, "selected : " + language_selected, Snackbar.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton(R.string.CANCEL, null);
        builder.show();
    }

    // Content
    private void initContent() {
        // Tabs
        viewPager = findViewById(R.id.main_view_pager);
        tabLayout =findViewById(R.id.main_tab_layout);
        setupViewPager(viewPager);

        tabLayout.setupWithViewPager(viewPager);

        Objects.requireNonNull(tabLayout.getTabAt(0)).setIcon(R.drawable.ic_local_movies);
        Objects.requireNonNull(tabLayout.getTabAt(1)).setIcon(R.drawable.ic_live_tv);

        // Set icon color pre-selected
        Objects.requireNonNull(tabLayout.getTabAt(0)).getIcon().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_IN);
        Objects.requireNonNull(tabLayout.getTabAt(1)).getIcon().setColorFilter(getResources().getColor(R.color.cyan_800), PorterDuff.Mode.SRC_IN);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //getSupportActionBar().setTitle(viewPagerAdapter.getTitle(tab.getPosition()));
                tab.getIcon().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(getResources().getColor(R.color.cyan_800), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void setupViewPager(ViewPager viewPager) {
        viewPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(MoviesFragment.newInstance(), "Movies");       // index 0
        viewPagerAdapter.addFragment(TVShowsFragment.newInstance(), "TV Show");     // index 1
        viewPager.setAdapter(viewPagerAdapter);

    }

    private class SectionsPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public SectionsPagerAdapter(@NonNull FragmentManager manager) {
            super(Objects.requireNonNull(manager));
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title){
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return null;
        }


    }
}
