package se.mah.k3lara.skaneAPI.control;

import java.util.TimerTask;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.view.TestGUIBall;
import se.mah.k3lara.skaneAPI.xmalparser.Parser;

/** This thread takes care of the calls to Sk�netrafiken API*/
public class ThreadWithTimer extends TimerTask{
    TestGUIBall testGUIBall;
    public ThreadWithTimer(TestGUIBall testGUIBall) {
		this.testGUIBall = testGUIBall; 
	}
    
    @Override
    public void run() {
            	 System.out.println("Results when searching for minutes to next departure to Lund");
            		String searchURL = Constants.getURL("80000","81216",1); //Malm� C = 80000,  Malm� Gatorg 80100, H�sleholm C 93070 Kolla sk�netrafiken f�r fler koder
            		Journeys journeys = Parser.getJourneys(searchURL);
            		if (journeys.getJourneys().get(0) != null ){
            				testGUIBall.updateGUI(journeys.getJourneys().get(0).getTimeToDeparture());
            		}
    }
}
