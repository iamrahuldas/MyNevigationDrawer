package com.navigationdrawerproject;

import com.fragment.FirstFragment;
import com.fragment.FourthFragment;
import com.fragment.SecondFragment;
import com.fragment.ThirdFragment;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends FragmentActivity {

	private DrawerLayout drawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;
	private String[] navMenuTitles = { "Page Item 1", "Page Item 2",
			"Page Item 3", "Page Item 4" };
	private NavListItemAdapter navListItemAdapter;
	private CharSequence mDrawerTitle;
	private CharSequence mTitle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 mTitle = mDrawerTitle = getTitle();
		initialize();
		
		
		drawerLayout.setDrawerListener(mDrawerToggle);
		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
		mDrawerList.setBackgroundColor(Color.parseColor("#FFFFFF"));
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);
		
		loadFirstFrg(0);
		
	}

	@Override
	public boolean onMenuOpened(int featureId, Menu menu) {
		// TODO Auto-generated method stub
		return super.onMenuOpened(featureId, menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		// toggle nav drawer on selecting action bar app icon/title
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle action bar actions click
        switch (item.getItemId()) {
        case R.id.action_settings:
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
	}
	
	private void initialize() {
		
		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);
		navListItemAdapter = new NavListItemAdapter(navMenuTitles,
				MainActivity.this);
		
		mDrawerList.setAdapter(navListItemAdapter);
		
		mDrawerToggle = new ActionBarDrawerToggle(MainActivity.this,
				drawerLayout, R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close) {

			/** Called when a drawer has settled in a completely closed state. */
			public void onDrawerClosed(View view) {
				 invalidateOptionsMenu();
				
			}

			/** Called when a drawer has settled in a completely open state. */
			public void onDrawerOpened(View drawerView) {
				 invalidateOptionsMenu();
				
			}
		};
	}

	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			selectItem(position);
		}
	}

	private void selectItem(int position) {
		switch (position) {
		case 0:
			loadFirstFrg(position);
			break;

		case 1:
			loadSecondFrg(position);
			break;

		case 2:
			loadThirdFrg(position);
			break;

		case 3:
			loadFourthFrg(position);
			break;

		default:
			break;
		}
	}

	private void loadFirstFrg(int position) {
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		Fragment firstFragment = new FirstFragment();
		transaction.replace(R.id.content_frame, firstFragment);
		transaction.commit();

		mDrawerList.setItemChecked(position, true);
		setTitle(navMenuTitles[position]);
		drawerLayout.closeDrawer(mDrawerList);
	}

	private void loadSecondFrg(int position) {
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		Fragment fragment = new SecondFragment();
		transaction.replace(R.id.content_frame, fragment);
		transaction.commit();

		mDrawerList.setItemChecked(position, true);
		setTitle(navMenuTitles[position]);
		drawerLayout.closeDrawer(mDrawerList);
	}

	private void loadThirdFrg(int position) {
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		Fragment fragment = new ThirdFragment();
		transaction.replace(R.id.content_frame, fragment);
		transaction.commit();

		mDrawerList.setItemChecked(position, true);
		setTitle(navMenuTitles[position]);
		drawerLayout.closeDrawer(mDrawerList);
	}

	private void loadFourthFrg(int position) {
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		Fragment fragment = new FourthFragment();
		transaction.replace(R.id.content_frame, fragment);
		transaction.commit();

		mDrawerList.setItemChecked(position, true);
		setTitle(navMenuTitles[position]);
		drawerLayout.closeDrawer(mDrawerList);
	}

	@Override
	public void setTitle(CharSequence title) {
		// TODO Auto-generated method stub
		getActionBar().setTitle(title);
	}
	
	@Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }
}
