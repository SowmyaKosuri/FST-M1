package activities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

	class Plane {
		private List<String> passengers;
	    private int maxPassengers;
	    private Date lastTakeOffTime;
	    private Date lastLandingTime;
		//private Date lastTimeOffTime;

	    public Plane(int maxPassengers) {
	        this.maxPassengers = maxPassengers;
	        this.passengers = new ArrayList<String>();
	}
	    public void onboard(String passengerName) {
	    	if(passengers.size() <= maxPassengers) {
	        this.passengers.add(passengerName);
	    }
	    	else {
	    		System.out.println("Plane is full");
	    	}
	    }

	    public void setTakeOff() {
	        this.lastTakeOffTime = new Date();
	    }

	    public Date getTakeOffTime()  {
	    	return this.lastTakeOffTime;
	    }
	    public void setLand() {
	        this.lastLandingTime = new Date();
	        this.passengers.clear();
	    }
	    
	    public Date getLastTimeLanded() {
	        return this.lastLandingTime;
	    }

	    public List<String> getPassengers() {
	        return this.passengers;
	    }
	}
	

public class Activity6 {

    public static void main(String[] args) throws InterruptedException {
        //Create an object of Plane
        Plane b747 = new Plane(10);
        
        //Onboard passengers
        b747.onboard("John");
        b747.onboard("Steve");
        b747.onboard("Anna");
        
        //Set the takeOff time
        b747.setTakeOff();
        System.out.println("Plane took off at: " + b747.getTakeOffTime());
        //Print list of people on board
        System.out.println("People on the plane: " + b747.getPassengers());
        //Flying.....
        Thread.sleep(5000);
        //Plane has landed
        b747.setLand();
        //Plane lands
        System.out.println("Plane landed at: " + b747.getLastTimeLanded());
        System.out.println("People on the plane after landing: " + b747.getPassengers());
    }
  
}
