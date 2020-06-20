package main;

import java.util.prefs.Preferences;

public class Main {
	private static Preferences prefs;
	public static final String FREQ_KEY = "FREQ_KEY";
	public static final int FREQ_DEF = 30;

	public static void main(String[] args) {
		System.setProperty("apple.awt.UIElement", "true");

		Main main = new Main();
		main.start();

	}

	public void start() {
		prefs = Preferences.userRoot().node(this.getClass().getName());
		Controller ctlr = new Controller();

		SASystemTray tray = new SASystemTray(ctlr);
		tray.start();
	}

	public static Preferences getPrefs() {
		return prefs;
	}
}
