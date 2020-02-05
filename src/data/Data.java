package data;

import maps.Maps;

public class Data {
	public static final int LEVELSIZE = 17;
	private int[][] curmaps = null;
	private int[][] curgrass = null;
	private int isgrasslevel = 0;
	
	public Data(Maps maps) {
		isgrasslevel = maps.getGrassLevel();
		if(isgrasslevel != 0) {
			curmaps = maps.getMap();
		}
	}
	
	public int[][] getGrass(){
		return curgrass;
	}
	
	public int[][] getMaps(){
		return curmaps;
	}
}
