package com.amirserry.postfix_evaluation;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Stack {

	private int index=0;

	private NavigableMap<Integer, String> content=new TreeMap<Integer, String>();
	
	public Boolean isEmpty()
	{
		return content.isEmpty();
	}
	
	public void push(String data)
	{
		content.put(index, data);
		index++;
	}
	
	public String pop()
	{
		if (isEmpty()) {
			return "-1.0";
		}
		Map.Entry<Integer, String> entry  = content.lastEntry();
		String Item = content.get(entry.getKey());
		content.remove(entry.getKey());
	
		
		return Item;
	}
	

	public void showContent()
	{
		for (Map.Entry<Integer, String> entry : content.entrySet()) {
	        System.out.println(entry.getKey() + ":" + entry.getValue());
	    }
	}
}
