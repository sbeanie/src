package sbeanieAPI;

import java.util.ArrayList;

import javafx.scene.layout.TilePane;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.GroundItems;
import org.powerbot.game.api.wrappers.Area;
import org.powerbot.game.api.wrappers.Tile;
import org.powerbot.game.api.wrappers.node.GroundItem;
import org.powerbot.core.script.util.Random;
import sun.util.logging.PlatformLogger;

public class noObjectInScene extends Node{
	
	public static Tile runLoc;
    public static Tile[] runLocs;
    public static boolean randomLoc;
	public static int obj;
	public static int runEnergy;
	public static Area AREA;
	public static Tile[] tiles;



    public static int plane = -1;
    public static Tile noDestination = new Tile(-1, -1, -1);
	
	public static void setOptions(int objid, Tile returnLoc, Area ar){
		obj = objid;
		runLoc = returnLoc;
		AREA = ar;
	}
    public static void setOptions(int objid, Tile[] returnLoc, Area ar){
        obj = objid;
        runLocs = returnLoc;
        AREA = ar;
    }
	public static void setOptions(int objid, Tile returnLoc, int energy, Area ar){
		obj = objid;
		runLoc = returnLoc;
		runEnergy = energy;
		AREA = ar;
	}
    public static void setOptions(int objid, Tile[] returnLoc, int energy, Area ar){
        obj = objid;
        runLocs = returnLoc;
        runEnergy = energy;
        AREA = ar;
    }
    public static void setOptions(int objid, Area ar){
        obj = objid;
        AREA = ar;
        randomLoc=true;
    }
    public static void setOptions(int objid, int energy, Area ar){
        obj = objid;
        AREA = ar;
        runEnergy = energy;
        randomLoc=true;
    }
	public static void setOptions(int objid, int energy, Tile[] Tiles){
		obj = objid;
		tiles = Tiles;
		runEnergy = energy;
		randomLoc=true;
	}


	public void execute() {
		if(!Walking.isRunEnabled() && Walking.getEnergy() > runEnergy)Walking.setRun(true);
        if(randomLoc){
	        if(AREA != null){
		        status.Status = "Running back to AREA!";
		        try{
                    runLoc = AREA.getTileArray()[Random.nextInt(0, AREA.getTileArray().length)];
		            sleep(400,800);
		        }catch(NullPointerException e){}
	        }
	        if(tiles != null){
		        status.Status = "Running back to Tiles!";
		        try{
		            runLoc = tiles[Random.nextInt(0, tiles.length)];
		            sleep(400,800);
		        }catch(NullPointerException e){}
	        }
        }
		if(tilesArrayContains.Location(tiles, Walking.getDestination().getLocation())){
			while(Players.getLocal().isMoving())sleep(500);
			Walking.findPath(runLoc).traverse();
		}
		if(!tilesArrayContains.Location(tiles, Walking.getDestination().getLocation())){
			Walking.findPath(runLoc).traverse();
		}
	}
	@Override
	public boolean activate() {
		GroundItem OBJECT = GroundItems.getNearest(obj);
		if(AREA != null){
			return (OBJECT == null) || (!OBJECT.isOnScreen()) || (!AREA.contains(Players.getLocal().getLocation())) || ((!AREA.contains(Walking.getDestination().getLocation())) && (!Walking.getDestination().getLocation().equals(noDestination)));
		}
		return (OBJECT == null) || (!OBJECT.isOnScreen()) || (!(tilesArrayContains.Location(tiles, Players.getLocal().getLocation())))
				|| ((!tilesArrayContains.Location(tiles, Walking.getDestination().getLocation())) && (!Walking.getDestination().getLocation().equals(noDestination)));
	}
}
