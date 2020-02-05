package windows;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Toolkit;

import windows.StartPanel;

public class MainFrame extends JFrame implements ActionListener {
	final static int WIDTH = 1280;
	final static int HEIGHT = 720;
	
	private Toolkit kit = Toolkit.getDefaultToolkit();
	private Dimension screenSize = kit.getScreenSize();
	private int screenWidth = screenSize.width;
	private int screenHeight = screenSize.height;
	
	MenuItem renew = new MenuItem("    重新开始");
	MenuItem last = new MenuItem("    上一关");
	MenuItem next = new MenuItem("    下一关");
	MenuItem choose = new MenuItem("    选关");
	MenuItem help = new MenuItem("    帮助");
	MenuItem exit = new MenuItem("    退出");
	
	StartPanel startPanel = new StartPanel(WIDTH,HEIGHT);
	PlayPanel playPanel = new PlayPanel();
	
	JLabel helpLabel = new JLabel("");
	
	public MainFrame()
	{
		// basic steps for JFrame
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/images/title.png")));
		this.setTitle("Ram & Rem");
		this.setBounds((screenWidth-WIDTH)/2, (screenHeight-HEIGHT)/2, WIDTH, HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
	        	System.exit(0);
	        }
	    });    
		
		// set two panel (default: startPanel)
		startPanel.setBounds(0, 0, WIDTH, HEIGHT);
		startPanel.setOpaque(false);
		startPanel.setVisible(true);
		startPanel.setLayout(null);
		playPanel.setBounds(0, 0, WIDTH, HEIGHT);
		playPanel.setOpaque(false);
		playPanel.setVisible(false);
		playPanel.setLayout(null);
		
		// put JPanel into Container
		Container cont=getContentPane();
		cont.setLayout(null);
		cont.setBackground(Color.black);
		cont.add(helpLabel);
		cont.add(startPanel);
		cont.add(playPanel);
		
		// set menu
		Menu choice=new Menu("选项");
		choice.add(renew);
		choice.add(last);
		choice.add(next);
		choice.add(choose);
		choice.add(help);
		choice.add(exit);
		renew.addActionListener(this);
		last.addActionListener(this);
		next.addActionListener(this);
		choose.addActionListener(this);
		help.addActionListener(this);
		exit.addActionListener(this);

		// set menu bar
		MenuBar bar=new MenuBar();
		bar.add(choice);
		setMenuBar(bar);    
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == help)
		{
			//paint the help image, click to remove
			ImageIcon helpImage = new ImageIcon(MainFrame.class.getResource("/images/help.png"));
			final int helpHeight = helpImage.getIconHeight();
			final int helpWidth = helpImage.getIconWidth();
			helpLabel.setIcon(helpImage);
			helpLabel.setBounds((WIDTH-helpWidth)/2, (HEIGHT-helpHeight)/4 ,helpWidth,helpHeight);
			helpLabel.addMouseListener(new MouseAdapter(){
				@Override
				public void mouseClicked(MouseEvent arg0){
					helpLabel.setIcon(null);
					helpLabel.setBounds(0, 0, 0, 0);
				}
			});
		}
		if(e.getSource() == exit){
			System.exit(0);
		}
	}
}
