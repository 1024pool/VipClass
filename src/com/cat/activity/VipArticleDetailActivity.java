package com.cat.activity;

import org.json.JSONException;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.cat.data.StringUrls;
import com.ta.annotation.TAInjectView;
import com.ta.mvc.common.TARequest;
import com.ta.util.resoperate.TAPreferenceOperateUtils;

public class VipArticleDetailActivity extends ThinkAndroidBaseActivity
{
	@TAInjectView(id = R.id.vip_video)
	Button vipVideoButton;
	@TAInjectView(id = R.id.vip_ppt)
	Button vipPptButton;
	@TAInjectView(id = R.id.vip_article)
	Button vipArticleButton;
	@TAInjectView(id = R.id.goto_parent)
	Button gotoButton;
	@TAInjectView(id = R.id.vip_arcticle_tw)
	TextView textView;

	@Override
	protected void onAfterOnCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onAfterOnCreate(savedInstanceState);
		setTitle(R.string.vip_article_detail_title);
		
		String x;
		try {
			x = StringUrls.getPosition();
			textView.setText(x);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
					case R.id.goto_parent:
						// TANetworkStateReceiver.checkNetworkState(ThinkAndroidMainActivity.this);
						doActivity(R.string.viparticleactivity);
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
		gotoButton.setOnClickListener(onClickListener);
	}
	
	private void makeToast(String content)
	{
		Toast.makeText(this, content, Toast.LENGTH_LONG).show();
	}
}