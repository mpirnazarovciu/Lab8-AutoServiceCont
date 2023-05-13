package uz.muu;

import uz.muu.exceptions.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class CarRepairing {

	public AutoService createAutoService(int ID, String name, Coordinate coordinate, String carModel, List<Service> serviceList) {
		return null;
	}

	public Collection<AutoService> getAutoServices() {
		return null;
	}

	public Driver addDriver(int ID, String fullName, String carModel) throws DriverAlreadyExist {
		return null;
	}

	public Collection<Driver> getDrivers() {
		return null;
	}

	public Driver getDriver(int ID) throws NoSuchDriver {
		return null;
	}

	public Service createService(int ID, String serviceName, double cost) {
		return null;
	}

	public Service getService(int ID) throws NoSuchService {
		return null;
	}

	public List<AutoServiceRating> availableAutoService(int driverID, Coordinate currentCoordinate, List<Service> serviceList){

		return null;
	}

	public int bookAutoService(int driverID, int autoServiceID, List<Service> serviceList){

		return -1;
	}

	public double findDistanceBetweenTwoCoordinates(Coordinate startingCoordinate, Coordinate destinationCoordinate){
		double xMin = Math.min(startingCoordinate.getxAxes(), destinationCoordinate.getxAxes());
		double xMax = Math.max(startingCoordinate.getxAxes(), destinationCoordinate.getxAxes());
		double yMin = Math.min(startingCoordinate.getyAxes(), destinationCoordinate.getyAxes());
		double yMax = Math.max(startingCoordinate.getyAxes(), destinationCoordinate.getyAxes());

		double xLength = xMax - xMin;
		double yLength = yMax - yMin;
		double length = Math.sqrt(xLength*xLength + yLength*yLength);

		return length;
	}

	public int getNumberOfBookingsByDrivers(int driverID) {

		return -1;
	}

	public double getAutoServiceTotalProfit(int serviceID) {

		return -1;
	}

	public AutoService getAutoService(int ID) throws NoSuchAutoService{
		return null;
	}


	public List<Service> getServicesByAutoService(int autoServiceID) {
		return null;
	}

	public void setAutoServiceRating(int bookID, int rating, String comment) {

	}

	public void printAutoServiceRatings() {
	}
}
