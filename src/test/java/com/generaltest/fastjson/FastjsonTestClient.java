package com.generaltest.fastjson;


import com.alibaba.fastjson.JSONObject;

public class FastjsonTestClient {

	public static void main(String[] args){
		String sJson="{\"countByChannelType\":{\"0\":12,\"1\":8,\"3\":4},\"countByPlanStatus\":{\"0\":12,\"1\":3,\"11\":5,\"2\":1,\"6\":1,\"9\":2},\"description\":\"OK\",\"planIds\":[\"L69908\",\"L69908\",\"E69900\",\"E69900\",\"E67562\",\"E61326\",\"L55180\",\"L54532\",\"L26009\",\"L11062\"],\"resultCode\":0}";

		JSONObject jo=JSONObject.parseObject(sJson);
		System.out.println(jo.getString("description"));
	}
	
}
