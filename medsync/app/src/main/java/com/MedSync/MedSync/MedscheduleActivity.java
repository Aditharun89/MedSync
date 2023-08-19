package com.MedSync.MedSync;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.Context;
import android.content.Intent;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.media.MediaPlayer;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.os.Vibrator;
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
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.appbar.AppBarLayout;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;
import java.io.*;
import java.text.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class MedscheduleActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private HashMap<String, Object> map = new HashMap<>();
	
	private ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();
	
	private TextView textview37;
	private ScrollView vscroll1;
	private LinearLayout linear11;
	private LinearLayout linear12;
	private LinearLayout linear13;
	private LinearLayout linear14;
	private LinearLayout linear16;
	private LinearLayout linear17;
	private LinearLayout linear21;
	private TextView textview1;
	private TextView textview2;
	private EditText edittext1;
	private TextView textview3;
	private TextView textview4;
	private EditText edittext2;
	private TextView textview5;
	private TextView textview7;
	private EditText edittext4;
	private TextView textview22;
	private EditText edittext5;
	private TextView textview24;
	private EditText edittext3;
	private TextView textview36;
	private EditText edittext8;
	private LinearLayout linear19;
	private TextView textview15;
	private TextView textview26;
	private LinearLayout linear22;
	private TextView textview30;
	private TextView textview34;
	private TextView textview31;
	private TextView textview33;
	private TextView textview32;
	private DatePicker datepicker1;
	private Button button1;
	
	private MediaPlayer media;
	private TimerTask timer;
	private Vibrator vi;
	private Calendar c = Calendar.getInstance();
	private Calendar c2 = Calendar.getInstance();
	
	private OnCompleteListener when_app_closed_onCompleteListener;
	private DatabaseReference databasemed = _firebase.getReference("meddata");
	private ChildEventListener _databasemed_child_listener;
	private Intent next = new Intent();
	private TimerTask t;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.medschedule);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
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
		textview37 = findViewById(R.id.textview37);
		vscroll1 = findViewById(R.id.vscroll1);
		linear11 = findViewById(R.id.linear11);
		linear12 = findViewById(R.id.linear12);
		linear13 = findViewById(R.id.linear13);
		linear14 = findViewById(R.id.linear14);
		linear16 = findViewById(R.id.linear16);
		linear17 = findViewById(R.id.linear17);
		linear21 = findViewById(R.id.linear21);
		textview1 = findViewById(R.id.textview1);
		textview2 = findViewById(R.id.textview2);
		edittext1 = findViewById(R.id.edittext1);
		textview3 = findViewById(R.id.textview3);
		textview4 = findViewById(R.id.textview4);
		edittext2 = findViewById(R.id.edittext2);
		textview5 = findViewById(R.id.textview5);
		textview7 = findViewById(R.id.textview7);
		edittext4 = findViewById(R.id.edittext4);
		textview22 = findViewById(R.id.textview22);
		edittext5 = findViewById(R.id.edittext5);
		textview24 = findViewById(R.id.textview24);
		edittext3 = findViewById(R.id.edittext3);
		textview36 = findViewById(R.id.textview36);
		edittext8 = findViewById(R.id.edittext8);
		linear19 = findViewById(R.id.linear19);
		textview15 = findViewById(R.id.textview15);
		textview26 = findViewById(R.id.textview26);
		linear22 = findViewById(R.id.linear22);
		textview30 = findViewById(R.id.textview30);
		textview34 = findViewById(R.id.textview34);
		textview31 = findViewById(R.id.textview31);
		textview33 = findViewById(R.id.textview33);
		textview32 = findViewById(R.id.textview32);
		datepicker1 = findViewById(R.id.datepicker1);
		button1 = findViewById(R.id.button1);
		vi = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		
		linear22.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				datepicker1.setVisibility(View.VISIBLE);
			}
		});
		
		Calendar _calendar = Calendar.getInstance();
		datepicker1.init(_calendar.get(Calendar.YEAR), _calendar.get(Calendar.MONTH), _calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
			@Override
			public void onDateChanged(DatePicker _datePicker, int _year, int _month, int _day) {
				textview30.setText(String.valueOf(_day));
				textview31.setText(String.valueOf(_month));
				textview32.setText(String.valueOf(_year));
				datepicker1.setVisibility(View.GONE);
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				c = Calendar.getInstance();
				c2.set(Calendar.HOUR, (int)(Double.parseDouble(edittext4.getText().toString())));
				c2.set(Calendar.MINUTE, (int)(Double.parseDouble(edittext5.getText().toString())));
				c2.set(Calendar.SECOND, (int)(Double.parseDouble(edittext3.getText().toString())));
				timer = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								vi.vibrate((long)(2000));
								media = MediaPlayer.create(getApplicationContext(), R.raw.alarm);
								media.start();
								timer = new TimerTask() {
									@Override
									public void run() {
										runOnUiThread(new Runnable() {
											@Override
											public void run() {
												map = new HashMap<>();
												map.put("message", edittext1.getText().toString());
												databasemed.addChildEventListener(_databasemed_child_listener);
											}
										});
									}
								};
								_timer.schedule(timer, (int)(15000));
							}
						});
					}
				};
				_timer.scheduleAtFixedRate(timer, (int)((long)(c2.getTimeInMillis() - c.getTimeInMillis())), (int)(60000));
				if (!edittext1.getText().toString().equals("")) {
					map = new HashMap<>();
					map.put("message", edittext1.getText().toString());
					databasemed.push().updateChildren(map);
					map.clear();
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "type here");
				}
				SketchwareUtil.showMessage(getApplicationContext(), "alarm set successfully ");
				next.setClass(getApplicationContext(), HomeActivity.class);
				startActivity(next);
			}
		});
		
		when_app_closed_onCompleteListener = new OnCompleteListener<InstanceIdResult>() {
			@Override
			public void onComplete(Task<InstanceIdResult> task) {
				final boolean _success = task.isSuccessful();
				final String _token = task.getResult().getToken();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				/* how to use me just follow this step.

1. Add me always in mainActivity
2.Go to Your Firebase Console And open the project which you use in this project.
and go to "cloud messaging" click on Start Massaging And Send Your Notifications Easily. */
			}
		};
		
		_databasemed_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				_noti(_childValue.get("message").toString());
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
		databasemed.addChildEventListener(_databasemed_child_listener);
	}
	
	private void initializeLogic() {
		datepicker1.setVisibility(View.GONE);
	}
	
	public void _noti(final String _Content) {
		final Context context = getApplicationContext();
		
		
		NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		
		Intent intent = new Intent(this, Compliance1Activity.class); 
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP); 
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0); 
		androidx.core.app.NotificationCompat.Builder builder; 
		int notificationId = 1;
		    String channelId = "channel-01";
		    String channelName = "Channel Name";
		    int importance = NotificationManager.IMPORTANCE_HIGH;
		
		    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
			        NotificationChannel mChannel = new NotificationChannel(
			                channelId, channelName, importance);
			        notificationManager.createNotificationChannel(mChannel);
			    }
		 androidx.core.app.NotificationCompat.Builder mBuilder = new androidx.core.app.NotificationCompat.Builder(context, channelId)
		            .setSmallIcon(R.drawable.icon)
		            .setContentTitle("Time to take the medicine")
		            .setContentText(_Content)
		            .setAutoCancel(true)
		            .setOngoing(false)
		            .setContentIntent(pendingIntent);
		    TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
		    stackBuilder.addNextIntent(intent);
		    PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(
		            0,
		            PendingIntent.FLAG_UPDATE_CURRENT
		    );
		    mBuilder.setContentIntent(resultPendingIntent);
		
		    notificationManager.notify(notificationId, mBuilder.build());
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