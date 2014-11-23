package com.cat.data;

import java.util.ArrayList;
import java.util.List;

import com.cat.entity.articalEntity;
import com.ta.TASyncHttpClient;
import com.ta.annotation.TAInject;
//import com.ta.util.http.AsyncHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class StringUrls {

	static int position;
	@TAInject
	private static TASyncHttpClient syncHttpClient;
	@TAInject
	// private AsyncHttpClient asyncHttpClient;
	private static final String VIPURL = "http://vip.ofwho.com/json.php";
	public final static String[] stringUrls = new String[] { "http://vip.ofwho.com/json.php" };

	public static String[] arrData = new String[] { "技术架构面临的挑战和应对策略",
			"唯品会运维架构和流程改造之路", "唯品会日志平台建设" };
	public static String[] retData = new String[] {
			"唯品会技术架构面临的挑战和应对策略111111唯品会技术架构面临的挑战和应对策略111111唯品会技术架构面临的挑战和应对策略111111唯品会技术架构面临的挑战和应对策略111111唯品会技术架构面临的挑战和应对策略111111唯品会技术架构面临的挑战和应对策略111111",
			"唯品会运维架构和流程改造之路11111111111111111唯品会运维架构和流程改造之路11111111111111111唯品会运维架构和流程改造之路11111111111111111唯品会运维架构和流程改造之路11111111111111111唯品会运维架构和流程改造之路11111111111111111",
			"1111111111111111111111唯品会日志平台建设111111111111111111111唯品会日志平台建设111111111111111111111唯品会日志平台建设111111111111111111111唯品会日志平台建设111111111111111111111唯品会日志平台建设" };

	public static void setPosition(int position) {
		StringUrls.position = position;
	}

	public static String getPosition() throws JSONException {
		// TODO Auto-generated method stub
		return StringUrls.retData[position];
	}

	public static String synGet(int i) throws JSONException {

		String content = syncHttpClient.get(VIPURL);
		JSONArray resultArray1 = new JSONArray(content);

		JSONObject resultObj1 = resultArray1.optJSONObject(i);
		return resultObj1.getString("description");

		// return resultObj1;
	}
}