package com.klef.ep.service;

import java.util.List;

import javax.ejb.Remote;

import com.klef.ep.models.Car;
@Remote
public interface CarService {
	
	public String addcar(Car car);
	public String deletecar(int cid);
	public String updatecar(Car car);
	public List<Car> viewallcars();
	public Car viewCarById(int id);
	
}
