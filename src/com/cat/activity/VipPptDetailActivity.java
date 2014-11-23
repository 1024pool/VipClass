package com.cat.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;


import com.ta.TAActivity;
import com.ta.annotation.TAInjectView;

public class VipPptDetailActivity extends TAActivity
{
	@TAInjectView(id = R.id.vip_video)
	Button vipVideoButton;
	@TAInjectView(id = R.id.vip_article)
	Button vipArticleButton;
	@TAInjectView(id = R.id.goto_parent)
	Button gotoButton; 

	
	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onAfterOnCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onAfterOnCreate(savedInstanceState);
		setTitle(R.string.vip_ppt_detail_title);

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
					case R.id.vip_video:
						doActivity(R.string.vipvideoactivity);
						break;
					case R.id.vip_article:
						doActivity(R.string.viparticleactivity);
						break;
					case R.id.goto_parent:
						// TANetworkStateReceiver.checkNetworkState(ThinkAndroidMainActivity.this);
						doActivity(R.string.vippptactivity);
						break;
					default:
						//doActivity(R.string.vipmainactivity);
						break;
				}
			}
		};
		vipVideoButton.setOnClickListener(onClickListener);
		vipArticleButton.setOnClickListener(onClickListener);
		gotoButton.setOnClickListener(onClickListener);
	}
}