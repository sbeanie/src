package sbeanieAPI;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.wrappers.node.Item;

public class interactObject extends Node {
	
	public static int obj;
	public static String choice;
	public static int objectsInteracted;
	
	public static void setOptions(int o, String s){
		obj = o;
		choice = s;
	}
	
	 public void execute() {
        status.Status = "Burying Bones!";
        if(Inventory.getItem(obj)!=null)
                for (Item i : Inventory.getItems()) {
                    if (i.getName().contains(choice)) {
                        i.getWidgetChild().click(true);
                        sleep(300);
                        status.Status = "Burying Bones!";
                        objectsInteracted ++;
                    }
                }		
	 }
	
	public boolean activate(){
		return Inventory.isFull();
	}
}
