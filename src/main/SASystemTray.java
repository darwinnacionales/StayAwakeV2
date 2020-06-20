package main;

import java.awt.AWTException;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import util.ImageLoader;

public class SASystemTray {
    private Controller ctrl;
	
    public SASystemTray(Controller ctrl) {
    	this.ctrl = ctrl;
    }

    public void start() {
        if (!SystemTray.isSupported()) {
            throw new Error("System tray is not supported.");
        }
        
        final SystemTray tray = SystemTray.getSystemTray();
        final PopupMenu popup = new PopupMenu();
        TrayIcon trayIcon;

        trayIcon = new TrayIcon(ImageLoader.createImage("/images/icon-64x64.png", "tray icon"));
        trayIcon.setImageAutoSize(true);

        ActionListener startStopListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	MenuItem item = (MenuItem) e.getSource();
            	
            	if(ctrl.isRunning) {
            		item.setLabel("Start");
            		ctrl.stop();
            	} else {
            		item.setLabel("Stop");
            		ctrl.start();
            	}
            }
        };
        
        ActionListener configureListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	ConfiguratorFrame configFrame = ConfiguratorFrame.getInstance();
            	configFrame.displayConfigurator();
            }
        };
        
        
        MenuItem exitItem = new MenuItem("Exit");
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tray.remove(trayIcon);
                System.exit(0);
            }
        });

        MenuItem startStopMenuItem = new MenuItem("Start");
        startStopMenuItem.addActionListener(startStopListener);
        
        MenuItem configureItem = new MenuItem("Configure");
        configureItem.addActionListener(configureListener);
        
        popup.add(startStopMenuItem);
        popup.add(configureItem);
        popup.add(exitItem);
        trayIcon.setPopupMenu(popup);

        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            e.printStackTrace();
        }

    }
}
