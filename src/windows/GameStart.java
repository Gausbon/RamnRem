package windows;

import java.awt.EventQueue;
import java.util.Scanner;

public class GameStart {
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame gameStart = new MainFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
