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
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.airbnb.lottie.*;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
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
import java.util.Calendar;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class LogsupActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private HashMap<String, Object> map = new HashMap<>();
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear13;
	private LottieAnimationView lottie1;
	private LinearLayout linear14;
	private LinearLayout linear15;
	private LinearLayout linear22;
	private LinearLayout linear19;
	private LinearLayout linear20;
	private LinearLayout linear23;
	private LinearLayout linear24;
	private LinearLayout linear25;
	private LinearLayout linear26;
	private TextView log;
	private TextView sup;
	private EditText name;
	private EditText uname;
	private EditText pwd;
	private EditText pwd1;
	private Button logbtn;
	private Button supbtn;
	
	private Intent i = new Intent();
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
	private TimerTask t;
	private Calendar c = Calendar.getInstance();
	private RequestNetwork net;
	private RequestNetwork.RequestListener _net_request_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.logsup);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		MobileAds.initialize(this);
		
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		linear13 = findViewById(R.id.linear13);
		lottie1 = findViewById(R.id.lottie1);
		linear14 = findViewById(R.id.linear14);
		linear15 = findViewById(R.id.linear15);
		linear22 = findViewById(R.id.linear22);
		linear19 = findViewById(R.id.linear19);
		linear20 = findViewById(R.id.linear20);
		linear23 = findViewById(R.id.linear23);
		linear24 = findViewById(R.id.linear24);
		linear25 = findViewById(R.id.linear25);
		linear26 = findViewById(R.id.linear26);
		log = findViewById(R.id.log);
		sup = findViewById(R.id.sup);
		name = findViewById(R.id.name);
		uname = findViewById(R.id.uname);
		pwd = findViewById(R.id.pwd);
		pwd1 = findViewById(R.id.pwd1);
		logbtn = findViewById(R.id.logbtn);
		supbtn = findViewById(R.id.supbtn);
		sh = getSharedPreferences("user", Activity.MODE_PRIVATE);
		auth = FirebaseAuth.getInstance();
		net = new RequestNetwork(this);
		
		log.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				name.setVisibility(View.INVISIBLE);
				supbtn.setVisibility(View.INVISIBLE);
				logbtn.setVisibility(View.VISIBLE);
				pwd1.setVisibility(View.INVISIBLE);
				sup.setEnabled(true);
				sup.setBackgroundColor(0xFF00BCD4);
				log.setEnabled(false);
				log.setBackgroundColor(0xFFBBDEFB);
			}
		});
		
		sup.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				name.setVisibility(View.VISIBLE);
				supbtn.setVisibility(View.VISIBLE);
				logbtn.setVisibility(View.INVISIBLE);
				pwd1.setVisibility(View.VISIBLE);
				log.setEnabled(true);
				log.setBackgroundColor(0xFF2196F3);
				sup.setEnabled(false);
				sup.setBackgroundColor(0xFFB2EBF2);
			}
		});
		
		logbtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				auth.signInWithEmailAndPassword(uname.getText().toString(), pwd.getText().toString()).addOnCompleteListener(LogsupActivity.this, _auth_sign_in_listener);
				sh.edit().putString("mail", uname.getText().toString()).commit();
				sh.edit().putString("pwd", pwd.getText().toString()).commit();
			}
		});
		
		supbtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (name.getText().toString().equals("")) {
					((EditText)name).setError("Enter Name");
				}
				else {
					if (uname.getText().toString().equals("")) {
						((EditText)uname).setError("Enter Email or Number");
					}
					else {
						if (pwd.getText().toString().equals("")) {
							((EditText)pwd).setError("Enter Password");
						}
						else {
							if (pwd1.getText().toString().equals("")) {
								((EditText)pwd1).setError("Enter Confirm Password");
							}
							else {
								if (!pwd.getText().toString().equals(pwd1.getText().toString())) {
									((EditText)pwd).setError("Password never matched");
									((EditText)pwd1).setError("Password never matched");
								}
								else {
									auth.createUserWithEmailAndPassword(uname.getText().toString(), pwd.getText().toString()).addOnCompleteListener(LogsupActivity.this, _auth_create_user_listener);
									sh.edit().putString("mail", uname.getText().toString()).commit();
									sh.edit().putString("pwd", pwd.getText().toString()).commit();
								}
							}
						}
					}
				}
			}
		});
		
		_user_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
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
				if (_success) {
					SketchwareUtil.showMessage(getApplicationContext(), "email sent ");
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), _errorMessage);
				}
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
				c = Calendar.getInstance();
				if (_success) {
					map = new HashMap<>();
					map.put("name", name.getText().toString());
					map.put("uname", uname.getText().toString());
					map.put("suptime", new SimpleDateFormat("yyMMddhhmmss").format(c.getTime()));
					user.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(map);
					FirebaseAuth.getInstance().getCurrentUser().sendEmailVerification().addOnCompleteListener(auth_emailVerificationSentListener);
					map.clear();
					i.setClass(getApplicationContext(), LogsupActivity.class);
					startActivity(i);
					SketchwareUtil.showMessage(getApplicationContext(), "account create successfully ");
					finish();
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), _errorMessage);
				}
			}
		};
		
		_auth_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				c = Calendar.getInstance();
				SketchwareUtil.showMessage(getApplicationContext(), new SimpleDateFormat("yyMMddhhmmss").format(c.getTime()));
				if (_success) {
					map = new HashMap<>();
					map.put("logtime", new SimpleDateFormat("yyMMddhhmmss").format(c.getTime()));
					user.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(map);
					map.clear();
					t = new TimerTask() {
						@Override
						public void run() {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									i.setClass(getApplicationContext(), HomeActivity.class);
									startActivity(i);
									finish();
								}
							});
						}
					};
					_timer.schedule(t, (int)(2500));
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), _errorMessage);
				}
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
		SketchwareUtil.showMessage(getApplicationContext(), "CLICK ON SIGN UP ");
		if (SketchwareUtil.isConnected(getApplicationContext())) {
			linear14.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)10, 0xFF8BC34A, Color.TRANSPARENT));
			lottie1.setAnimation("lttie-profile-user-card.json");
			name.setVisibility(View.INVISIBLE);
			supbtn.setVisibility(View.INVISIBLE);
			pwd1.setVisibility(View.INVISIBLE);
			log.setEnabled(false);
			log.setBackgroundColor(0xFFBBDEFB);
			name.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)10, (int)5, 0xFF4CAF50, 0xFFFFFFFF));
			uname.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)10, (int)5, 0xFF4CAF50, 0xFFFFFFFF));
			pwd.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)10, (int)5, 0xFF4CAF50, 0xFFFFFFFF));
			pwd1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)10, (int)5, 0xFF4CAF50, 0xFFFFFFFF));
			logbtn.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)30, (int)5, 0xFF00BCD4, 0xFF2196F3));
			supbtn.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)30, (int)5, 0xFF2196F3, 0xFF03A9F4));
			uname.setText(sh.getString("mail", ""));
			pwd.setText(sh.getString("pwd", ""));
		}
		else {
			i.setClass(getApplicationContext(), NonetActivity.class);
			startActivity(i);
			finish();
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