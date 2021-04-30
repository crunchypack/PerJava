package com.perscholas.logging;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.XMLFormatter;

public class Logg {
	
	static final Logger LOGGER = Logger.getLogger(Logg.class.getName());
	
	public static void main (String[]  args) {
		
		LOGGER.setUseParentHandlers(false);
		LOGGER.setLevel(Level.INFO);
		
		Handler fh = new ConsoleHandler();
		fh.setFormatter(new XMLFormatter());
		
		LOGGER.addHandler(fh);
		
		LOGGER.info("Info log message");
	}
	
	public static int getRandomNumber(int min, int max) {
	    Random random = new Random();
	    return random.nextInt(max - min) + min;
	}

}
