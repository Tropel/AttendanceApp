package ch.chost.attendanceapp.activities;

import android.net.Uri;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

import ch.chost.attendanceapp.R;
import ch.chost.attendanceapp.adapters.NavDrawerAdapter;
import ch.chost.attendanceapp.models.DrawerItem;

import static ch.chost.attendanceapp.R.id.DrawerLayout;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private DrawerLayout Drawer;
    private RecyclerView.Adapter mAdapter;
    private ActionBarDrawerToggle mDrawerToggle;
    private List<DrawerItem> navigationItemsList;


    public String HEADER_NAME = "Marcel Toeltl";
    public String HEADER_EMAIL = "nukleus1291@gmail.com";
    public int HEADER_IMAGE = R.drawable.marcel;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        navigationItemsList = new ArrayList<DrawerItem>();
        addItemsToNavigationList();

        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        mRecyclerView.setHasFixedSize(true);

        mAdapter = new NavDrawerAdapter(navigationItemsList, this, HEADER_NAME, HEADER_EMAIL, HEADER_IMAGE);
        mRecyclerView.setAdapter(mAdapter);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        Drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, Drawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            @Override
            public void onDrawerOpened(View Drawer) {
                super.onDrawerOpened(Drawer);
            }
//            public void onDrawerOpened(View drawerView) {
//                super.onDrawerOpened(drawerView);
//            }

            @Override
            public void onDrawerClosed(View Drawer) {
                super.onDrawerClosed(Drawer);
            }
//            public void onDrawerClosed(View drawerView) {
//                super.onDrawerClosed(drawerView);
//            }
        };
//        Drawer.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void addItemsToNavigationList() {
        navigationItemsList.add(new DrawerItem(getString(R.string.attendants_list), R.drawable.ic_action_users));
        navigationItemsList.add(new DrawerItem(getString(R.string.events_list), R.drawable.ic_action_document));
        navigationItemsList.add(new DrawerItem(getString(R.string.add_attendant), R.drawable.ic_action_edit));
        navigationItemsList.add(new DrawerItem(getString(R.string.add_event), R.drawable.ic_action_balloon));
        navigationItemsList.add(new DrawerItem(getString(R.string.settings), R.drawable.ic_action_settings));
    }


}
