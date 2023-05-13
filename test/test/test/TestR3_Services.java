package test.test;

import junit.framework.TestCase;
import uz.muu.AutoService;
import uz.muu.CarRepairing;
import uz.muu.Service;
import uz.muu.exceptions.NoSuchService;

public class TestR3_Services extends TestCase {

	CarRepairing cr = null;
	AutoService autoService1 = null;

	public void setUp(){

		try{
			cr = new CarRepairing();
			cr.createService(1, "oil change", 50000);
			cr.createService(2, "body repair", 700000);
			cr.createService(3, "diagnostics", 150000);
			cr.createService(4, "battery replacement", 1000000);
		}catch(Exception e){
		}
	}

	public void testGetService(){
		try {
			Service service = cr.getService(1);
			assertEquals(service.getCost(), 50000.0);
		} catch (NoSuchService e){

		}
	}

	public void testGetServiceException(){
		try {
			Service service = cr.getService(8);
			fail("Exception did not thrown");
		} catch (Exception e){

		}
	}
}
