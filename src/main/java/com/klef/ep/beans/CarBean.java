package com.klef.ep.beans;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;



import com.klef.ep.models.Car;
import com.klef.ep.service.CarService;

@ManagedBean(name="carbean",eager = true)
public class CarBean {
	
	@EJB(lookup = "java:global/carmanagement/CarServiceImpl!com.klef.ep.service.CarService")
	
	CarService carService;
	
	private int id;
	private String make;
	private String model;
	private int year;
	private String color;
	private String bodytype;
	private String transmission;
	private String fueltype;
	private double price;
	private Part carImage;
	private Car selectedCar;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getBodytype() {
		return bodytype;
	}
	public void setBodytype(String bodytype) {
		this.bodytype = bodytype;
	}
	public String getTransmission() {
		return transmission;
	}
	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}
	public String getFueltype() {
		return fueltype;
	}
	public void setFueltype(String fueltype) {
		this.fueltype = fueltype;
	}
	
	public String Addcar()
	{
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
		Car c=new Car();
		
		c.setBodytype(bodytype);
		c.setColor(color);
		c.setFueltype(fueltype);
		c.setMake(make);
		c.setModel(model);
		c.setTransmission(transmission);
		c.setYear(year);
		c.setPrice(price);
		c.setImage(convertImageToByteArray(carImage));
		
		carService.addcar(c);
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Car added successfully"));
        return "success"; // Navigate to success page or show success message
		}
		catch(Exception e)
		{
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "An error occurred while adding the car. Please try again."));
            e.printStackTrace();
            return null;
		}
	}
	
	public List<Car> Viewallcar()
	{
		return carService.viewallcars();
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Part getCarImage() {
		return carImage;
	}
	public void setCarImage(Part carImage) {
		this.carImage = carImage;
	}
	
	
	
	private byte[] convertImageToByteArray(Part carImage) {
        try (InputStream input = carImage.getInputStream()) {
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }
            return output.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to get Base64 image representation
    public String getImageBase64(Car car) {
        byte[] image = car.getImage();
        return image != null ? "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(image) : null;
    }
    
    public String delete(Integer id) {
        carService.deletecar(id);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Car deleted successfully"));
        return "viewcars";
    }

    public void downloadImage(int carId) {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
        try {
            Car car = carService.viewCarById(carId); // Assuming a method to get car by ID
            byte[] image = car.getImage();
            if (image != null) {
                response.reset();
                response.setContentType("image/jpeg"); // Change MIME type if needed
                response.setHeader("Content-Disposition", "attachment; filename=\"car_image.jpg\"");
                OutputStream output = response.getOutputStream();
                output.write(image);
                output.flush();
                output.close();
            } else {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Image not found.");
                context.addMessage(null, message);
            }
        } catch (IOException e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "An error occurred while downloading the image.");
            context.addMessage(null, message);
            e.printStackTrace();
        }
        context.responseComplete();
    }
    
    @PostConstruct
    public void init() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String idParam = params.get("id");
        if (idParam != null) {
            int id = Integer.parseInt(idParam);
            selectedCar = carService.viewCarById(id); // Method to get car by ID
        }
    }
    
	public Car getSelectedCar() {
		return selectedCar;
	}
	public void setSelectedCar(Car selectedCar) {
		this.selectedCar = selectedCar;
	}

}
