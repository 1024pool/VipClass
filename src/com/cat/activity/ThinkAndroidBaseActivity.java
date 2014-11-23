package com.cat.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

import com.ta.TAActivity;
import com.ta.util.netstate.TANetWorkUtil.netType;

public class ThinkAndroidBaseActivity extends TAActivity
{
	@Override
	protected void onPreOnCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onPreOnCreate(savedInstanceState);
	}

	@Override
	public void onConnect(netType type)
	{
		// TODO Auto-generated method stub
		super.onConnect(type);
		Toast.makeText(this, "网络连接开启", Toast.LENGTH_LONG).show();
	}

	@Override
	public void onDisConnect()
	{
		// TODO Auto-generated method stub
		super.onDisConnect();
		Toast.makeText(this, "网络连接关闭", Toast.LENGTH_LONG).show();
	}
	
	private long exitTime = 0;

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){   
	        if((System.currentTimeMillis()-exitTime) > 2000){  
	            //Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();                                
	            //exitTime = System.currentTimeMillis();   
	        } else {
	            finish();
	            System.exit(0);
	        }
	        return true;   
	    }
	    return super.onKeyDown(keyCode, event);
	}
}
