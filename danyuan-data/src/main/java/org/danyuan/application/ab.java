/**
 * 
 */
package org.danyuan.application;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 *
 */
public class ab {

	public static void main(String[] args) {
		List<String> list1 = new ArrayList<>();
		list1.add("a");
		list1.add("b");
		List<String> list2 = new ArrayList<>(list1);
		list2.remove(0);
		System.out.println(list1.size());
		System.out.println(list1.get(0));
		System.out.println(list2.get(0));
	}
}
