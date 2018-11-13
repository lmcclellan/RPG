package com.chapter5.Game;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("unused")
public class Adventure
{
	public static int classchosen, timberdalechosen, displayint, answer;
	public static String playerClass, name, input;
	public static JPanel panel = new JPanel();
	public static JLabel label = new JLabel();
	public static JFrame frame;

	public static Object[] classes = { "Fighter", "Archer", "Mage" }, timberdale = { "Walk Around", "Go to town hall", "Leave town" };
	// public static ;

	public static void main(String[] args)
	{
		int classchosen, timberdalechosen;

		display("My First RPG Adventure");
		display("You are wandering around a forest when you hear a noise...");

		// Combat.fistCombat();

		display("You keep wandering around the forest until\nyou come across a path that leads to a\n\ttown surrounded by a wooden wall...");

		name = displayInput("\n\tA man comes up to you and asks who you are and\n\twhat your name is...");

		display("\tStranger: Hello there " + name + "! My name is Taam and I am the mayor of this town."); // Taam pronounced Tom

		display("Taam: We could use some help defending the town of Timberlane, and you look like you could be a good soldier.");

		// 3 buttons to allow player to choose class
		classchosen = displayOption("Choose your class!", "Pick a class", classes);

		switch (classchosen)// Player class that is used to generate first combat
		{
		case 0:
			playerClass = "Fighter";
			break;
		case 1:
			playerClass = "Archer";
			break;
		case 2:
			playerClass = "Mage";
			break;
		}

		display("You chose " + playerClass + "!\nTaam: Good choice. Now lets see how you are in combat");

		switch (playerClass)// Combat to show user what options they will have when attacking
		{
		case "Fighter":
			Combat.fighterCombat();
			break;

		case "Archer":
			Combat.archerCombat();
			break;

		case "Mage":
			Combat.mageCombat();
			break;

		}

		display("\n\tNot bad...");

		display("Two years have gone by and you have trained\nand defended the town of Timberdale from enemies...");

		timberdalechosen = displayOption("Timberdale", "What do you want to do?", timberdale);// Allows player to choose what they want to do in the town of Timberdale

		switch (timberdalechosen)
		{
		case 0:// bring up list of buildings in town
			Timberdale.TimberdaleTown();
			break;
		case 1:// Start first quest
			QuestOne.startQuest();
			break;
		case 2:// leave town, if first quest has been completed, if not, bring up first quest

			break;
		}

	}

	public static void display(String str)// Used to not have to type out JOptionPane, call in this class by display(string), others by Adventure.display(string)
	{
		JOptionPane.showMessageDialog(null, str);

	}

	public static int displayOption(String title, String text, Object[] o)// called in this class by displayOption(string, string, object) and others by Adventure.displayOption(string,string, object)
	{
		label.setText(text);
		panel.add(label);

		displayint = JOptionPane.showOptionDialog(null, panel, title, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, o, null);
		return displayint;
	}
	public static int displayConfirm(String text)
	{
		answer = JOptionPane.showConfirmDialog(null, text);
		return answer;
	}
	public static String displayInput(String text)
	{
		String response;
		response = JOptionPane.showInputDialog(text);
		return response;
	}
}
