package com.lqc.common.utils;

import java.util.Collections;
import java.util.Map;

/**
 * Utils - HashMap
 * 
 * @author liqc
 * @version 1.0
 */
public final class HashMapUtils {

	/**
	 * 不允许实例化
	 */
	private HashMapUtils() {
	}
	
	/**
	 * 最佳初始容量
	 * 
	 * @see <a href="http://stackoverflow.com/questions/434989/hashmap-intialization-parameters-load-initialcapacity">参考</a>
	 * 
	 * @param size 大小
	 * @return
	 */
	public static int bestInitialCapacity(int size) {
		return (int) (size * 0.75f) + 1;
	}
	
	/**
	 * 合并
	 * 
	 * <p>注意：合并后原Map就不能再使用！
	 * 
	 * @param targetMap
	 * @param sourceMap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <K, V> Map<K, V> putAll(final Map<K, V> targetMap, final Map<K, V> sourceMap) {
		Map<K, V> result = null;
		if (targetMap == null && sourceMap == null) {
			result = Collections.emptyMap();
		} else if (targetMap == null && sourceMap != null) {
			result = sourceMap;
		} else if (targetMap != null && sourceMap == null) {
			result = targetMap;
		} else {	// 都不为空
			for (Map.Entry<?, ?> sourceMapEntry : sourceMap.entrySet()) {
				targetMap.put((K) sourceMapEntry.getKey(), (V) sourceMapEntry.getValue());
			}
			result = targetMap;
		}
		return result;
	}
	
}
