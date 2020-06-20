package main;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class Controller {
	private Thread unliThread;
	public boolean isRunning;
	private final String pattern = "MMM dd yyyy HH:mm:ss";
	private boolean debug = true;
	
	public void start() {
		isRunning = true;
		unliThread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    Robot robot = new Robot();
                    
                    while(isRunning)
                    {
                    	if(debug) {
                    		System.out.println(new SimpleDateFormat(pattern).format(new Date()));
                    	}
                        
                        robot.mouseMove((int)MouseInfo.getPointerInfo().getLocation().getX() + 1, (int)MouseInfo.getPointerInfo().getLocation().getY());
                        robot.delay(5);
                        robot.mouseMove((int)MouseInfo.getPointerInfo().getLocation().getX() - 1, (int)MouseInfo.getPointerInfo().getLocation().getY());
                        robot.delay(Main.getPrefs().getInt(Main.FREQ_KEY, Main.FREQ_DEF) * 1000);
                    }
                } catch (AWTException ex)
                {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
		unliThread.start();
	}
	
	public void stop() {
		isRunning = false;
	}
}
