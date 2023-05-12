package view;

import controller.GogakController;

public class MainEntry {
	public static void main(String[] args) throws Exception {
		GogakController.connect();
		GogakController.menu();
	}
}