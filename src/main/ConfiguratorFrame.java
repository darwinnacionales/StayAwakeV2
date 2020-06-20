package main;

import java.awt.GraphicsConfiguration;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;

import util.ImageLoader;

public class ConfiguratorFrame {
	private static GraphicsConfiguration gc;
	private static ConfiguratorFrame configFrame;
	private static JFrame frame;

	public ConfiguratorFrame() {
		frame = new JFrame(gc);
		
		frame.setTitle("StayAwake - Configure");
		frame.setSize(400, 230);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setAutoRequestFocus(true);
		frame.setAlwaysOnTop(true);

		initLayout();
	}

	private void initLayout() {
		frame.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();

		Border freqTitle = BorderFactory.createTitledBorder("Frequency Configuration");
		JPanel frequencyPanel = new JPanel();
		frequencyPanel.setBorder(freqTitle);
		frequencyPanel.setLayout(new GridBagLayout());
		JLabel freqDescLabel = new JLabel(
				"<html><p>Frequency defines how frequent should the mouse move.<br/><br/>If frequency is 10, the mouse will automatically move every 10 seconds.</p></html>");

		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 2;
		constraints.weightx = 1;
		frequencyPanel.add(freqDescLabel, constraints);

		constraints.gridwidth = 1;
		JLabel frequencyLabel = new JLabel("Frequency: ");
		SpinnerModel sm = new SpinnerNumberModel(30, 1, 60 * 30, 1);

		JSpinner spinner = new JSpinner(sm);
		
		spinner.setValue(Main.getPrefs().getInt(Main.FREQ_KEY, Main.FREQ_DEF));

		constraints.fill = GridBagConstraints.NONE;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.weightx = 0.75;
		constraints.insets.top = 20;
		constraints.anchor = GridBagConstraints.EAST;
		frequencyPanel.add(frequencyLabel, constraints);

		constraints.gridx = 1;
		constraints.weightx = 0.25;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.anchor = GridBagConstraints.WEST;
		frequencyPanel.add(spinner, constraints);

		constraints.insets.top = 0;
		Border launchTitle = BorderFactory.createTitledBorder("Launch Configuration");
		JPanel launchPanel = new JPanel();
		launchPanel.setBorder(launchTitle);
		launchPanel.setLayout(new GridBagLayout());

		JCheckBox cboxStartAppAtLogin = new JCheckBox("Open StayAwake at Login ");
		JCheckBox cboxLaunchAtStartApp = new JCheckBox("Start Mouse Move at Launch of StayAwake");

		constraints.insets.top = 5;
		constraints.insets.bottom = 5;
		constraints.insets.left = 10;
		constraints.insets.right = 10;
		constraints.weightx = 1;
		constraints.gridy = 0;
		launchPanel.add(cboxStartAppAtLogin, constraints);
		constraints.gridy = 1;
		launchPanel.add(cboxLaunchAtStartApp, constraints);

		JPanel actionPanel = new JPanel();
		actionPanel.setLayout(new GridBagLayout());
		JButton btnCancel = new JButton("Cancel");
		JButton btnSave = new JButton("Save");

		constraints.weightx = 0.5;
		constraints.insets.top = 0;
		constraints.insets.bottom = 0;
		constraints.insets.left = 10;
		constraints.insets.right = 10;
		constraints.gridx = 0;
		actionPanel.add(btnCancel, constraints);
		constraints.gridx = 1;
		actionPanel.add(btnSave, constraints);

		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.weightx = 1;
		constraints.weighty = 0.45;
		constraints.insets.top = 5;
		constraints.insets.bottom = 5;
		constraints.insets.left = 10;
		constraints.insets.right = 10;
		frame.add(frequencyPanel, constraints);
		constraints.gridy = 1;
//		frame.add(launchPanel, constraints);

		constraints.insets.top = 0;
		constraints.insets.bottom = 10;
		constraints.weighty = 0.1;
		constraints.gridy = 2;
		frame.add(actionPanel, constraints);

		ActionListener cancelListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}
		};

		ActionListener saveListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.getPrefs().putInt(Main.FREQ_KEY, (Integer) spinner.getValue());
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}
		};

		btnCancel.addActionListener(cancelListener);
		btnSave.addActionListener(saveListener);
	}

	public static ConfiguratorFrame getInstance() {
		if (null != configFrame) {
			return configFrame;
		}

		return new ConfiguratorFrame();
	}

	public void displayConfigurator() {
		frame.setLocationRelativeTo(null);
		frame.setIconImage(ImageLoader.createImage("/images/icon-64x64.png", "tray icon"));
		frame.setVisible(true);
		frame.setAlwaysOnTop(false);
	}
}
