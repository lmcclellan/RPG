package com.chapter5.Game;

public class LevelSystem
{
	public static int playerLevel = 0, experience = 0, expRequired = 20;

	public static void hasEnoughExp()
	{
		if (experience >= expRequired)
		{
			playerLevel++;
			expRequired = (int) (expRequired * 1.5);
			Combat.maxPlayerHealth += 25;
			Adventure.display("You have reached level " + playerLevel + 
							  "!\nMaximum health increased to " + Combat.maxPlayerHealth + "!" +
							  "\nExperience required for next level: " + expRequired + " experience!");
		}
	}

	public static void giveEXP(int EXPRange)
	{
		int givenEXP = (int) (Math.random() * EXPRange);
		;
		experience += givenEXP;
		Adventure.display("You gained " + givenEXP + " experience.\nYou have " + experience + " experience!");
		hasEnoughExp();
	}

}
