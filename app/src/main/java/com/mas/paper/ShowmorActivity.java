package com.mas.paper;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnAdapterChangeListener;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.material.appbar.AppBarLayout;
import com.google.firebase.FirebaseApp;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class ShowmorActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private String s = "";
	private String s1 = "";
	private String s2 = "";
	private double pos = 0;
	private double num = 0;
	
	private ArrayList<HashMap<String, Object>> map = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private LinearLayout linear5;
	private LinearLayout linear6;
	private LinearLayout linear7;
	private LinearLayout linear8;
	private ViewPager viewpager1;
	private TextView textview1;
	private TextView textview2;
	private TextView textview3;
	private AdView adview1;
	
	private SharedPreferences sh;
	private Intent i = new Intent();
	private TimerTask t;
	private RequestNetwork net;
	private RequestNetwork.RequestListener _net_request_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.showmor);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		MobileAds.initialize(this);
		
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		_app_bar = findViewById(R.id._app_bar);
		_coordinator = findViewById(R.id._coordinator);
		_toolbar = findViewById(R.id._toolbar);
		setSupportActionBar(_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		linear3 = findViewById(R.id.linear3);
		linear4 = findViewById(R.id.linear4);
		linear5 = findViewById(R.id.linear5);
		linear6 = findViewById(R.id.linear6);
		linear7 = findViewById(R.id.linear7);
		linear8 = findViewById(R.id.linear8);
		viewpager1 = findViewById(R.id.viewpager1);
		textview1 = findViewById(R.id.textview1);
		textview2 = findViewById(R.id.textview2);
		textview3 = findViewById(R.id.textview3);
		adview1 = findViewById(R.id.adview1);
		sh = getSharedPreferences("sup", Activity.MODE_PRIVATE);
		net = new RequestNetwork(this);
		
		linear4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sh.edit().putString("url", sh.getString("purl", "")).commit();
				i.setClass(getApplicationContext(), WebActivity.class);
				startActivity(i);
			}
		});
		
		linear5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sh.edit().putString("url", sh.getString("eurl", "")).commit();
				i.setClass(getApplicationContext(), WebActivity.class);
				startActivity(i);
			}
		});
		
		linear6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), YoutubeActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		_net_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
	}
	
	private void initializeLogic() {
		
		{
			AdRequest adRequest = new AdRequest.Builder().build();
			adview1.loadAd(adRequest);
		}
		if (SketchwareUtil.isConnected(getApplicationContext())) {
			{
				HashMap<String, Object> _item = new HashMap<>();
				_item.put("img", "https://raw.githubusercontent.com/alekhakumarswain/suprabhat/main/Img/Logo1.png");
				map.add(_item);
			}
			
			{
				HashMap<String, Object> _item = new HashMap<>();
				_item.put("img", "https://raw.githubusercontent.com/alekhakumarswain/suprabhat/main/Img/Logo2.png");
				map.add(_item);
			}
			
			{
				HashMap<String, Object> _item = new HashMap<>();
				_item.put("img", "https://raw.githubusercontent.com/alekhakumarswain/suprabhat/main/Img/Logo3.png");
				map.add(_item);
			}
			
			viewpager1.setAdapter(new Viewpager1Adapter(map));
			((PagerAdapter)viewpager1.getAdapter()).notifyDataSetChanged();
			pos = 0;
			num = 0;
			t = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							viewpager1.setCurrentItem((int)num);
							num++;
							if (num == map.size()) {
								num = 0;
							}
						}
					});
				}
			};
			_timer.scheduleAtFixedRate(t, (int)(0), (int)(2000));
			s = sh.getString("sup1", "");
			if (s.length() == 0) {
				linear4.setVisibility(View.GONE);
			}
			s1 = sh.getString("sup2", "");
			if (s1.length() == 0) {
				linear5.setVisibility(View.GONE);
			}
			s2 = sh.getString("sup3", "");
			SketchwareUtil.showMessage(getApplicationContext(), s2);
			if (s2.length() == 0) {
				linear6.setVisibility(View.GONE);
			}
			linear2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)5, 0xFFFF5722, 0xFFFFC107));
			linear4.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)50, (int)10, 0xFFE91E63, 0xFFCDDC39));
			linear5.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)50, (int)10, 0xFFE91E63, 0xFFCDDC39));
			linear6.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)50, (int)10, 0xFFE91E63, 0xFFCDDC39));
			textview1.setText(s);
			textview2.setText(s1);
			textview3.setText(s2);
		}
		else {
			i.setClass(getApplicationContext(), NonetActivity.class);
			startActivity(i);
			finish();
		}
	}
	
	@Override
	public void onBackPressed() {
		i.setClass(getApplicationContext(), HomeActivity.class);
		startActivity(i);
		finish();
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		if (adview1 != null) {
			adview1.destroy();
		}
	}
	
	@Override
	public void onPause() {
		super.onPause();
		if (adview1 != null) {
			adview1.pause();
		}
	}
	
	@Override
	public void onResume() {
		super.onResume();
		if (adview1 != null) {
			adview1.resume();
		}
	}
	public class Viewpager1Adapter extends PagerAdapter {
		
		Context _context;
		ArrayList<HashMap<String, Object>> _data;
		
		public Viewpager1Adapter(Context _ctx, ArrayList<HashMap<String, Object>> _arr) {
			_context = _ctx;
			_data = _arr;
		}
		
		public Viewpager1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_context = getApplicationContext();
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public boolean isViewFromObject(View _view, Object _object) {
			return _view == _object;
		}
		
		@Override
		public void destroyItem(ViewGroup _container, int _position, Object _object) {
			_container.removeView((View) _object);
		}
		
		@Override
		public int getItemPosition(Object _object) {
			return super.getItemPosition(_object);
		}
		
		@Override
		public CharSequence getPageTitle(int pos) {
			// Use the Activity Event (onTabLayoutNewTabAdded) in order to use this method
			return "page " + String.valueOf(pos);
		}
		
		@Override
		public Object instantiateItem(ViewGroup _container,  final int _position) {
			View _view = LayoutInflater.from(_context).inflate(R.layout.img, _container, false);
			
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final androidx.cardview.widget.CardView cardview1 = _view.findViewById(R.id.cardview1);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			
			Glide.with(getApplicationContext()).load(Uri.parse(_data.get((int)_position).get("img").toString())).into(imageview1);
			
			_container.addView(_view);
			return _view;
		}
	}
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}