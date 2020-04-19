package com.amirserry.postfix_evaluation;

import java.util.HashMap;
import java.util.Map;

public class Queue {

	private int index=0;
	private int pointer=0;
	private Map<Integer, Integer> content=new HashMap<Integer, Integer>();
	
	public Boolean isEmpty()
	{
		return content.isEmpty();
	}
	
	public void enqueue(Integer data)
	{
		content.put(index, data);
		index++;
	}
	
	public Integer dequeue()
	{
		if (isEmpty()) {
			return -1;
		}
		
		Integer Item = content.get(pointer);
		content.remove(pointer);
		pointer++;
		
		return Item;
	}
	

	public void showContent()
	{
		for (Map.Entry<Integer, Integer> entry : content.entrySet()) {
	        System.out.println(entry.getKey() + ":" + entry.getValue());
	    }
	}
}
