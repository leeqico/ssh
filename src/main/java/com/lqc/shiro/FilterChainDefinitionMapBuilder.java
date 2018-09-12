package com.lqc.shiro;

import java.util.LinkedHashMap;

public class FilterChainDefinitionMapBuilder {

	public LinkedHashMap<String, String> buildFilterChainDefinitionMap(){
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		map.put("/login", "anon");
		map.put("/logout", "logout");
		map.put("/**", "authc");
		return map;
	}
	
}
