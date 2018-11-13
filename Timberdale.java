package com.chapter5.Game;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.*;



public class Timberdale
{
	public static JPanel panel;
	public static JLabel label;
	public Timberdale()
	{

	}

	public static void TimberdaleTown()
	{
		panel = new JPanel();
		label = new JLabel();
		Object[] TimberdaleOptions = {"Guild Hall", "Blacksmith","Armorsmith" , "Weaponsmith", "Temple" , "Lumber Yard", "The Prancing Pony Tavern", "Far Road Inn",  "Wagon Tackle"  };
		int timberDale;
		// System objects
		
		label.setText("Where do you want to go?");
		panel.add(label);
		timberDale = JOptionPane.showOptionDialog(null, panel, "Timberdale Buildings", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, TimberdaleOptions, null);
		switch(timberDale)
		{
		
		}
		
		Scanner in = new Scanner(System.in);

		System.out.println("\nYou are in Timberdale");
		System.out.println("Where do you want to go?");

		String input = in.nextLine();
		if (input.equals("1"))
		{
			System.out.println("\tYou go to the Guild Hall");
		}
		if (input.equals("2"))
		{
			System.out.println("\tYou go to the Blacksmith");
			TimberdaleBlacksmith timberdaleblacksmithObject = new TimberdaleBlacksmith();
			timberdaleblacksmithObject.TimberdaleBlackSmith();
		}
		if (input.equals("3"))
		{
			System.out.println("\tYou go to the Armorsmith");
			TimberdaleArmorsmith timberdalearmorsmithObject = new TimberdaleArmorsmith();
			timberdalearmorsmithObject.TimberdaleArmorSmith();
		}
		if (input.equals("4"))
		{
			System.out.println("\tYou go to the Weaponsmith");
			TimberdaleWeaponsmith timberdaleweaponsmithObject = new TimberdaleWeaponsmith();
			timberdaleweaponsmithObject.TimberdaleWeaponSmith();
		}
		if (input.equals("5"))
		{
			System.out.println("\tYou go to the Temple");
		}
		if (input.equals("6"))
		{
			System.out.println("\tYou go to the Lumber Yard");
		}
		if (input.equals("7"))
		{
			System.out.println("\tYou go to The Prancing Pony Tavern");
		}
		if (input.equals("8"))
		{
			System.out.println("\tYou go to the Far Road Inn");
		}
		if (input.equals("9"))
		{
			System.out.println("\tYou go to the Wagon Tackle");
		}
		in.close();
	}

}
