/**
 * 
 */
package com.buildsaas.test;

import org.junit.Test;

/**
 * @author yxq
 * @date 2014年9月29日上午10:21:20
 * @email 2571094456@qq.com
 */
public class JunitTest1 {
	@Test(expected=RuntimeException.class)
	public void gg() {
		throw new IllegalArgumentException();
		//Assert.assertTrue("must throw an error",2 == 1);
	}
}
