package sbeanieAPI;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.tab.Skills;

public class exp extends Node {
	static float millisUntilLevel;
	static int expPerHour;
	static int nextLevel;
	static int expToGo;
	
	public static String timeToLevel(int gained, long startTime, String skillChosen){
		
		if(skillChosen.equals("PRAYER")){
			nextLevel = Skills.getLevel(Skills.PRAYER) + 1;
			expToGo = Skills.getExperienceToLevel(Skills.PRAYER, nextLevel);
		}else
		if(skillChosen.equals("WOODCUTTING")){
			nextLevel = Skills.getLevel(Skills.WOODCUTTING) + 1;
			expToGo = Skills.getExperienceToLevel(Skills.WOODCUTTING, nextLevel);
		}else
		if(skillChosen.equals("ATTACK")){
			nextLevel = Skills.getLevel(Skills.ATTACK) + 1;
			expToGo = Skills.getExperienceToLevel(Skills.ATTACK, nextLevel);
		}else
		if(skillChosen.equals("DEFENSE")){
			nextLevel = Skills.getLevel(Skills.DEFENSE) + 1;
			expToGo = Skills.getExperienceToLevel(Skills.DEFENSE, nextLevel);
		}else
		if(skillChosen.equals("STRENGTH")){
			nextLevel = Skills.getLevel(Skills.STRENGTH) + 1;
			expToGo = Skills.getExperienceToLevel(Skills.STRENGTH, nextLevel);
		}else
		if(skillChosen.equals("CONSTITUTION")){
			nextLevel = Skills.getLevel(Skills.CONSTITUTION) + 1;
			expToGo = Skills.getExperienceToLevel(Skills.CONSTITUTION, nextLevel);
		}else
		if(skillChosen.equals("MAGIC")){
			nextLevel = Skills.getLevel(Skills.MAGIC) + 1;
			expToGo = Skills.getExperienceToLevel(Skills.MAGIC, nextLevel);
		}else
		if(skillChosen.equals("COOKING")){
			nextLevel = Skills.getLevel(Skills.COOKING) + 1;
			expToGo = Skills.getExperienceToLevel(Skills.COOKING, nextLevel);
		}else
		if(skillChosen.equals("FLETCHING")){
			nextLevel = Skills.getLevel(Skills.FLETCHING) + 1;
			expToGo = Skills.getExperienceToLevel(Skills.FLETCHING, nextLevel);
		}else
		if(skillChosen.equals("FISHING")){
			nextLevel = Skills.getLevel(Skills.FISHING) + 1;
			expToGo = Skills.getExperienceToLevel(Skills.FISHING, nextLevel);
		}else
		if(skillChosen.equals("FIREMAKING")){
			nextLevel = Skills.getLevel(Skills.FIREMAKING) + 1;
			expToGo = Skills.getExperienceToLevel(Skills.FIREMAKING, nextLevel);
		}else
		if(skillChosen.equals("CRAFTING")){
			nextLevel = Skills.getLevel(Skills.CRAFTING) + 1;
			expToGo = Skills.getExperienceToLevel(Skills.CRAFTING, nextLevel);
		}else
		if(skillChosen.equals("SMITHING")){
			nextLevel = Skills.getLevel(Skills.SMITHING) + 1;
			expToGo = Skills.getExperienceToLevel(Skills.SMITHING, nextLevel);
		}else
		if(skillChosen.equals("MINING")){
			nextLevel = Skills.getLevel(Skills.MINING) + 1;
			expToGo = Skills.getExperienceToLevel(Skills.MINING, nextLevel);
		}else
		if(skillChosen.equals("HERBLORE")){
			nextLevel = Skills.getLevel(Skills.HERBLORE) + 1;
			expToGo = Skills.getExperienceToLevel(Skills.HERBLORE, nextLevel);
		}else
		if(skillChosen.equals("AGILITY")){
			nextLevel = Skills.getLevel(Skills.AGILITY) + 1;
			expToGo = Skills.getExperienceToLevel(Skills.AGILITY, nextLevel);
		}else
		if(skillChosen.equals("THIEVING")){
			nextLevel = Skills.getLevel(Skills.THIEVING) + 1;
			expToGo = Skills.getExperienceToLevel(Skills.THIEVING, nextLevel);
		}else
		if(skillChosen.equals("SLAYER")){
			nextLevel = Skills.getLevel(Skills.SLAYER) + 1;
			expToGo = Skills.getExperienceToLevel(Skills.SLAYER, nextLevel);
		}else
		if(skillChosen.equals("FARMING")){
			nextLevel = Skills.getLevel(Skills.FARMING) + 1;
			expToGo = Skills.getExperienceToLevel(Skills.FARMING, nextLevel);
		}else
		if(skillChosen.equals("RUNECRAFTING")){
			nextLevel = Skills.getLevel(Skills.RUNECRAFTING) + 1;
			expToGo = Skills.getExperienceToLevel(Skills.DUNGEONEERING, nextLevel);
		}else
		if(skillChosen.equals("HUNTER")){
			nextLevel = Skills.getLevel(Skills.HUNTER) + 1;
			expToGo = Skills.getExperienceToLevel(Skills.HUNTER, nextLevel);
		}else
		if(skillChosen.equals("CONSTRUCTION")){
			nextLevel = Skills.getLevel(Skills.CONSTRUCTION) + 1;
			expToGo = Skills.getExperienceToLevel(Skills.CONSTRUCTION, nextLevel);
		}else
		if(skillChosen.equals("SUMMONING")){
			nextLevel = Skills.getLevel(Skills.SUMMONING) + 1;
			expToGo = Skills.getExperienceToLevel(Skills.SUMMONING, nextLevel);
		}else
		if(skillChosen.equals("DUNGEONEERING")){
			nextLevel = Skills.getLevel(Skills.DUNGEONEERING) + 1;
			expToGo = Skills.getExperienceToLevel(Skills.DUNGEONEERING, nextLevel);
		}
		if(gained != 0){
			expPerHour = (int) (gained * 3600000D / (System.currentTimeMillis() - startTime ));
			millisUntilLevel = (((float) expToGo / expPerHour) * 3600 * 1000);
			return timeToLevel(millisUntilLevel);
		}
		return "Unknown";
	}
	
	public static int getPerHour(final long value, long startTime) {
		return (int) (value * 3600000D / (System.currentTimeMillis() - startTime ));
	}
	
	public static int expToGo(String skillChosen){
		if(skillChosen.equals("PRAYER")){
			nextLevel = Skills.getLevel(Skills.PRAYER) + 1;
			expToGo = Skills.getExperienceToLevel(Skills.PRAYER, nextLevel);
		}else
		if(skillChosen.equals("WOODCUTTING")){
			nextLevel = Skills.getLevel(Skills.WOODCUTTING) + 1;
			expToGo = Skills.getExperienceToLevel(Skills.WOODCUTTING, nextLevel);
		}else
		if(skillChosen.equals("ATTACK")){
			nextLevel = Skills.getLevel(Skills.ATTACK) + 1;
			expToGo = Skills.getExperienceToLevel(Skills.ATTACK, nextLevel);
		}else
		if(skillChosen.equals("DEFENSE")){
			nextLevel = Skills.getLevel(Skills.DEFENSE) + 1;
			expToGo = Skills.getExperienceToLevel(Skills.DEFENSE, nextLevel);
		}else
		if(skillChosen.equals("STRENGTH")){
			nextLevel = Skills.getLevel(Skills.STRENGTH) + 1;
			expToGo = Skills.getExperienceToLevel(Skills.STRENGTH, nextLevel);
		}else
		if(skillChosen.equals("CONSTITUTION")){
			nextLevel = Skills.getLevel(Skills.CONSTITUTION) + 1;
			expToGo = Skills.getExperienceToLevel(Skills.CONSTITUTION, nextLevel);
		}else
		if(skillChosen.equals("MAGIC")){
			nextLevel = Skills.getLevel(Skills.MAGIC) + 1;
			expToGo = Skills.getExperienceToLevel(Skills.MAGIC, nextLevel);
		}else
		if(skillChosen.equals("COOKING")){
			nextLevel = Skills.getLevel(Skills.COOKING) + 1;
			expToGo = Skills.getExperienceToLevel(Skills.COOKING, nextLevel);
		}else
		if(skillChosen.equals("FLETCHING")){
			nextLevel = Skills.getLevel(Skills.FLETCHING) + 1;
			expToGo = Skills.getExperienceToLevel(Skills.FLETCHING, nextLevel);
		}else
		if(skillChosen.equals("FISHING")){
			nextLevel = Skills.getLevel(Skills.FISHING) + 1;
			expToGo = Skills.getExperienceToLevel(Skills.FISHING, nextLevel);
		}else
		if(skillChosen.equals("FIREMAKING")){
			nextLevel = Skills.getLevel(Skills.FIREMAKING) + 1;
			expToGo = Skills.getExperienceToLevel(Skills.FIREMAKING, nextLevel);
		}else
		if(skillChosen.equals("CRAFTING")){
			nextLevel = Skills.getLevel(Skills.CRAFTING) + 1;
			expToGo = Skills.getExperienceToLevel(Skills.CRAFTING, nextLevel);
		}else
		if(skillChosen.equals("SMITHING")){
			nextLevel = Skills.getLevel(Skills.SMITHING) + 1;
			expToGo = Skills.getExperienceToLevel(Skills.SMITHING, nextLevel);
		}else
		if(skillChosen.equals("MINING")){
			nextLevel = Skills.getLevel(Skills.MINING) + 1;
			expToGo = Skills.getExperienceToLevel(Skills.MINING, nextLevel);
		}else
		if(skillChosen.equals("HERBLORE")){
			nextLevel = Skills.getLevel(Skills.HERBLORE) + 1;
			expToGo = Skills.getExperienceToLevel(Skills.HERBLORE, nextLevel);
		}else
		if(skillChosen.equals("AGILITY")){
			nextLevel = Skills.getLevel(Skills.AGILITY) + 1;
			expToGo = Skills.getExperienceToLevel(Skills.AGILITY, nextLevel);
		}else
		if(skillChosen.equals("THIEVING")){
			nextLevel = Skills.getLevel(Skills.THIEVING) + 1;
			expToGo = Skills.getExperienceToLevel(Skills.THIEVING, nextLevel);
		}else
		if(skillChosen.equals("SLAYER")){
			nextLevel = Skills.getLevel(Skills.SLAYER) + 1;
			expToGo = Skills.getExperienceToLevel(Skills.SLAYER, nextLevel);
		}else
		if(skillChosen.equals("FARMING")){
			nextLevel = Skills.getLevel(Skills.FARMING) + 1;
			expToGo = Skills.getExperienceToLevel(Skills.FARMING, nextLevel);
		}else
		if(skillChosen.equals("RUNECRAFTING")){
			nextLevel = Skills.getLevel(Skills.RUNECRAFTING) + 1;
			expToGo = Skills.getExperienceToLevel(Skills.DUNGEONEERING, nextLevel);
		}else
		if(skillChosen.equals("HUNTER")){
			nextLevel = Skills.getLevel(Skills.HUNTER) + 1;
			expToGo = Skills.getExperienceToLevel(Skills.HUNTER, nextLevel);
		}else
		if(skillChosen.equals("CONSTRUCTION")){
			nextLevel = Skills.getLevel(Skills.CONSTRUCTION) + 1;
			expToGo = Skills.getExperienceToLevel(Skills.CONSTRUCTION, nextLevel);
		}else
		if(skillChosen.equals("SUMMONING")){
			nextLevel = Skills.getLevel(Skills.SUMMONING) + 1;
			expToGo = Skills.getExperienceToLevel(Skills.SUMMONING, nextLevel);
		}else
		if(skillChosen.equals("DUNGEONEERING")){
			nextLevel = Skills.getLevel(Skills.DUNGEONEERING) + 1;
			expToGo = Skills.getExperienceToLevel(Skills.DUNGEONEERING, nextLevel);
		}
		return expToGo;
	}
	
	
	public static String timeToLevel(final float milliseconds) {
		final long t_seconds = (long) milliseconds / 1000;
		final long t_minutes = t_seconds / 60;
		final long t_hours = t_minutes / 60;
		final long seconds = t_seconds % 60;
		final long minutes = t_minutes % 60;
		final long hours = t_hours % 500;
	return hours + ":" + minutes + ":" + seconds;
	}

	public void execute() {
		
		
	}
	
	public boolean activate(){
		return true;
	}
}
