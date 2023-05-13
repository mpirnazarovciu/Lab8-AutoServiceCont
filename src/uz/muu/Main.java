package uz.muu;

import uz.muu.exceptions.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        CarRepairing cr = new CarRepairing();

        cr.createService(1, "oil change", 50000);
        cr.createService(2, "body repair", 700000);
        cr.createService(3, "diagnostics", 150000);
        cr.createService(4, "battery replacement", 1000000);

        List<Service> serviceListAll = createListOfServices(new int[]{1, 2, 3, 4}, cr);
        List<Service> serviceList124 = createListOfServices(new int[]{1, 2, 4}, cr);
        List<Service> serviceList234 = createListOfServices(new int[]{2, 3, 4}, cr);
        List<Service> serviceList123 = createListOfServices(new int[]{1, 2, 3}, cr);
        List<Service> serviceList1 = createListOfServices(new int[]{1}, cr);

        // Adding list of auto services

        AutoService autoService1 = cr.createAutoService(1, "Avtoritet", new Coordinate(100, 250), "Chevrolet", serviceListAll);
        AutoService autoService2 = cr.createAutoService(2, "Carbox", new Coordinate(-50, -150), "Mercedes Benz", serviceList124);
        AutoService autoService3 = cr.createAutoService(3, "Imagine", new Coordinate(-100, 150), "Ferrari", serviceList234);
        AutoService autoService4 = cr.createAutoService(4, "Shina.uz", new Coordinate(20, 70), "Chevrolet", serviceList1);
        AutoService autoService5 = cr.createAutoService(5, "DA Service", new Coordinate(0, 0), "Mercedes Benz", serviceList123);
        AutoService autoService6 = cr.createAutoService(6, "AvtoUsta", new Coordinate(150, 350), "Chevrolet", serviceList124);
        AutoService autoService7 = cr.createAutoService(7, "FazJet", new Coordinate(100, -150), "Ferrari", serviceList234);
        AutoService autoService8 = cr.createAutoService(8, "TuningHouse", new Coordinate(-150, -350), "Ferrari", serviceList123);
        AutoService autoService9 = cr.createAutoService(9, "Koleso", new Coordinate(350, 550), "Chevrolet", serviceList1);
        AutoService autoService10 = cr.createAutoService(10, "Sprint", new Coordinate(-350, -450), "Ferrari", serviceList124);

        List<Service> serviceListByAutoService = cr.getServicesByAutoService(1);

        List<Service> serviceList = createListOfServices(new int[]{1, 2, 4}, cr);

        Collection<AutoService> autoServices = cr.getAutoServices();
        try {
            AutoService autoService = cr.getAutoService(7);
        } catch (NoSuchAutoService e) {
            e.printStackTrace();
        }

        try {
            cr.addDriver(1, "Michael Schumacher", "Ferrari");
            cr.addDriver(2, "Max Verstappen", "Chevrolet");
            cr.addDriver(3, "Lewis Hamilton", "Mercedes Benz");
        } catch (DriverAlreadyExist e){
            e.printStackTrace();
        }


        Driver driver=null, driver2=null;
        try {
            driver = cr.getDriver(1);
            driver2 = cr.getDriver(5);
        } catch (NoSuchDriver e){
            System.err.println("Driver NOT found.");
        }

        Collection<Driver> driversList = cr.getDrivers();



        try{
            Service s1 = cr.getService(1);
            Service s2 = cr.getService(2);
        } catch (NoSuchService e){
            System.err.println("Service not fount with that ID");
        }


        // AutoServiceHashmap datastructure like: autostructure ID, averageRating
        List<AutoServiceRating> autoServiceRatings1 = cr.availableAutoService(1, new Coordinate(0, 0), serviceList);
        int bookID = cr.bookAutoService(1, autoServiceRatings1.get(0).getAutoService().getID(), serviceList);
        cr.setAutoServiceRating(bookID, 5, "Good Autoservice. High quality");

        List<AutoServiceRating> autoServiceRatings2 = cr.availableAutoService(2, new Coordinate(0, 0), serviceList123);
        int bookID2 = cr.bookAutoService(1, autoServiceRatings2.get(1).getAutoService().getID(), serviceList123);
        cr.setAutoServiceRating(bookID2, 1, "Very bad service. Problem not solved!");

        List<AutoServiceRating> autoServiceRatings3 = cr.availableAutoService(3, new Coordinate(0, 0), serviceList1);
        int bookID3 = cr.bookAutoService(1, autoServiceRatings3.get(2).getAutoService().getID(), serviceList1);
        cr.setAutoServiceRating(bookID3, 3, "Didn't return the rest of an oil!");

        double length = cr.findDistanceBetweenTwoCoordinates(new Coordinate(2, 1), new Coordinate(4, 3));

        try {
            System.out.println("Driver " + cr.getDriver(1).getName() + " has booked: " + cr.getNumberOfBookingsByDrivers(1) + " times.");
        } catch (NoSuchDriver noSuchDriver) {
            noSuchDriver.printStackTrace();
        }

        double totalProfit = cr.getAutoServiceTotalProfit(2);

        cr.printAutoServiceRatings();

    }

    public static List<Service> createListOfServices(int[] servicesId, CarRepairing cr) {

        List<Service> serviceList = new LinkedList<>();
        try {
            for (int serviceID:
                 servicesId) {
                serviceList.add(cr.getService(serviceID));
            }

        } catch (NoSuchService noSuchService) {
            noSuchService.printStackTrace();
        }
        return serviceList;
    }


}
