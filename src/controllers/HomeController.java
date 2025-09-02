package controllers;

import core.Controller;
import views.HomeView;

public class HomeController extends Controller{

	private HomeView homeView;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		homeView = new HomeView(this, mainFrame);
		addView("HomeView", homeView);
		
		mainFrame.setVisible(true);
		
	}

}
