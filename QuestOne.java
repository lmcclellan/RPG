package com.chapter5.Game;

public class QuestOne
{
	public static boolean goblinsSaved;
	public static int answer;
	public QuestOne()
	{

		
	}
	public static void startQuest()
	{
		Adventure.display("You see Taam running towards you..");
		Adventure.display("Taam: Could you take this package up north to the Garen Outpost?");
		
		Adventure.display("You are on you way up to Garen Outpost, when you \nCome across a wagon that appears to be broken\nYou see a man staring at the wagon.");
		
		
	}
	public static boolean wereGoblinsSaved()
	{
		return goblinsSaved;
	}

}
