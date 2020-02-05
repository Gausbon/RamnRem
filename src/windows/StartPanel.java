package windows;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class StartPanel extends JPanel{
	public final int width;
	public final int height;
	public static final int ROW = 3, COLUMN = 5, LEN = ROW * COLUMN;
	public static final int ICONSIZE = 15;
	JLabel bgLabel = new JLabel("");
	JLabel iconLabel = new JLabel("");
	JLabel[] OffLabel = new JLabel[LEN];
	JLabel[] OnLabel = new JLabel[LEN];
	
	public StartPanel (int width, int height) {
		this.width = width;
		this.height = height;
		
		ImageIcon IconImage = new ImageIcon(StartPanel.class.getResource("/images/titlesmall.png"));
		iconLabel.setIcon(IconImage);
		iconLabel.setBounds(25, 0, IconImage.getIconWidth(), IconImage.getIconHeight());
		this.add(iconLabel);
		
		for (int i = 0; i < ROW; i++) {
			for(int j = 0; j < COLUMN; j++) {
				int num = i * COLUMN + j;
				OffLabel[num] = new JLabel("");
				OnLabel[num] = new JLabel("");
				ImageIcon Off = new ImageIcon(StartPanel.class.getResource("/images/level/"+ (num+1) + "off.png"));
				ImageIcon On = new ImageIcon(StartPanel.class.getResource("/images/level/"+ (num+1) + "on.png"));
				OffLabel[num].setIcon(Off);
				OffLabel[num].setBounds(350+j*180, 50+i*180, 128, 128);
				OnLabel[num].setIcon(null);
				OnLabel[num].setBounds(350+j*180, 50+i*180, 128, 128);
				this.add(OffLabel[num]);
				this.add(OnLabel[num]);
				SetListeners(OnLabel[num], OffLabel[num], On, Off);
			}
		}

		ImageIcon bgImage = new ImageIcon(StartPanel.class.getResource("/images/bg/bg1.png"));
		bgLabel.setIcon(bgImage);
		bgLabel.setBounds(0, 0, width, height);
		this.add(bgLabel);
	}
	
	public void SetListeners (JLabel On, JLabel Off, ImageIcon OnImage, ImageIcon OffImage) {
		Off.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent arg0){
				On.setIcon(OnImage);
				Off.setIcon(null);
			}
			public void mouseExited(MouseEvent arg0){
				Off.setIcon(OffImage);
				On.setIcon(null);
			}
		});
		On.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent arg0){
				//this.setBounds(0, 0, 0, 0);
			}
		});
	}
}
