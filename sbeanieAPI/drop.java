package sbeanieAPI;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.wrappers.node.Item;

public class drop extends Node {
	
	public static int object[];
	public static int setItem;
	public static int number;
	
	public static void setOptions(int obj[], int item, int amount){
		object = obj;
		setItem = item;
		number = amount;
	}
	

	public void execute(){
        status.Status = "Dropping junk!";
		for (Item i : Inventory.getItems()) {
			for (int id : object) {
				if ((i.getId() == id)) {
					status.Status = "Dropping junk!";
					i.getWidgetChild().interact("drop");
				}
			}
		}
	}
	
	
	public boolean activate(){
		return (!(Inventory.getCount(setItem) >= number) && Inventory.isFull());
	}
}
