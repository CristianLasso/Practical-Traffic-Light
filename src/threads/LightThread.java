package threads;

import ui.TrafficGUI;

public class LightThread extends Thread{
	
	private TrafficGUI trafficGUI;
	
	public LightThread(TrafficGUI gui) {
		trafficGUI = gui;
	}
	
	@Override
	public void run() {
		try {
			trafficGUI.setFillGreen();
			sleep(2000);
			trafficGUI.setFillYellow();
			sleep(1000);
			trafficGUI.setFillRed();
			sleep(3000);
			trafficGUI.setFillWhite();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
}
