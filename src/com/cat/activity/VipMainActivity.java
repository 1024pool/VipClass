package com.cat.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.ta.annotation.TAInjectView;

public class VipMainActivity extends ThinkAndroidBaseActivity
{
	@TAInjectView(id = R.id.vip_video)
	Button vipVideoButton;
	@TAInjectView(id = R.id.vip_ppt)
	Button vipPptButton;
	@TAInjectView(id = R.id.vip_article)
	Button vipArticleButton;
	@TAInjectView(id = R.id.vip_example)
	Button vipExampleleButton;
	@TAInjectView(id = R.id.exit_app)
	Button exitAppButton;

	@Override
	protected void onAfterOnCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onAfterOnCreate(savedInstanceState);
		setTitle(R.string.vip_main_title);
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
					case R.id.vip_ppt:
						doActivity(R.string.vippptactivity);
						break;
					case R.id.vip_article:
						doActivity(R.string.viparticleactivity);
						break;
					case R.id.vip_example:
						doActivity(R.string.thinkandroidmainactivity);
						break;
					case R.id.goto_parent:
						// TANetworkStateReceiver.checkNetworkState(ThinkAndroidMainActivity.this);
						doActivity(R.string.vipmainactivity);
						break;
					case R.id.exit_app:
						// TANetworkStateReceiver.checkNetworkState(ThinkAndroidMainActivity.this);
						VipMainActivity.this.exitApp();
						break;
					default:
						//doActivity(R.string.vipmainactivity);
						break;
				}
			}
		};
		vipVideoButton.setOnClickListener(onClickListener);
		vipPptButton.setOnClickListener(onClickListener);
		vipArticleButton.setOnClickListener(onClickListener);
		vipExampleleButton.setOnClickListener(onClickListener);
		exitAppButton.setOnClickListener(onClickListener);
	}
}