package com.mas.paper;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
import android.content.DialogInterface;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.appbar.AppBarLayout;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import java.io.*;
import java.text.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class HomeActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private double n = 0;
	private HashMap<String, Object> map = new HashMap<>();
	
	private ArrayList<HashMap<String, Object>> m = new ArrayList<>();
	private ArrayList<String> ytb = new ArrayList<>();
	
	private LinearLayout linear2;
	private LinearLayout linearhead;
	private LinearLayout linear7;
	private LinearLayout linear8;
	private LinearLayout linear9;
	private LinearLayout linear33;
	private LinearLayout linear21;
	private LinearLayout linear22;
	private ImageView imageview2;
	private LinearLayout linear43;
	private LinearLayout linear44;
	private LinearLayout linear45;
	private TextView textview3;
	private TextView textview4;
	private TextView textview5;
	private ScrollView vscroll2;
	private LinearLayout linearbgimg;
	private LinearLayout linear14;
	private LinearLayout linear24;
	private LinearLayout linear27;
	private LinearLayout linear30;
	private LinearLayout linear34;
	private LinearLayout linear37;
	private LinearLayout linear49;
	private LinearLayout linear50;
	private LinearLayout linear53;
	private LinearLayout st1;
	private LinearLayout st2;
	private ImageView imageview1;
	private ImageView imageview3;
	private LinearLayout st3;
	private LinearLayout st4;
	private ImageView imageview4;
	private ImageView imageview5;
	private LinearLayout st5;
	private LinearLayout st6;
	private ImageView imageview6;
	private ImageView imageview7;
	private LinearLayout st7;
	private LinearLayout st8;
	private ImageView imageview8;
	private ImageView imageview9;
	private LinearLayout st9;
	private LinearLayout st10;
	private ImageView imageview10;
	private ImageView imageview11;
	private LinearLayout st11;
	private LinearLayout st12;
	private ImageView imageview12;
	private ImageView imageview13;
	private LinearLayout linear31;
	private LinearLayout linear32;
	private ImageView imageview18;
	private ImageView imageview19;
	private LinearLayout linear51;
	private LinearLayout linear52;
	private ImageView imageview21;
	private ImageView imageview22;
	private LinearLayout linear54;
	private LinearLayout linear55;
	private ImageView imageview23;
	private ImageView imageview24;
	
	private Intent i = new Intent();
	private Calendar c = Calendar.getInstance();
	private TimerTask t;
	private RequestNetwork net;
	private RequestNetwork.RequestListener _net_request_listener;
	private SharedPreferences sh;
	private FirebaseAuth auth;
	private OnCompleteListener<AuthResult> _auth_create_user_listener;
	private OnCompleteListener<AuthResult> _auth_sign_in_listener;
	private OnCompleteListener<Void> _auth_reset_password_listener;
	private OnCompleteListener<Void> auth_updateEmailListener;
	private OnCompleteListener<Void> auth_updatePasswordListener;
	private OnCompleteListener<Void> auth_emailVerificationSentListener;
	private OnCompleteListener<Void> auth_deleteUserListener;
	private OnCompleteListener<Void> auth_updateProfileListener;
	private OnCompleteListener<AuthResult> auth_phoneAuthListener;
	private OnCompleteListener<AuthResult> auth_googleSignInListener;
	
	private DatabaseReference user = _firebase.getReference("data");
	private ChildEventListener _user_child_listener;
	private AlertDialog.Builder d;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.home);
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
		linear2 = findViewById(R.id.linear2);
		linearhead = findViewById(R.id.linearhead);
		linear7 = findViewById(R.id.linear7);
		linear8 = findViewById(R.id.linear8);
		linear9 = findViewById(R.id.linear9);
		linear33 = findViewById(R.id.linear33);
		linear21 = findViewById(R.id.linear21);
		linear22 = findViewById(R.id.linear22);
		imageview2 = findViewById(R.id.imageview2);
		linear43 = findViewById(R.id.linear43);
		linear44 = findViewById(R.id.linear44);
		linear45 = findViewById(R.id.linear45);
		textview3 = findViewById(R.id.textview3);
		textview4 = findViewById(R.id.textview4);
		textview5 = findViewById(R.id.textview5);
		vscroll2 = findViewById(R.id.vscroll2);
		linearbgimg = findViewById(R.id.linearbgimg);
		linear14 = findViewById(R.id.linear14);
		linear24 = findViewById(R.id.linear24);
		linear27 = findViewById(R.id.linear27);
		linear30 = findViewById(R.id.linear30);
		linear34 = findViewById(R.id.linear34);
		linear37 = findViewById(R.id.linear37);
		linear49 = findViewById(R.id.linear49);
		linear50 = findViewById(R.id.linear50);
		linear53 = findViewById(R.id.linear53);
		st1 = findViewById(R.id.st1);
		st2 = findViewById(R.id.st2);
		imageview1 = findViewById(R.id.imageview1);
		imageview3 = findViewById(R.id.imageview3);
		st3 = findViewById(R.id.st3);
		st4 = findViewById(R.id.st4);
		imageview4 = findViewById(R.id.imageview4);
		imageview5 = findViewById(R.id.imageview5);
		st5 = findViewById(R.id.st5);
		st6 = findViewById(R.id.st6);
		imageview6 = findViewById(R.id.imageview6);
		imageview7 = findViewById(R.id.imageview7);
		st7 = findViewById(R.id.st7);
		st8 = findViewById(R.id.st8);
		imageview8 = findViewById(R.id.imageview8);
		imageview9 = findViewById(R.id.imageview9);
		st9 = findViewById(R.id.st9);
		st10 = findViewById(R.id.st10);
		imageview10 = findViewById(R.id.imageview10);
		imageview11 = findViewById(R.id.imageview11);
		st11 = findViewById(R.id.st11);
		st12 = findViewById(R.id.st12);
		imageview12 = findViewById(R.id.imageview12);
		imageview13 = findViewById(R.id.imageview13);
		linear31 = findViewById(R.id.linear31);
		linear32 = findViewById(R.id.linear32);
		imageview18 = findViewById(R.id.imageview18);
		imageview19 = findViewById(R.id.imageview19);
		linear51 = findViewById(R.id.linear51);
		linear52 = findViewById(R.id.linear52);
		imageview21 = findViewById(R.id.imageview21);
		imageview22 = findViewById(R.id.imageview22);
		linear54 = findViewById(R.id.linear54);
		linear55 = findViewById(R.id.linear55);
		imageview23 = findViewById(R.id.imageview23);
		imageview24 = findViewById(R.id.imageview24);
		net = new RequestNetwork(this);
		sh = getSharedPreferences("sup", Activity.MODE_PRIVATE);
		auth = FirebaseAuth.getInstance();
		d = new AlertDialog.Builder(this);
		
		st1.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				
				return true;
			}
		});
		
		st1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sh.edit().putString("sup1", "SAMBAD NEWS PAPER").commit();
				sh.edit().putString("sup2", "E-SAMBAD ARTICLE ").commit();
				sh.edit().putString("sup3", "KANAK LIVE NEWS").commit();
				sh.edit().putString("purl", "https://sambadepaper.com/indexnext.php").commit();
				sh.edit().putString("eurl", "https://sambad.in/").commit();
				sh.edit().putString("yurl", "https://youtube.com/@KanakNewsOdisha").commit();
				i.setClass(getApplicationContext(), ShowmorActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		st2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sh.edit().putString("sup1", "PRAMEYA NEWS PAPER").commit();
				sh.edit().putString("sup2", "E-PRAMEYA NEWS7 ARTICLE ").commit();
				sh.edit().putString("sup3", "PRAMEYA NEWS7 LIVE NEWS").commit();
				sh.edit().putString("purl", "https://prameyaepaper.com/").commit();
				sh.edit().putString("eurl", "https://www.prameyanews7.com/").commit();
				sh.edit().putString("yurl", "https://youtube.com/@PrameyaNews7Odia").commit();
				i.setClass(getApplicationContext(), ShowmorActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		st3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sh.edit().putString("sup1", "NITIDIN NEWS PAPER ").commit();
				sh.edit().putString("sup2", "E-NITIDIN ARTICLE").commit();
				sh.edit().putString("sup3", "").commit();
				sh.edit().putString("purl", "https://nitidinepaper.com/index.php").commit();
				sh.edit().putString("eurl", "https://www.nitidin.com/").commit();
				sh.edit().putString("yurl", "").commit();
				i.setClass(getApplicationContext(), ShowmorActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		st4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sh.edit().putString("sup1", "DHARITRI NEWS PAPER").commit();
				sh.edit().putString("sup2", "E-DHARITRI ARTICLE ").commit();
				sh.edit().putString("sup3", "").commit();
				sh.edit().putString("purl", "http://dharitriepaper.in/").commit();
				sh.edit().putString("eurl", "https://www.dharitri.com/amp/").commit();
				sh.edit().putString("yurl", "").commit();
				i.setClass(getApplicationContext(), ShowmorActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		st5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sh.edit().putString("sup1", "DINALIPI  NEWS PAPER ").commit();
				sh.edit().putString("sup2", "E-DINALIPI ARTICLE ").commit();
				sh.edit().putString("sup3", "").commit();
				sh.edit().putString("purl", "https://dinalipiepaper.com/index.php/").commit();
				sh.edit().putString("eurl", "https://www.dinalipi.com/").commit();
				sh.edit().putString("yurl", "").commit();
				i.setClass(getApplicationContext(), ShowmorActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		st6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sh.edit().putString("sup1", "BHASKAR NEWS PAPER").commit();
				sh.edit().putString("sup2", "E-SAMBAD ARTICLE ").commit();
				sh.edit().putString("sup3", "").commit();
				sh.edit().putString("purl", "https://odishabhaskar.com/epaper/").commit();
				sh.edit().putString("eurl", "https://odishabhaskar.com/").commit();
				sh.edit().putString("yurl", "").commit();
				i.setClass(getApplicationContext(), ShowmorActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		st7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sh.edit().putString("sup1", "SAMAJ NEWS PAPER").commit();
				sh.edit().putString("sup2", "E-SAMBAD ARTICLE ").commit();
				sh.edit().putString("sup3", "").commit();
				sh.edit().putString("purl", "https://m.samajaepaper.in/").commit();
				sh.edit().putString("eurl", "https://samajalive.in/").commit();
				sh.edit().putString("yurl", "").commit();
				i.setClass(getApplicationContext(), ShowmorActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		st8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sh.edit().putString("sup1", "PRAGATIVADI NEWS PAPER").commit();
				sh.edit().putString("sup2", "PRAGATIVADI ARTICLE ").commit();
				sh.edit().putString("sup3", "").commit();
				sh.edit().putString("purl", "https://pragativadi.com/epaper/").commit();
				sh.edit().putString("eurl", "https://pragativadi.com/").commit();
				sh.edit().putString("yurl", "").commit();
				i.setClass(getApplicationContext(), ShowmorActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		st9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sh.edit().putString("sup1", "SAMAYA NEWS PAPER").commit();
				sh.edit().putString("sup2", "").commit();
				sh.edit().putString("sup3", "").commit();
				sh.edit().putString("purl", "https://www.samayaepaper.com/").commit();
				sh.edit().putString("eurl", "").commit();
				sh.edit().putString("yurl", "").commit();
				i.setClass(getApplicationContext(), ShowmorActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		st10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sh.edit().putString("sup1", "ORISSA POST NEWS PAPER").commit();
				sh.edit().putString("sup2", "ORISSA POST ARTICLE ").commit();
				sh.edit().putString("sup3", "").commit();
				sh.edit().putString("purl", "http://odishapostepaper.com/").commit();
				sh.edit().putString("eurl", "https://www.orissapost.com/").commit();
				sh.edit().putString("yurl", "").commit();
				i.setClass(getApplicationContext(), ShowmorActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		st11.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sh.edit().putString("sup1", "NIJUKTI KHABAR").commit();
				sh.edit().putString("sup2", "").commit();
				sh.edit().putString("sup3", "").commit();
				sh.edit().putString("purl", "https://e2india.com/nijuktikhabar/").commit();
				sh.edit().putString("eurl", "").commit();
				sh.edit().putString("yurl", "").commit();
				i.setClass(getApplicationContext(), ShowmorActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		st12.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sh.edit().putString("sup1", "ଓଡିଆ ପଞ୍ଜିକା").commit();
				sh.edit().putString("sup2", "").commit();
				sh.edit().putString("sup3", "").commit();
				sh.edit().putString("purl", "https://www.drikpanchang.com/oriya/oriya-panji.html").commit();
				sh.edit().putString("eurl", "").commit();
				sh.edit().putString("yurl", "").commit();
				i.setClass(getApplicationContext(), ShowmorActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		linear31.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sh.edit().putString("sup1", "WEATHER REPORT").commit();
				sh.edit().putString("sup2", "").commit();
				sh.edit().putString("sup3", "").commit();
				sh.edit().putString("purl", "https://www.windy.com/").commit();
				sh.edit().putString("eurl", "").commit();
				sh.edit().putString("yurl", "").commit();
				i.setClass(getApplicationContext(), ShowmorActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		linear32.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sh.edit().putString("sup1", "NAXTRA NEWS PAPER").commit();
				sh.edit().putString("sup2", "NAXATRA ARTICLE ").commit();
				sh.edit().putString("sup3", "NAXATRA LIVE NEWS").commit();
				sh.edit().putString("purl", "https://nakshatrajyoti.com/").commit();
				sh.edit().putString("eurl", "https://naxatranews.com/").commit();
				sh.edit().putString("yurl", "https://youtube.com/@NaxatraNews").commit();
				i.setClass(getApplicationContext(), ShowmorActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		imageview18.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		linear51.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sh.edit().putString("sup1", "").commit();
				sh.edit().putString("sup2", "ZEE NEWS WEB").commit();
				sh.edit().putString("sup3", "KANAK LIVE NEWS").commit();
				sh.edit().putString("purl", "").commit();
				sh.edit().putString("eurl", "https://zeenews.india.com/").commit();
				sh.edit().putString("yurl", "https://youtube.com/@zeenews").commit();
				i.setClass(getApplicationContext(), ShowmorActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		linear52.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sh.edit().putString("sup1", "").commit();
				sh.edit().putString("sup2", "AAJTAK ARTICLE ").commit();
				sh.edit().putString("sup3", "AAJTAK LIVE NEWS").commit();
				sh.edit().putString("purl", "").commit();
				sh.edit().putString("eurl", "https://www.aajtak.in/").commit();
				sh.edit().putString("yurl", "https://youtube.com/@aajtak").commit();
				i.setClass(getApplicationContext(), ShowmorActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		linear54.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sh.edit().putString("sup1", "SUDHARMA SANSKRIT NEWS PAPER").commit();
				sh.edit().putString("sup2", "").commit();
				sh.edit().putString("sup3", "").commit();
				sh.edit().putString("purl", "https://sudharmasanskritdaily.in/").commit();
				sh.edit().putString("eurl", "").commit();
				sh.edit().putString("yurl", "").commit();
				i.setClass(getApplicationContext(), ShowmorActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		linear55.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sh.edit().putString("sup1", "SAKAL NEWS PAPER").commit();
				sh.edit().putString("sup2", "").commit();
				sh.edit().putString("sup3", "").commit();
				sh.edit().putString("purl", "https://www.sakalaepaper.com/").commit();
				sh.edit().putString("eurl", "").commit();
				sh.edit().putString("yurl", "").commit();
				i.setClass(getApplicationContext(), ShowmorActivity.class);
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
				if (SketchwareUtil.isConnected(getApplicationContext())) {
					
				}
				else {
					i.setClass(getApplicationContext(), NonetActivity.class);
					startActivity(i);
				}
				i.setClass(getApplicationContext(), NonetActivity.class);
				startActivity(i);
				finish();
			}
		};
		
		_user_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
					if (_childValue.containsKey("name")) {
						textview5.setText(_childValue.get("name").toString());
					}
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		user.addChildEventListener(_user_child_listener);
		
		auth_updateEmailListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_updatePasswordListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_emailVerificationSentListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_deleteUserListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_phoneAuthListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		auth_updateProfileListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_googleSignInListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_auth_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_auth_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_auth_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				
			}
		};
	}
	
	private void initializeLogic() {
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
			Window w =HomeActivity.this.getWindow();
			w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS); w.setStatusBarColor(0xFFFFB74D);
		}
		if (SketchwareUtil.isConnected(getApplicationContext())) {
			sh.edit().remove("sup1").commit();
			sh.edit().remove("sup2").commit();
			sh.edit().remove("sup3").commit();
			sh.edit().remove("purl").commit();
			sh.edit().remove("eurl").commit();
			sh.edit().remove("yurl").commit();
			t = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							st1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)80, (int)5, 0xFFFFA726, 0xFFFBC02D));
							st2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)80, (int)5, 0xFFFFA726, 0xFFFBC02D));
							st3.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)80, (int)5, 0xFFFFA726, 0xFFFBC02D));
							st4.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)80, (int)5, 0xFFFFA726, 0xFFFBC02D));
							st5.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)80, (int)5, 0xFFFFA726, 0xFFFBC02D));
							st6.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)80, (int)5, 0xFFFFA726, 0xFFFBC02D));
							st7.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)80, (int)5, 0xFFFFA726, 0xFFFBC02D));
							st8.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)80, (int)5, 0xFFFFA726, 0xFFFBC02D));
							st9.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)80, (int)5, 0xFFFFA726, 0xFFFBC02D));
							st10.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)80, (int)5, 0xFFFFA726, 0xFFFBC02D));
							st11.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)80, (int)5, 0xFFFFA726, 0xFFFBC02D));
							st12.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)80, (int)5, 0xFFFFA726, 0xFFFBC02D));
							linear31.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)80, (int)5, 0xFFFFA726, 0xFFFBC02D));
							linear32.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)80, (int)5, 0xFFFFA726, 0xFFFBC02D));
							linear51.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)80, (int)5, 0xFFFFA726, 0xFFFBC02D));
							linear52.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)80, (int)5, 0xFFFFA726, 0xFFFBC02D));
							linear54.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)80, (int)5, 0xFFFFA726, 0xFFFBC02D));
							linear55.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)80, (int)5, 0xFFFFA726, 0xFFFBC02D));
							if ((FirebaseAuth.getInstance().getCurrentUser() != null)) {
								t = new TimerTask() {
									@Override
									public void run() {
										runOnUiThread(new Runnable() {
											@Override
											public void run() {
												textview4.setText(new SimpleDateFormat("hh:mm a").format(c.getTime()).toUpperCase());
											}
										});
									}
								};
								_timer.scheduleAtFixedRate(t, (int)(1000), (int)(1000));
								n = Double.parseDouble(new SimpleDateFormat("HH").format(c.getTime()));
								if ((3 < n) && (18 > n)) {
									if (12 == n) {
										textview3.setText("👋Good Noon🙏");
									}
									else {
										if (12 < n) {
											textview3.setText("👋Good Afternoon🙏");
										}
										else {
											textview3.setText("👋Good Morning🙏");
										}
									}
								}
								else {
									textview3.setTextColor(0xFFFFFFFF);
									textview4.setTextColor(0xFFFFFFFF);
									textview5.setTextColor(0xFFFFFFFF);
									linearbgimg.setBackgroundResource(R.drawable.blueacegitalackground_23148821698);
									linearhead.setBackgroundResource(R.drawable.blueacegitalackground_23148821698);
									if (21 < n) {
										textview3.setText("👋Good Night🙏");
									}
									else {
										if (n < 4) {
											textview3.setText("👋Good Night🙏");
										}
										else {
											textview3.setText("👋Good Evening🙏");
										}
									}
								}
							}
							else {
								i.setClass(getApplicationContext(), LogsupActivity.class);
								startActivity(i);
								finish();
							}
						}
					});
				}
			};
			_timer.scheduleAtFixedRate(t, (int)(10), (int)(10000));
		}
		else {
			i.setClass(getApplicationContext(), NonetActivity.class);
			startActivity(i);
			finish();
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, 0, 0, "About");
		menu.add(0, 1, 0, "UPDATE");
		menu.add(0, 2, 0, "Logout");
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		final int _id = item.getItemId();
		final String _title = (String) item.getTitle();
		if (_id == 0) {
			d.setTitle(_title);
			d.setIcon(R.drawable.t20230228_121933);
			d.setMessage("Made by MASsive World");
			d.setPositiveButton("OK", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					SketchwareUtil.showMessage(getApplicationContext(), "Thanks");
				}
			});
			d.create().show();
		}
		if (_id == 1) {
			i.setClass(getApplicationContext(), UpdateActivity.class);
			startActivity(i);
			finish();
		}
		if (_id == 2) {
			i.setClass(getApplicationContext(), LogsupActivity.class);
			startActivity(i);
			finish();
		}
		return super.onOptionsItemSelected(item);
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