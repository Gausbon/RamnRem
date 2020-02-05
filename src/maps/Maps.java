package maps;
import java.io.*;

public class Maps{
	
	/**
	/* tree = 1(TR), Ram = 2(RA), Rem = 3(RE)
	/* doorShut1 = 4(DS1), doorOpen1 = 5(DO1), doorShut2 = 6(DS2), doorOpen2 = 7(DO2)
	/* buttonUp1 = 8(BU1), buttonDown1 = 9(BD1), buttonUp2 = 10(BU2), buttonDown2 = 11(BD2)
	/* doorLocked1 = 12(DL1), doorUnlocked1 = 13(DU1), doorLocked2 = 14(DL2), doorUnlocked1 = 15(DU2)
	/* key1 = 16(K1), key2 = 17(K2)
	/* teleport1 = 18(T1), teleport2 = 19(T2)
	/* arrow1 = 20(A1), arrow2 = 21(A2), arrow3 = 22(A3), arrow4 = 23(A4)
	/* trapOn = 24(TON), trapOff = 25(TOF)
	/* ghost = 26(G)
	 **/
	
	public static final int TR = 1, RA = 2, RE = 3;
	public static final int DS1 = 4, DO1 = 5, DS2 = 6, DO2 = 7;
	public static final int BU1 = 8, BD1 = 9, BU2 = 10, BD2 = 11;
	public static final int DL1 = 12, DU1 = 13, DL2 = 14, DU2 = 15;
	public static final int K1 = 16, K2 = 17;
	public static final int T1 = 18, T2 = 19;
	public static final int A1 = 20, A2 = 21, A3 = 22, A4 = 23;
	public static final int TON = 24, TOF = 25;
	public static final int G = 26;
	
	public static final int LEVELSIZE = 17;
	private	final int[][] orimaps = new int[LEVELSIZE][LEVELSIZE];
	private	final int[][] origrass = new int[LEVELSIZE][LEVELSIZE];
	private int isgrasslevel = 0;
	private int isdarklevel = 0;
	private int minstep = 0;
	
	String[] tmp = null;
	BufferedReader br = null;
	FileInputStream fin = null;
	FileOutputStream fout = null;
	
	public Maps(String s) throws IOException {
		FileInputStream fin = new FileInputStream(new File(s));
		BufferedReader br = new BufferedReader(new FileReader(s));
		String line = br.readLine();
		
		tmp = line.split(" ");
		isgrasslevel = Integer.parseInt(tmp[0]);
		isdarklevel = Integer.parseInt(tmp[1]);
		minstep = Integer.parseInt(tmp[2]);
		
		for(int i = 0; i < LEVELSIZE; i++) {
			line = br.readLine();
			tmp = line.split(" ");
			for(int j = 0; j < LEVELSIZE; j++) {
				orimaps[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		
		if(isgrasslevel == 1) {
			for(int i = 0; i < LEVELSIZE; i++) {
				line = br.readLine();
				tmp = line.split(" ");
				for(int j = 0; j < LEVELSIZE; j++) {
					origrass[i][j] = Integer.parseInt(tmp[j]);
				}
			}
		}
		br.close();
		fin.close();
	}
	
	public int getDarkLevel() {
		return isdarklevel;
	}
	
	public int getGrassLevel() {
		return isgrasslevel;
	}
	
	public int getMinStep() {
		return minstep;
	}
	
	public int[][] getMap(){
		return orimaps;
	}
	
	public int[][] getGrass(){
		return origrass;
	}
}
	
