package sbeanieAPI;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.GroundItems;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.wrappers.node.GroundItem;
import org.powerbot.core.script.util.Random;


public class pickUpObject extends Node{
	
		public static int obj;
		public static String s1;
		public static String s2;
		public static boolean s3;
		
		public static void setOptions(int objid, String choice, String option, Boolean cameraUp){
			obj = objid;
			s1 = choice;
			s2 = option;
			s3 = cameraUp;
		}
		public void execute() {
			GroundItem OBJECT = GroundItems.getNearest(obj);
				if(Players.getLocal().getAnimation() == -1){
					if(s3){
						if(Camera.getPitch() < 45){
							cameraSettings.setCameraUp();
						}
					}
					int i = Random.nextInt(0,2);
					if(i >= 1){
						Camera.turnTo(OBJECT, 25);
					}
					OBJECT.interact(s1, s2);
					status.Status = "Picking up Objects!";
					sleep(500,900);
					
				
				}
			
		}
		
		public boolean activate(){
			return !Inventory.isFull()  &&  Players.getLocal().getAnimation() == -1 && !Players.getLocal().isMoving();	
		}
		
	}
