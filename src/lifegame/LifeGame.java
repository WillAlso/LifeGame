package lifegame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public class LifeGame extends JFrame{
	
	private static WorldMap world;
	
	LifeGame(){
		world = new WorldMap();
		this.setSize(world.GetWorld_w(), world.GetWorld_h());
		add(world);
		this.setTitle("Game of Life");
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	LifeGame(int row,int col,int time,int width,int height){
		this.setTitle("Game of Life");
		this.add(world);
		this.setResizable(true);
	}
	
	void SetLife(int row,int col,int time,int width,int height) {
	}
	
	public static void main(String[] args) {
		LifeGame lifegame = new LifeGame();

		JMenuBar menu = new JMenuBar();
		lifegame.setJMenuBar(menu);
        
        JMenu options = new JMenu("Options");
        menu.add(options);
        
        JMenuItem blank = options.add("Design");
        blank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(blank.getText().equals("Design")) {
					blank.setText("Done");
				}else {
					blank.setText("Design");
				}
				world.SetDesignWorld();
			}
        });
        
        JMenuItem stop = options.add("Stop");
        stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(stop.getText().equals("Stop")) {
					stop.setText("Start");
				}else {
					stop.setText("Stop");
				}
				world.StopWorld();
			}
        });
        
        JMenuItem speed = options.add("Speed");
        speed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				world.SpeedWorld();
			}
        });
        
        JMenuItem slow = options.add("Slow");
        slow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				world.SlowWorld();
			}
        });
        
        JMenuItem exit = options.add("Exit");
        exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
        });
        
        JMenu shape = new JMenu("Shape");
        menu.add(shape);
        
        JMenuItem arrow = shape.add("Arrow");
        arrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				world.SetArrowWorld();
			}
        });
        
        JMenuItem square = shape.add("Square");
        square.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				world.SetSquareWorld();
			}
        });
        
        JMenuItem glider = shape.add("Glider");
        glider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				world.SetGliderWorld();
			}
        });
        
        JMenuItem ant = shape.add("Other");
        ant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				world.SetTempWorld();
			}
        });
        
        JMenu help = new JMenu("Help");
        menu.add(help);
        
        JMenuItem about = help.add("About");
        about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String t = "Option:\nDesign/Done 设计/完成设计\n" + "Stop/Start 暂停/开始\n" +
			"Speed/Slow 加速/减速\n Exit 退出\n"+ "Shape: 形状选择\n" 
						+"更多生命游戏模型访问\nhttp://www.conwaylife.com/wiki/";
				JOptionPane.showMessageDialog(null, t, "关于",JOptionPane.INFORMATION_MESSAGE);
			}
        });
        
		lifegame.setVisible(true);
	}

}