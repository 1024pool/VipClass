package com.cat.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.cat.adapter.StringAdapter;
import com.cat.data.StringUrls;
import com.cat.entity.articalEntity;
import com.ta.TAActivity;
import com.ta.TASyncHttpClient;
import com.ta.annotation.TAInject;
import com.ta.annotation.TAInjectView;
import com.ta.mvc.common.TARequest;
import com.ta.util.http.AsyncHttpClient;
import com.ta.util.resoperate.TAPreferenceOperateUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VipArticleActivity extends ThinkAndroidBaseActivity
{
	@TAInjectView(id = R.id.vip_video)
	Button vipVideoButton;
	@TAInjectView(id = R.id.vip_ppt)
	Button vipPptButton;
	@TAInjectView(id = R.id.goto_parent)
	Button gotoButton;
	@TAInjectView(id = R.id.vip_article_listView)
	private ListView listView;
	private static final String VIPURL = "http://vip.ofwho.com/json.php";
	@TAInject
	private static TASyncHttpClient syncHttpClient;
	@TAInject
	private AsyncHttpClient asyncHttpClient;

	@Override
	protected void onAfterOnCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onAfterOnCreate(savedInstanceState);
		setTitle(R.string.vip_article_title);
        

        // 获取ListView对象
		listView = (ListView)findViewById(R.id.vip_article_listView);
		
		/** List<HashMap<String, Object>> data = new ArrayList<HashMap<String,Object>>();
		//迭代传入  
		for(articalEntity video : videos)  
		{  
		    //把video中的数据绑定到item中  
		    HashMap<String, Object> item = new HashMap<String, Object>();  
		    //item.put("id", video.getId());  
		    item.put("title", video.getTitle());  
		    //item.put("video_url", video.getVideo_url());  
		    item.put("descrition", video.getDescrition());
		   // item.put("vide_image", video.getVide_image());
		    data.add(item);  
		}  
		//使用SimpleAdapter处理ListView显示数据  
		//SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.viparticle,   
		//        new String[]{"title", "descrition"}, new int[]{R.id.vip_title, R.id.vip_description});  
		//  
		//listView.setAdapter(adapter); **/ 
		
		 String[] arr = StringUrls.arrData;

		//将数据封装到ArrayAdapter
		 ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, arr);

		//为ListView设置Adapter
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				//makeToast("Item clicked, position is arg2:" + arg2 + "arg1" + arg1 + "arg0" + StringUrls.arrData);
				StringUrls.setPosition(arg2);
				doActivity(R.string.viparticledetailactivity);
			}
		}); 

	}

	public void echoJson() throws JSONException {
		//@description: 根据接收到的JSON字符串来解析字符串中所包含的数据和数据对象

		//接收到的JSON字符串
		String result = "[{\"username\": \"your name\", \"user_json\": {\"username\": \"your name\", \"nickname\": \"your nickname\"}}]";
		//根据字符串生成JSON对象
		JSONArray resultArray = new JSONArray(result);
		JSONObject resultObj = resultArray.optJSONObject(0);

		//获取数据项
		String username = resultObj.getString("username");

		//获取数据对象
		JSONObject user = resultObj.getJSONObject("user_json");
		String nickname = user.getString("nickname");
		makeToast("xx"+username + "yyy" +  nickname);
		
		
		String content = syncHttpClient.get(VIPURL);
		JSONArray resultArray1 = new JSONArray(content);
		JSONObject resultObj1 = resultArray1.optJSONObject(0);
		///StringUrls.arrData[StringUrls.arrData.length+1] = resultObj1.getString("description");
		
		makeToast("zzz"+resultObj1.getString("description") );
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
					case R.id.vip_detail:
						doActivity(R.string.viparticledetailactivity);
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
		vipVideoButton.setOnClickListener(onClickListener);
		vipPptButton.setOnClickListener(onClickListener);
		gotoButton.setOnClickListener(onClickListener);
	}
	
	private void makeToast(String content)
	{
		Toast.makeText(this, content, Toast.LENGTH_LONG).show();
	}
}