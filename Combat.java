package com.chapter5.Game;

import javax.swing.*;
import java.util.Random;

public class Combat
{
	public static Object[] combatOptions = { "Attack", "Drink Health Potion", "Run!" },
			lootOptions = { "Loot the enemy", "Leave the enemy" }, enemies = { "Zombie", "Thief", "Wizard" };
	public static int playerHealth = 100, enemHealth, damDealt, numHealthPotion = 3, 
			healthPotHealAmount, maxEnemyHealth = 25, maxPlayerHealth = 100, goldCount, goldGained, healthPotChance;
	public static boolean running = true;
	public static String enemy;
	public static JPanel panel;
	public static JLabel label;
	public static Random rand = new Random();

	public Combat()
	{

	}

	public static void playerAttack(int playDamRange)
	{
		damDealt = rand.nextInt(playDamRange);

		enemHealth -= damDealt;
		Adventure.display("You hit for " + damDealt + " HP!\nThe enemy has " + enemHealth + " HP remaining!");
	}

	public static void enemyAttack(int enemyDamRange)
	{
		damDealt = rand.nextInt(enemyDamRange);

		playerHealth -= damDealt;
		Adventure.display("You were hit for " + damDealt + "HP!\nYou have " + playerHealth + " HP remaining!");
	}

	public static void drinkHealthPotion()
	{
		if (numHealthPotion == 0)
		{
			Adventure.display("You have no health potions remaining! Turn and fight!");
			return;
		}
		if (playerHealth < 25)
			healthPotHealAmount = 50;
		else
			healthPotHealAmount = playerHealth / 3;

		if (playerHealth + healthPotHealAmount > maxPlayerHealth)
		{
			healthPotHealAmount = maxPlayerHealth - playerHealth;
			playerHealth = maxPlayerHealth;

		} else
			playerHealth += healthPotHealAmount;
		numHealthPotion--;
		Adventure.display("You heal for " + healthPotHealAmount + "!\nYou heal to " + playerHealth + "!");

	}

	public static void loot(int maxGold)
	{
		// Gold
		goldGained = (int) (Math.random() * maxGold);
		goldCount += goldGained;
		Adventure.display("You gained " + goldGained + " gold!\nYou now have " + goldCount + " gold!");

	}

	public static void healthPotionChance()
	{
		if ((int) Math.random() * (100) < healthPotChance)
		{
			numHealthPotion++;
			Adventure.display(" # The " + enemy + " dropped a health potion! # \n#  You now have "
					+ numHealthPotion + " health potion(s). # ");
			healthPotChance = 10;
		} else
			healthPotChance += 10;
	}
	
	public static String getEnemies(int numEnemies)
	{
		return "Zombie" + " rider";
	}

	public static void fistCombat()
	{
		while (running)
		{
			// Game variables
			String[] enemies = { getEnemies(5) };
			panel = new JPanel();
			label = new JLabel();
			label.setText("What do you want to do?");

			int combatChosen, lootChosen;

			enemHealth = rand.nextInt(maxEnemyHealth);

			enemy = enemies[(int) Math.random() * (enemies.length)];
			Adventure.display("\t " + enemy + " appeared! \n");
			// # Skeleton has appeared! #

			while (enemHealth > 0)
			{

				// label.setText("Your HP: " + playerHealth + "<b> \n " + enemy + "'s HP: " +
				// enemHealth + "</b> \n What do you want to do");
				label.setText(String.format("<html>Your HP: %d<br>%s's HP: %d<br>What do you want to do?</html>",
						playerHealth, enemy, enemHealth));
				panel.add(label);
				combatChosen = JOptionPane.showOptionDialog(null, panel, "Combat", JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.PLAIN_MESSAGE, null, combatOptions, null);

				switch (combatChosen)
				{
				case 0:
					playerAttack(8);
					enemyAttack(6);

					if (playerHealth < 1)
					{
						Adventure.display("You have taken too much damage, you are too weak to go on!");
						break;
					}
					break;
				case 1:
					drinkHealthPotion();
					break;
				case 2:
					Adventure.display("You run away from the " + enemy + "!");
					running = false;
					break;

				}

				if (playerHealth < 1)
				{
					Adventure.display("You limp out of the dungeon, weak from battle.");

				}

				if (enemHealth <= 0)
				{

					JOptionPane.showMessageDialog(null,
							"# " + enemy + " was defeated! #\n# You have " + playerHealth + " HP left. #");
					healthPotionChance();
					LevelSystem.giveEXP(5);

					lootChosen = Adventure.displayOption("Loot", "What do you want to do?", lootOptions);
					
					switch (lootChosen)
					{
					case 0:
						loot(15);
						break;
					case 1:
						Adventure.display("You leave the slain creature behind!");
						break;
					}

				}
			}
			break;
		}

	}

	public static void fighterCombat()
	{
		while (running)
		{
			// Game variables
			String[] enemies = { "Rhyder" }, attacks = { "Swipe", "Slash", "Uppercut", "Jab", "Cancel" };

			panel = new JPanel();
			label = new JLabel();
			label.setText("What do you like to do?");

			int combatChosen, lootChosen, fighterattacks;

			enemHealth = rand.nextInt(maxEnemyHealth);

			enemy = enemies[(int) Math.random() * (enemies.length)];
			Adventure.display(enemy + " appeared!");
			// # Skeleton has appeared! #

			while (enemHealth > 0)
			{
				label.setText(String.format("<html>Your HP: %d<br>%s's HP: %d<br>What do you want to do?</html>",
						playerHealth, enemy, enemHealth));
				panel.add(label);

				combatChosen = JOptionPane.showOptionDialog(null, panel, "Combat", JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.PLAIN_MESSAGE, null, combatOptions, null);

				switch (combatChosen)
				{
				case 0:
					label.setText("Choose your attack!");
					panel.add(label);
					fighterattacks = JOptionPane.showOptionDialog(null, panel, "Attacks",
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, attacks, null);
					switch (fighterattacks)
					{
					case 0:// Swipe
						playerAttack(12);
						enemyAttack(6);
						break;
					case 1:// Slash
						playerAttack(12);
						enemyAttack(6);
						break;
					case 2:// Uppercut
						playerAttack(10);
						enemyAttack(6);
						break;
					case 3:// Jab
						playerAttack(10);
						enemyAttack(6);
						break;
					case 4:// Cancel to go back to choose options

						break;
						
					}
					
					if (playerHealth < 1)
					{
						Adventure.display("You have taken too much damage, you are too weak to go on!");
						running = false;
						break;
					}
					break;
				case 1:
					drinkHealthPotion();
					break;
				case 2:
					Adventure.display("You run away from the " + enemy + "!");
					running = false;
					break;

				}

				if (playerHealth < 1)
				{
					Adventure.display("You limp out of the dungeon, weak from battle.");

				}

				if (enemHealth <= 0)
				{

					Adventure.display("# " + enemy + " was defeated! #\n# You have " + playerHealth + " HP left. #");
					healthPotionChance();
					LevelSystem.giveEXP(25);

					lootChosen = Adventure.displayOption("Loot", "What do you want to do?", lootOptions);
					
					switch (lootChosen)
					{
					case 0:
						loot(50);
						break;
					case 1:
						Adventure.display("You leave the slain creature behind!");
						break;
					}

				}
			}
			break;
		}
	}

	public static void archerCombat()
	{
		while (running)
		{
			// Game variables
			String[] enemies = { "Rhyder" }, attacks = { "Shoot Longbow", "Use shortsword", "Use dagger", "Cancel" };
			panel = new JPanel();
			label = new JLabel();
			label.setText("What do you like to do?");

			int combatChosen, lootChosen, archerattacks;

			enemHealth = rand.nextInt(maxEnemyHealth);

			enemy = enemies[(int) Math.random() * (enemies.length)];
			Adventure.display(enemy + " appeared!");
			// # Skeleton has appeared! #

			while (enemHealth > 0)
			{
				label.setText(String.format("<html>Your HP: %d<br>%s's HP: %d<br>What do you want to do?</html>",
						playerHealth, enemy, enemHealth));
				panel.add(label);

				combatChosen = JOptionPane.showOptionDialog(null, panel, "Combat", JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.PLAIN_MESSAGE, null, combatOptions, null);

				switch (combatChosen)
				{
				case 0:
					label.setText("Choose your attack!");
					panel.add(label);
					archerattacks = JOptionPane.showOptionDialog(null, panel, "Attacks",
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, attacks, null);
					switch (archerattacks)
					{
					case 0:// Longbow
						playerAttack(20);
						enemyAttack(12);
						break;
					case 1:// Shortsword
						playerAttack(12);
						enemyAttack(8);
						break;
					case 2:// Dagger
						playerAttack(8);
						enemyAttack(8);
						break;
					case 3:// Cancel to go back to choose options

						break;
					}

					if (playerHealth < 1)
					{
						Adventure.display("You have taken too much damage, you are too weak to go on!");
						running = false;
						break;
					}
					break;
				case 1:
					drinkHealthPotion();
					break;
				case 2:
					Adventure.display("You run away from the " + enemy + "!");
					running = false;
					return;
				}
				if (playerHealth < 1)
				{
					Adventure.display("You limp out of the dungeon, weak from battle.");

				}

				if (enemHealth <= 0)
				{

					Adventure.display("# " + enemy + " was defeated! #\n# You have " + playerHealth + " HP left. #");
					healthPotionChance();
					LevelSystem.giveEXP(25);

					lootChosen = Adventure.displayOption("Loot", "What do you want to do?", lootOptions);
					
					switch (lootChosen)
					{
					case 0:
						loot(50);
						break;
					case 1:
						Adventure.display("You leave the slain creature behind!");
						break;
					}

				}
			}
			break;
		}
	}

	public static void mageCombat()
	{
		while (running)
		{
			// Game variables
			String[] enemies = { "Rhyder" },
					attacks = { "Throw Fireball", "Electrocute " + enemy, "Magic Missile", "Cancel" };
			panel = new JPanel();
			label = new JLabel();
			label.setText("What do you like to do?");

			int combatChosen, lootChosen, mageAttacks;

			enemHealth = rand.nextInt(maxEnemyHealth);

			enemy = enemies[(int) Math.random() * (enemies.length)];
			Adventure.display(enemy + " has appeared!");
			// # Skeleton has appeared! #

			while (enemHealth > 0)
			{
				label.setText(String.format("<html>Your HP: %d<br>%s's HP: %d<br>What do you want to do?</html>",
						playerHealth, enemy, enemHealth));
				panel.add(label);

				combatChosen = JOptionPane.showOptionDialog(null, panel, "Combat", JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.PLAIN_MESSAGE, null, combatOptions, null);

				switch (combatChosen)
				{
				case 0:
					label.setText("Choose your attack!");
					panel.add(label);
					mageAttacks = JOptionPane.showOptionDialog(null, panel, "Attacks", JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.PLAIN_MESSAGE, null, attacks, null);
					switch (mageAttacks)
					{
					case 0:// Fireball
						playerAttack(20);
						enemyAttack(12);
						break;
					case 1:// Electrocute
						playerAttack(12);
						enemyAttack(8);
						break;
					case 2:// Magic Missile
						playerAttack(8);
						enemyAttack(8);
						break;
					case 3:// Cancel to go back to choose options

						break;
					}

					if (playerHealth < 1)
					{
						Adventure.display("You have taken too much damage, you are too weak to go on!");
						running = false;
						break;
					}
					break;
				case 1:
					drinkHealthPotion();
					break;
				case 2:
					Adventure.display("You run away from the " + enemy + "!");
					running = false;
					break;

				}

				if (playerHealth < 1)
				{
					Adventure.display("You limp out of the dungeon, weak from battle.");

				}

				if (enemHealth <= 0)
				{

					Adventure.display("# " + enemy + " was defeated! #\n# You have " + playerHealth + " HP left. #");
					healthPotionChance();
					LevelSystem.giveEXP(25);
					
					lootChosen = Adventure.displayOption("Loot", "What do you want to do?", lootOptions);
					
					switch (lootChosen)
					{
					case 0:
						loot(50);
						break;
					case 1:
						Adventure.display("You leave the slain creature behind!");
						break;
					}

				}
			}
			break;
		}
	}
}
