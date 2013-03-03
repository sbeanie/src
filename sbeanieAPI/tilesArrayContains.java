package sbeanieAPI;

import org.powerbot.game.api.wrappers.Area;
import org.powerbot.game.api.wrappers.Tile;
/**
 * Created with IntelliJ IDEA.
 * User: Tom
 * Date: 03/03/13
 * Time: 12:44
 * To change this template use File | Settings | File Templates.
 */
public class tilesArrayContains {
	public static boolean Location(Tile[] tiles, Tile tile){
		for(int i = 1; i < tiles.length; i++){
			try{
				if(tiles[i].equals(tile)){
					return true;
				}
			}catch(NullPointerException e){
				System.out.println("Error checking if player is within tiles");
			}
		}
		return false;
	}
}
