package com.janita.httpclient;

import com.httpclient.HttpClientUtil;
import com.httpclient.common.HttpConfig;
import com.httpclient.common.HttpHeader;
import com.httpclient.exception.HttpProcessException;
import com.janita.httpclient.bean.User;
import com.janita.httpclient.utils.HttpClientUtils;
import org.apache.http.Header;
import org.apache.http.client.CookieStore;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 
 * 测试携带cookie的操作
 * 
 * @author arron
 * @date 2016年1月7日 上午10:09:53 
 * @version 1.0 
 */
public class TestUserCookie {

	public static void main(String[] args) throws HttpProcessException {
		//登录地址
		String carUrl = "http://192.168.100.75:9999/car/findOne";
		Map<String,Object> params = new HashMap<>();
		params.put("carId",1111111);

		//定义cookie存储
		HttpClientContext context = new HttpClientContext();
		CookieStore cookieStore = new BasicCookieStore();
		context.setCookieStore(cookieStore);
		HttpConfig config = HttpConfig.custom().url(carUrl).context(context).map(params);
		//获取参数
		String result = HttpClientUtil.post(config);//可以用.send(config)代替，但是推荐使用明确的get方法
		System.out.println(result);


		String userUrl  = "http://192.168.100.75:9999/user/findOne";
		User user = new User();
		user.setUserId("sdfsdfsdf");
		System.out.println("*******"+ HttpClientUtils.doHttpPost(userUrl,user));

		cookieStore = context.getCookieStore();
		for (Cookie cookie : cookieStore.getCookies()) {
			System.out.println(cookie.getName()+"--"+cookie.getValue());
		}
	}

	/**
	 * 通过正则表达式获取内容
	 * 
	 * @param regex		正则表达式
	 * @param from		原字符串
	 * @return
	 */
	public static String[] regex(String regex, String from){
		Pattern pattern = Pattern.compile(regex); 
		Matcher matcher = pattern.matcher(from);
		List<String> results = new ArrayList<String>();
		while(matcher.find()){
			for (int i = 0; i < matcher.groupCount(); i++) {
				results.add(matcher.group(i+1));
			}
		}
		return results.toArray(new String[]{});
	}
}
