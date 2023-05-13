package test.test;

import junit.framework.TestCase;
import uz.muu.*;
import uz.muu.exceptions.NoSuchAutoService;

import java.util.Collection;
import java.util.List;

public class TestR1_AutoService extends TestCase {

	CarRepairing cr = null;
	AutoService autoService1 = null;

	public void setUp(){

		try{
			cr = new CarRepairing();
			cr.createService(1, "oil change", 50000);
			cr.createService(2, "body repair", 700000);
			cr.createService(3, "diagnostics", 150000);
			cr.createService(4, "battery replacement", 1000000);

			List<Service> serviceListAll = Main.createListOfServices(new int[]{1, 2, 3, 4}, cr);
			List<Service> serviceList124 = Main.createListOfServices(new int[]{1, 2, 4}, cr);
			List<Service> serviceList234 = Main.createListOfServices(new int[]{2, 3, 4}, cr);
			List<Service> serviceList123 = Main.createListOfServices(new int[]{1, 2, 3}, cr);
			List<Service> serviceList1 = Main.createListOfServices(new int[]{1}, cr);

			AutoService autoService1 = cr.createAutoService(1, "Avtoritet", new Coordinate(100, 250), "Chevrolet", serviceListAll);
			AutoService autoService2 = cr.createAutoService(2, "Carbox", new Coordinate(-50, -150), "Mercedes Benz", serviceList124);
			AutoService autoService3 = cr.createAutoService(3, "Imagine", new Coordinate(-100, 150), "Ferrari", serviceList124);
			AutoService autoService4 = cr.createAutoService(4, "Shina.uz", new Coordinate(20, 70), "Chevrolet", serviceList1);
			AutoService autoService5 = cr.createAutoService(5, "DA Service", new Coordinate(0, 0), "Mercedes Benz", serviceList123);
			AutoService autoService6 = cr.createAutoService(6, "AvtoUsta", new Coordinate(150, 350), "Chevrolet", serviceList124);
			AutoService autoService7 = cr.createAutoService(7, "FazJet", new Coordinate(100, -150), "Ferrari", serviceList234);
			AutoService autoService8 = cr.createAutoService(8, "TuningHouse", new Coordinate(-150, -350), "Ferrari", serviceList123);
			AutoService autoService9 = cr.createAutoService(9, "Koleso", new Coordinate(350, 550), "Chevrolet", serviceList1);
			AutoService autoService10 = cr.createAutoService(10, "Sprint", new Coordinate(-350, -450), "Ferrari", serviceList124);


		}catch(Exception e){
		}
	}

	public void testAutoService(){
		List<Service> serviceListAll = Main.createListOfServices(new int[]{1, 2, 3, 4}, cr);
		List<Service> serviceList124 = Main.createListOfServices(new int[]{1, 2, 4}, cr);
		List<Service> serviceList234 = Main.createListOfServices(new int[]{2, 3, 4}, cr);
		List<Service> serviceList123 = Main.createListOfServices(new int[]{1, 2, 3}, cr);
		List<Service> serviceList1 = Main.createListOfServices(new int[]{1}, cr);

		AutoService autoService1 = cr.createAutoService(1, "Pirelli", new Coordinate(100, 250), "Chevrolet", serviceListAll);

		assertNotNull(autoService1);
		assertEquals(autoService1.getName(), "Pirelli");
	}

	public void testGetAutoServices(){
		Collection<AutoService> autoServiceList = cr.getAutoServices();

		assertNotNull(autoServiceList);
		assertEquals(autoServiceList.size(), 10);
	}

	public void testGetAutoService(){
		AutoService autoService=null;
		try {
			autoService = cr.getAutoService(2);
		} catch (NoSuchAutoService exception){

		}
		assertNotNull(autoService);
		assertEquals(autoService.getName(), "Carbox");
	}

}
