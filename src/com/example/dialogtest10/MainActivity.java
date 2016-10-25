package com.example.dialogtest10;

import android.os.Bundle;
import android.animation.AnimatorSet.Builder;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    Button simpleDialog,status; 
    private TextView statusText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		simpleDialog=(Button) this.findViewById(R.id.simpleDialog);
		status=(Button) this.findViewById(R.id.status);
		status.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				final String[] items=new String[]{"在线","隐身","离开","忙碌","离线","其他"};
				android.app.AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
				builder.setTitle("请选择你的状态");
				builder.setIcon(R.drawable.ic_launcher);
				builder.setCancelable(false);
				builder.setSingleChoiceItems(items, 1, new DialogInterface.OnClickListener() {
					
					

					@Override
					public void onClick(DialogInterface dialog, int which) {
						statusText.setText("你当前状态是:"+items[which]);
					}
				});
				builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
					}
				});
				builder.create().show();
			}
		});
		 
		final android.app.AlertDialog.Builder builder=new AlertDialog.Builder(this);
		simpleDialog.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				builder.setMessage("Are you sure you want to exit?");
				builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(MainActivity.this, "单击了确定", 1000).show();
						
					}
				});
			builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(MainActivity.this, "单击了取消", 1000).show();
					
				}
			});	
			builder.show();
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
