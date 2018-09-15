package com.lqc.shiro;

import java.util.LinkedHashMap;

public class FilterChainDefinitionMapBuilder {

	public LinkedHashMap<String, String> buildFilterChainDefinitionMap(){
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		map.put("/login.jhtml", "anon");
		map.put("/logout.jhtml", "logout");
		
		map.put("/user/add.jhtml", "perms[\"user:add\"]");
		
		map.put("/**", "authc");
		return map;
	}
	
}
