import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Window_Tris extends JFrame implements  ActionListener{

	Random rand = new Random();
	
	JPanel title_panel = new JPanel();
	
	JPanel button_panel = new JPanel();;
	
	JLabel textlabel = new JLabel();
	
	JButton[] buttons = new JButton[9];
	
	Cursor cursore = new Cursor(Cursor.CROSSHAIR_CURSOR);
	
	boolean player1_turn; 
	
	public Window_Tris() {
		
		this.setLayout(new BorderLayout());
		title_panel.setLayout(new BorderLayout());
		button_panel.setLayout(new GridLayout(3,3,10,10));
		
		textlabel.setBackground(Color.black);
		textlabel.setForeground(Color.green);
		textlabel.setFont(new Font("BankGothic Md BT",Font.BOLD,75));
		textlabel.setHorizontalAlignment(JLabel.CENTER);
		textlabel.setText("TRIS");
		textlabel.setOpaque(true);
		
		title_panel.add(textlabel);
		
		button_panel.setBackground(Color.black);
		
		for(int i=0;i<9;i++) {
			
		buttons[i] = new JButton();	
		buttons[i].setFocusable(false);
		buttons[i].setFont(new Font("BankGothic Md BT",Font.BOLD,120));
		buttons[i].addActionListener(this);
		buttons[i].setBackground(Color.DARK_GRAY);
		button_panel.add(buttons[i]);
		
		}
		
		this.add(title_panel,BorderLayout.NORTH);
		this.add(button_panel);
		this.setCursor(cursore);
		
		this.getContentPane().setBackground(Color.black);
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		
		firstTurn();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<9;i++) {
			
			if(e.getSource()==buttons[i]) {
				if(player1_turn) {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(Color.green);
						buttons[i].setText("X");
						player1_turn=false;
						textlabel.setText("O TURN");
						check();
					}
				}else {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(Color.black);
						buttons[i].setText("O");
						player1_turn=true;
						textlabel.setText("X TURN");
						check();
				}	
			}	
		}	
    }	
}
	public void firstTurn() {
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(rand.nextInt(2)==0) {
			player1_turn = true;
			textlabel.setText("X TURN");
		}else {
			player1_turn = false;
			textlabel.setText("O TURN");
		}
	}
	public void check() {
		
	if(
	  (buttons[0].getText().equals("X")) && (buttons[1].getText().equals("X")) && (buttons[2].getText().equals("X"))){
	  xWins(0,1,2);
	}
	if(
	  (buttons[3].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[5].getText().equals("X"))){
	  xWins(3,4,5);
    }
	if(
	  (buttons[6].getText().equals("X")) && (buttons[7].getText().equals("X")) && (buttons[8].getText().equals("X"))){
	  xWins(6,7,8);
	}if(
	   (buttons[0].getText().equals("X")) && (buttons[3].getText().equals("X")) && (buttons[6].getText().equals("X"))){
	  xWins(0,3,6);
	}
	if(
	  (buttons[1].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[7].getText().equals("X"))){
	  xWins(1,4,7);
    }
	if(
	  (buttons[2].getText().equals("X")) && (buttons[5].getText().equals("X")) && (buttons[8].getText().equals("X"))){
	  xWins(2,5,8);
	}if(
	   (buttons[0].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[8].getText().equals("X"))){
	  xWins(0,4,8);
    }
	if(
	  (buttons[2].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[6].getText().equals("X"))){
	  xWins(2,4,6);
	}
	if(
	  (buttons[0].getText().equals("O")) && (buttons[1].getText().equals("O")) && (buttons[2].getText().equals("O"))){
      oWins(0,1,2);
    }
    if(
      (buttons[3].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[5].getText().equals("O"))){
      oWins(3,4,5);
    }
    if(
      (buttons[6].getText().equals("O")) && (buttons[7].getText().equals("O")) && (buttons[8].getText().equals("O"))){
      oWins(6,7,8);
    }
    if(
      (buttons[0].getText().equals("O")) && (buttons[3].getText().equals("O")) && (buttons[6].getText().equals("O"))){
      oWins(0,3,6);
    }
    if(
      (buttons[1].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[7].getText().equals("O"))){
      oWins(1,4,7);
    }
    if(
      (buttons[2].getText().equals("O")) && (buttons[5].getText().equals("O")) && (buttons[8].getText().equals("O"))){
      oWins(2,5,8);
    }  
    if(
      (buttons[0].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[8].getText().equals("O"))){
      oWins(0,4,8);
    } 
    if(
      (buttons[2].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[6].getText().equals("O"))){
      oWins(2,4,6);
    }
	}
	public void xWins(int a,int b,int c) {
		buttons[a].setBackground(Color.red);
		buttons[b].setBackground(Color.red);
		buttons[c].setBackground(Color.red);
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
		textlabel.setFont(new Font("BankGothic Md BT",Font.BOLD,28));
		textlabel.setText("X WINS,CONGRATULATION !");
	}
	public void oWins(int a,int b,int c) {
		buttons[a].setBackground(Color.red);
		buttons[b].setBackground(Color.red);
		buttons[c].setBackground(Color.red);
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
		textlabel.setFont(new Font("BankGothic Md BT",Font.BOLD,28));
		textlabel.setText("O WINS,CONGRATULATION !");
	}
}