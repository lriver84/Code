package com.app;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.models.Game;

public class RandomGameSelector {
	private ArrayList<Game> gameList = new ArrayList<>();
	Scanner in = new Scanner(System.in);
	Random rng = new Random();
	Boolean gameOn = true;

	public void start() {
		System.out.println("Hello, Welcome too RGS the Random Game Selector.");
		System.out.println("You Must be very bored to have come here.");
		System.out.println("Please select what you would like to do today.");
	}

	public void choicemaker() {
		while (gameOn) {
			System.out.println("1. Make Game List");
			System.out.println("2. Select a Game");
			String temp = in.nextLine();
			try {
				int choice = Integer.parseInt(temp);
				if (choice == 1) {
					makeList();
				} else if (choice == 2) {
					try {
						selectGame();
						gameOn = false;
					} catch (Exception e) {
						System.out.println("You didn't make a list yet silly, i can't select from something that doesn't exist yet.");
						System.out.println("Or were trying to break me? thats not very nice.:'(");
					}
				}else {
					System.out.println("Oh no you didn't enter a correct choice there please enter either 1 or 2.");
				}
			} catch (Exception e) {
				System.out.println("Oops you didnt enter a correct number there please try again.");
			}
		}
		System.out.println("Have a Nice Day and Enjoy Your Game.");
	}

	public void makeList() {
		System.out.println("Enter The Name of the game you wish to add.");
		System.out.println("Enter Done when finished.");
		setGames();
	}

	public void setGames() {
		Boolean maker = true;
		while (maker) {
			String name = in.nextLine();
			if (name.toLowerCase().equals("done")) {
				maker = false;
			} else {
				Game game = new Game(name);
				gameList.add(game);
			}
		}
	}

	public void selectGame() {
		System.out.println("The Game You Should Play is " + gameList.get(rng.nextInt(gameList.size())).getName());
	}

	public static void main(String[] args) {
		RandomGameSelector app = new RandomGameSelector();
		app.start();
		app.choicemaker();

	}

}
