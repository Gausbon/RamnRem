package windows;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import maps.Maps;
import data.Data;

public class PlayPanel extends JPanel{
	final static int WIDTH = 1280;
	final static int HEIGHT = 720;
	final static int MATERIALCOUNT = 26;
	private int[][] orimaps = null;
	private int[][] origrass = null;
	
	JLabel bgLabel = new JLabel("");
	JLabel Label1 = new JLabel("");
	JLabel Label2 = new JLabel("");
	JLabel Label3 = new JLabel("");
	public PlayPanel () {}
	public PlayPanel (int i) {
		//URL mapsurl = Maps.class.getResource("/maps/" + ".txt");
		try{
			//Maps curMaps = new Maps(mapsurl.toString().substring(5));
			Maps curMaps = new Maps("E:/Ohters/java/RamnRem/bin/maps/1.txt");
			Data data = new Data(curMaps);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ImageIcon bgImage = new ImageIcon(PlayPanel.class.getResource("/images/bg/bg2.png"));
		bgLabel.setIcon(bgImage);
		bgLabel.setBounds(0, 0, WIDTH, HEIGHT);
		this.add(bgLabel);
	}
}