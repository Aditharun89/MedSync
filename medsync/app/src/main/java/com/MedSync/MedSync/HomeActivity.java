package com.MedSync.MedSync;

import android.animation.*;
import android.app.*;
import android.app.AlertDialog;
import android.content.*;
import android.content.DialogInterface;
import android.content.Intent;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.firebase.FirebaseApp;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class HomeActivity extends AppCompatActivity {
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private Button button1;
	private Button compliance_button;
	private Button medfinder_button;
	private Button sfx_button;
	private Button button5;
	private Button logout_button;
	private ImageView imageview1;
	private TextView textview1;
	
	private Intent next = new Intent();
	private AlertDialog.Builder dialog;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.home);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		button1 = findViewById(R.id.button1);
		compliance_button = findViewById(R.id.compliance_button);
		medfinder_button = findViewById(R.id.medfinder_button);
		sfx_button = findViewById(R.id.sfx_button);
		button5 = findViewById(R.id.button5);
		logout_button = findViewById(R.id.logout_button);
		imageview1 = findViewById(R.id.imageview1);
		textview1 = findViewById(R.id.textview1);
		dialog = new AlertDialog.Builder(this);
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				next.setClass(getApplicationContext(), MedscheduleActivity.class);
				startActivity(next);
			}
		});
		
		compliance_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				next.setClass(getApplicationContext(), Medschedule0Activity.class);
				startActivity(next);
			}
		});
		
		medfinder_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				next.setClass(getApplicationContext(), MedFinderActivity.class);
				startActivity(next);
			}
		});
		
		sfx_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				next.setClass(getApplicationContext(), SideEffectsActivity.class);
				startActivity(next);
			}
		});
		
		button5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				next.setClass(getApplicationContext(), MedhistorynotesActivity.class);
				startActivity(next);
			}
		});
		
		logout_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				next.setClass(getApplicationContext(), InfoActivity.class);
				startActivity(next);
			}
		});
	}
	
	private void initializeLogic() {
	}
	
	@Override
	public void onBackPressed() {
		dialog.setTitle("Title");
		dialog.setMessage("Message");
		dialog.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				finishAffinity();
			}
		});
		dialog.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				
			}
		});
		dialog.create().show();
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