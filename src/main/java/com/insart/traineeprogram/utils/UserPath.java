package com.insart.traineeprogram.utils;

import java.util.ArrayList;
import java.util.List;

public class UserPath{
	private List<Integer> path;
	
	public UserPath(){
		path = new ArrayList<Integer>();
	}
	
	public void addPoint(Integer pointId){
		path.add(pointId);
	}
	
	public void deleteLastPoint(){
		path.remove(path.size()-1);
	}
	
	public Integer getLastPoint(){
		if (path.size() > 0){
			Integer point = path.get(path.size() -1);
			path.remove(path.size() - 1);
			return point;
		}else return null;
	}
	
	public void deleteAllPoints(){
		path.clear();
	}
	
	public String toString(){
		return path.toString();
	}
}
