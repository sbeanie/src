package sbeanieAPI;

import javafx.scene.layout.TilePane;
import org.powerbot.game.api.wrappers.Area;
import org.powerbot.game.api.wrappers.Tile;

public class areasToArray {
    public static Area AREA;
    public static Area AREA2;


    static Tile[] tileListFirst;
    static Tile[] tileListSecond;
    static int tileListFirstLength;
    static int tileListSecondLength;
    static Tile[] tileListFinal;
	static int j = 1;

    public static Tile[] addArea(Area ar, Area ar2){
        AREA = ar;
        AREA2 = ar2;

        tileListFirst = AREA.getTileArray();
        tileListFirstLength = tileListFirst.length;

        tileListSecond = AREA2.getTileArray();                              //Convert the second Area to an array, get the length of this array and print each
        tileListSecondLength = tileListSecond.length;                       //tile to console

	    tileListFinal= new Tile[tileListFirstLength + tileListSecondLength];//Set the length of the final array to the sum of the first and second arrays

        for(int i = 1; i < tileListFirstLength; i++){                       //Enter the first tile array into the file tile array! :)
            tileListFinal[i]= tileListFirst[i];
        }

        for(int i = tileListFirstLength; i < tileListFirstLength + tileListSecondLength - 1; i++){
            j++;                                                 //Do the same for the second tile array!
            if(j != tileListSecondLength){
	            if(!tilesArrayContains.Location(tileListFinal, tileListSecond[j])){
	                tileListFinal[i]= tileListSecond[j];
	            }
            }
        }
        return tileListFinal;
    }
}
