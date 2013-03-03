package scripts;

import org.powerbot.core.event.listeners.PaintListener;
import org.powerbot.core.script.ActiveScript;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.core.script.job.state.Tree;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.tab.Skills;
import org.powerbot.game.api.wrappers.Area;
import org.powerbot.game.api.wrappers.Tile;
import sbeanieAPI.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Manifest(authors = { "Sbeanie" }, name = "Bone Burier", description = "Picks up bones and buries them!", version = 1.0)
public class BoneBurier extends ActiveScript implements PaintListener{
	
	private int objectsNotToPickUp[] = {2132,1739,1119};
	private int startPrayerLevel;
	private int expgained;
	private int expToGo;
	private int expPerHour;
	private int levelsGained;
	private String timeToLevel;
	private String timeRunning;
	private int expstart;
	public long startTime;
	public static int objectsPickedUp;
	Area BONESAREA = new Area(new Tile(3253, 3255, 0), new Tile(3265, 3296, 0));
    Area BONESAREA2 = new Area(new Tile(3244,3280,0), new Tile(3265,3296,0));
    Tile[] FINALTILESARRAY;


    private final List<Node> jobsCollection = Collections.synchronizedList(new ArrayList<Node>());
    private Tree jobContainer = null;

    public synchronized final void provide(final Node... jobs) {
        for (final Node job : jobs) {
            if(!jobsCollection.contains(job)) {
                jobsCollection.add(job);
            }
        }
        jobContainer = new Tree(jobsCollection.toArray(new Node[jobsCollection.size()]));
    }
    public int loop() {
        if (jobContainer != null) {
            final Node job = jobContainer.state();
            if (job != null) {
                jobContainer.set(job);
                getContainer().submit(job);
                job.join();
            }
        }
        return 25;
    }


	public void onStart() {
		startPrayerLevel = Skills.getLevel(Skills.PRAYER);
		startTime = System.currentTimeMillis();
		expstart = Skills.getExperience(Skills.PRAYER);

        FINALTILESARRAY = areasToArray.addArea(BONESAREA, BONESAREA2);

		noObjectInScene.setOptions(526, 45, FINALTILESARRAY);
		provide (new noObjectInScene());
		
		pickUpObject.setOptions(526,"Take","Bones", true);
		provide (new pickUpObject());
		
		drop.setOptions(objectsNotToPickUp, 526, (28 - Inventory.getCount()));
		provide (new drop());
		
		interactObject.setOptions(526, "Bones");
		provide (new interactObject());

		jFrame.setOptions(1, startTime, expstart);
		provide (new jFrame());
	
	}

	//Made using Easel!
	
    private final Color color1 = new Color(255, 0, 0, 27);
    private final Color color2 = new Color(255, 255, 255);
    private final Color color3 = new Color(255, 0, 0);
    private final Color color4 = new Color(255, 0, 51);
	private final Color color5 = new Color(255, 0, 0, 50);

    private final BasicStroke stroke1 = new BasicStroke(1);

    private final Font font1 = new Font("Arial", 0, 9);
        
        public void onRepaint(Graphics g1) {
            Graphics2D g = (Graphics2D)g1;
            g.setColor(color1);
            g.fillRect(8, 250, 122, 124);
            g.setColor(color2);
            g.setStroke(stroke1);
            g.drawRect(8, 250, 122, 124);
            g.setFont(font1);
            g.setColor(color3);
            objectsPickedUp = interactObject.objectsInteracted;
            g.drawString("Bones Buried: " + objectsPickedUp , 13, 264);
            g.setColor(color4);

	        expgained = Skills.getExperience(Skills.PRAYER) - expstart;
	        jFrame.expGained = expgained;
            g.drawString("Experience Gained: " + (expgained - 1), 13, 280);

            g.setColor(color3);
	        timeRunning = formatTime(System.currentTimeMillis() - startTime);
	        jFrame.timeRunning = timeRunning;
            g.drawString("Time Running:  " + timeRunning, 13, 294);

	        expPerHour = exp.getPerHour(expgained, startTime);
	        jFrame.expPerHour = expPerHour;
            g.drawString("Exp per Hour: " + expPerHour, 13, 308);

	        expToGo = exp.expToGo("PRAYER");
	        jFrame.expToGo = expToGo;
            g.drawString("Exp to go: " + expToGo, 13, 322);

	        timeToLevel = exp.timeToLevel(expgained, startTime, "PRAYER");
	        jFrame.timeToLevel = timeToLevel;
            g.drawString("Time Until Level: " + exp.timeToLevel(expgained, startTime, "PRAYER"), 13, 336);

	        levelsGained = Skills.getLevel(Skills.PRAYER) - startPrayerLevel;
	        jFrame.levelsGained = levelsGained;
            g.drawString("Levels Gained: " + levelsGained, 13, 350);

	        g.drawString("Status: " + status.Status, 13, 364);
            
            //Mouse Cursor
            g.setColor(Color.YELLOW);
            g.drawLine(Mouse.getX() - 5, Mouse.getY() - 5, Mouse.getX() + 5, Mouse.getY() + 5);
            g.drawLine(Mouse.getX() - 5, Mouse.getY() + 5, Mouse.getX() + 5, Mouse.getY() - 5);

	        //Draw Area to Screen
	        try{
				for (int i = 1; i < FINALTILESARRAY.length; i++) {
					Tile t = FINALTILESARRAY[i];
					if (t.isOnScreen()) {
						g.setColor(color5);
						g.drawPolygon(t.getBounds()[0]);
						g.fillPolygon(t.getBounds()[0]);
		            }
				}
	        }catch(NullPointerException e){

	        }
        }
	public String formatTime(final long milliseconds) {
		final long t_seconds = milliseconds / 1000;
		final long t_minutes = t_seconds / 60;
		final long t_hours = t_minutes / 60;
		final long seconds = t_seconds % 60;
		final long minutes = t_minutes % 60;
		final long hours = t_hours % 500;
	return hours + ":" + minutes + ":" + seconds;
	}
}