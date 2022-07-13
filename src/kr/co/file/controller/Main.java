package kr.co.file.controller;

import kr.co.file.util.LoggerFactory;
import kr.co.file.view.MainView;

public class Main {

	public static void main(String[] args) throws Exception {
		
		new	LoggerFactory().setLogger();
		new MainView().view();
		
	}

}