package sbeanieAPI;

import org.powerbot.core.script.job.state.Node;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class jFrame extends Node {
	static long startTimeLabel;
	static int expStartLabel;
	public static String timeRunning;
	public static String timeToLevel;
	public static int expGained;
	public static int expPerHour;
	public static int expToGo;
	public static int levelsGained;
	public static JLabel timeRunningLabel = new JLabel("");
	public static JLabel expGainedLabel = new JLabel("");
	public static JLabel expPerHourLabel = new JLabel("");
	public static JLabel timeToLevelLabel = new JLabel("");
	public static JLabel levelsGainedLabel = new JLabel("");
	public static JLabel expToGoLabel = new JLabel("");
	public static JLabel statusLabel = new JLabel("");
	static boolean bootedUp = false;


	public static JButton refresh = new JButton("Refresth Stats!");
	public static JFrame f = new JFrame("RSBot Script Information");
	static Container content;

	private static void refreshStats(){
		if(!bootedUp){
			content.add(timeRunningLabel);
			content.add(expGainedLabel);
			content.add(expPerHourLabel);
			content.add(expToGoLabel);
			content.add(timeToLevelLabel);
			content.add(levelsGainedLabel);
			content.add(statusLabel);
			bootedUp = true;
		}
		timeRunningLabel.setText("Time Running: " + timeRunning);
		expGainedLabel.setText("Exp Gained: " + expGained);
		expPerHourLabel.setText("Exp Per Hour: "+ expPerHour);
		expToGoLabel.setText("Exp to go: " + expToGo);
		timeToLevelLabel.setText("Time to level: " + timeToLevel);
		levelsGainedLabel.setText("Levels gained: " + levelsGained);
		statusLabel.setText("Status: " + status.Status);
		content.validate();
		content.repaint();
	}

	public static void setOptions(int textFieldNumber, long startTime, int expStart){
		startTimeLabel = startTime;
		expStartLabel = expStart;
		f.setSize(400, textFieldNumber * 30 + 100);
		content = f.getContentPane();
		content.setBackground(Color.white);
		content.setLayout(new FlowLayout());
		refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshStats();
			}
		});
		f.add(refresh);
		f.setVisible(true);
	}


	public void execute(){
	}
	public boolean activate(){
		return true;
	}

	public static String formatTime(final long milliseconds) {
		final long t_seconds = milliseconds / 1000;
		final long t_minutes = t_seconds / 60;
		final long t_hours = t_minutes / 60;
		final long seconds = t_seconds % 60;
		final long minutes = t_minutes % 60;
		final long hours = t_hours % 500;
		return hours + ":" + minutes + ":" + seconds;
	}
}
