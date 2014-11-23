package com.cat.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import com.ta.TASyncHttpClient;
import com.ta.annotation.TAInject;
import com.ta.annotation.TAInjectView;
import com.ta.util.http.AsyncHttpClient;
import com.ta.util.http.AsyncHttpResponseHandler;
import com.ta.util.http.RequestParams;

import android.webkit.WebView;
import com.cat.adapter.ImageAdapter;
import com.ta.annotation.TAInjectView;
import android.widget.AdapterView.OnItemClickListener;

import android.widget.GridView;

public class VipVideoActivity extends ThinkAndroidBaseActivity
{
	@TAInjectView(id = R.id.vip_ppt)
	Button vipPptButton;
	@TAInjectView(id = R.id.vip_article)
	Button vipArticleButton;
	@TAInjectView(id = R.id.goto_parent)
	Button gotoButton;
	@TAInjectView(id = R.id.show_content)
	WebView showWebView;
	@TAInjectView(id = R.id.gridView)
	private GridView gridView;
	@TAInject
	private TASyncHttpClient syncHttpClient;
	@TAInject
	private AsyncHttpClient asyncHttpClient;
	private static final String VIPURL = "http://vip.ofwho.com/json.php";
	
	@Override
	protected void onAfterOnCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onAfterOnCreate(savedInstanceState);
		setTitle(R.string.vip_video_title);
		
		final ImageAdapter adapter = new ImageAdapter(this, getTAApplication());
		gridView.setAdapter(adapter);
	    gridView.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				makeToast("Item clicked, position is arg2:" + arg2 + "arg1" + arg1 + "arg0" + arg0);
				doActivity(R.string.vipvideodetailactivity);
			}
		});  
	}

	@Override
	protected void onAfterSetContentView()
	{
		// TODO Auto-generated method stub
		super.onAfterSetContentView();
		OnClickListener onClickListener = new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				switch (v.getId())
				{
					case R.id.vip_ppt:
						doActivity(R.string.vippptactivity);
						break;
					case R.id.vip_article:
						doActivity(R.string.viparticleactivity);
						break;
					case R.id.goto_parent:
						// TANetworkStateReceiver.checkNetworkState(ThinkAndroidMainActivity.this);
						doActivity(R.string.vipmainactivity);
						break;
					default:
						//doActivity(R.string.vipmainactivity);
						break;
				}
			}
		};
		
		makeToast("Welcome VIP lecture!");
		//asynGet();
		
		vipPptButton.setOnClickListener(onClickListener);
		vipArticleButton.setOnClickListener(onClickListener);
		gotoButton.setOnClickListener(onClickListener);
	}
	
	private void synGet()
	{
		String content = syncHttpClient.get(VIPURL);
		showWebView(content);
	}
	
	private void asynGet()
	{
		asyncHttpClient.get(VIPURL, new AsyncHttpResponseHandler()
		{
			@Override
			public void onSuccess(String content)
			{
				// TODO Auto-generated method stub
				super.onSuccess(content);
				showWebView(content);
			}
		});
	}
	private void showWebView(String content)
	{
		showWebView.getSettings().setDefaultTextEncodingName("utf-8");
		showWebView.loadDataWithBaseURL(null, content, "text/html", "utf-8",
				null);
	}

	private void makeToast(String content)
	{
		Toast.makeText(this, content, Toast.LENGTH_LONG).show();
	}
	
}