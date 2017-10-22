//Author: Jose Eduardo Sandoval Polanco


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.io.File;


public class Eview {
	public static void main(String[] args) {
		JFrame frame = new ImageViewerFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
	}
}


class ImageViewerFrame extends JFrame {
	private JLabel img_act;
  private JLabel img_antx5, img_antx3, img_antx4, img_ant_ant, img_ant;
  private JLabel img_sigx5, img_sigx3, img_sigx4, img_sig_sig, img_sig;
  private File image_dir;
  private JButton btn_next, btn_back;
  private JPanel panel;
 	private JLabel label;
	private Lista lista;
	private JMenu menu;
	private JMenuBar menuBar;
	private	JMenuItem openItem;
	private JMenuItem exitItem;
	private Imagen inicio_de_lista, imagen_actual;
  private JFileChooser chooser;
  private static final int DEFAULT_WIDTH = 1366;
  private static final int DEFAULT_HEIGHT = 722;
  
	public ImageViewerFrame() {
		setTitle("Eview");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		declareVariables();
		getImagenes();
    setLabelIcons();
    setLabelBounds();
    addComponets();
    addActionListeners();
	}
	
	public void getImagenes() {
		for (File f: image_dir.listFiles()) {
			ImageIcon icon = new ImageIcon(f.getPath());
			lista.meter(new Imagen(icon));
		}
	}
	
	public void declareVariables() {
		label = new JLabel();
		img_ant = new JLabel();
		img_sig = new JLabel();
		img_act = new JLabel();
		img_ant_ant = new JLabel();
		img_sig_sig = new JLabel();
		img_antx3 = new JLabel();
		img_antx4 = new JLabel();
		img_sigx3 = new JLabel();
		img_sigx4 = new JLabel();
		img_sigx5 = new JLabel();
		img_antx5 = new JLabel();
		image_dir = new File("../../../images/");
		chooser = new JFileChooser();
		lista = new Lista();
		menu = new JMenu("Archivo");
		menuBar = new JMenuBar();
		openItem = new JMenuItem("Abrir");
		btn_next = new JButton("Sig");
		btn_back = new JButton("Atras");
		exitItem = new JMenuItem("Exit");
	  panel = new JPanel() {
		  @Override
		  public void paintComponent(Graphics g) {
		    g.setColor(Color.lightGray);
        g.fillRect(0, 0, 1366, 722);
			  g.setColor(Color.white);
			  g.fillRect(1366/2-65, 722-215, 130, 107);
		  }
		};
	}
  
  public void setLabelIcons() {
    label.setIcon(lista.getInicio().getImagen());
    imagen_actual = lista.getInicio();
    img_act.setIcon(resize_icon(imagen_actual.getImagen()));
    img_ant.setIcon(resize_icon(imagen_actual.getAnt().getImagen()));
    img_sig.setIcon(resize_icon(imagen_actual.getSig().getImagen()));
    img_ant_ant.setIcon(resize_icon(imagen_actual.getAnt().getAnt().getImagen()));
    img_sig_sig.setIcon(resize_icon(imagen_actual.getSig().getSig().getImagen()));
		img_sigx3.setIcon(resize_icon(imagen_actual.getSig().getSig().getSig().getImagen()));
		img_antx3.setIcon(resize_icon(imagen_actual.getAnt().getAnt().getAnt().getImagen()));
		img_sigx4.setIcon(resize_icon(imagen_actual.getSig().getSig().getSig().getSig().getImagen()));
		img_antx4.setIcon(resize_icon(imagen_actual.getAnt().getAnt().getAnt().getAnt().getImagen()));
		img_sigx5.setIcon(resize_icon(imagen_actual.getSig().getSig().getSig().getSig().getSig().getImagen()));
		img_antx5.setIcon(resize_icon(imagen_actual.getAnt().getAnt().getAnt().getAnt().getAnt().getImagen()));
  }
  
  public void setLabelBounds() {
    panel.setLayout(null);
		int act_x = 1366/2-50;
		int act_y = 722-200;
		btn_back.setBounds(1366/2-110, 630, 100, 50);
		btn_next.setBounds(1366/2+10, 630, 100, 50);
		label.setBounds((1366-600)/2, 30, 600, 462);
		img_ant.setBounds(act_x - 120, act_y, 100, 77);
		img_sig.setBounds(act_x + 120, act_y, 100, 77);
		img_act.setBounds(act_x, act_y, 100, 77);
		img_ant_ant.setBounds(act_x - 240, act_y, 100, 77);
		img_sig_sig.setBounds(act_x + 240, act_y, 100, 77);
		img_sigx3.setBounds(act_x + 360, act_y, 100, 77);
		img_antx3.setBounds(act_x - 360, act_y, 100, 77);
		img_sigx4.setBounds(act_x + 480, act_y, 100, 77);
		img_antx4.setBounds(act_x - 480, act_y, 100, 77);
		img_sigx5.setBounds(act_x + 600, act_y, 100, 77);
		img_antx5.setBounds(act_x - 600, act_y, 100, 77);
  }
  
  public void addComponets() {
    menuBar.add(menu);
		setJMenuBar(menuBar);
		chooser.setCurrentDirectory(new File("."));
    panel.add(btn_next);
    panel.add(btn_back);
    panel.add(label);
    panel.add(img_ant);
    panel.add(img_sig);
    panel.add(img_act);
    panel.add(img_ant_ant);
    panel.add(img_sig_sig);
    panel.add(img_sigx3);
    panel.add(img_sigx4);
    panel.add(img_antx3);
    panel.add(img_antx4);
    panel.add(img_antx5);
    panel.add(img_sigx5);
    this.getContentPane().add(panel);
		menu.add(openItem);
  }
	
	public void move_next() {
    label.setIcon(imagen_actual.getSig().getImagen());
		img_sig.setIcon(resize_icon(imagen_actual.getSig().getSig().getImagen()));
		img_ant.setIcon(resize_icon(imagen_actual.getImagen()));
		img_act.setIcon(resize_icon(imagen_actual.getSig().getImagen()));
		img_ant_ant.setIcon(resize_icon(imagen_actual.getAnt().getImagen()));
    img_sig_sig.setIcon(resize_icon(imagen_actual.getSig().getSig().getSig().getImagen()));
    img_sigx3.setIcon(resize_icon(imagen_actual.getSig().getSig().getSig().getSig().getImagen()));
    img_sigx4.setIcon(resize_icon(imagen_actual.getSig().getSig().getSig().getSig().getSig().getImagen()));
    img_antx3.setIcon(resize_icon(imagen_actual.getAnt().getAnt().getImagen()));
    img_antx4.setIcon(resize_icon(imagen_actual.getAnt().getAnt().getAnt().getImagen()));
    img_antx5.setIcon(resize_icon(imagen_actual.getAnt().getAnt().getAnt().getAnt().getImagen()));
    img_sigx5.setIcon(resize_icon(imagen_actual.getSig().getSig().getSig().getSig().getSig().getSig().getImagen()));
		imagen_actual = imagen_actual.getSig();
	}
		
	public void move_back() {
		label.setIcon(imagen_actual.getAnt().getImagen());
		img_ant.setIcon(resize_icon(imagen_actual.getAnt().getAnt().getImagen()));
		img_sig.setIcon(resize_icon(imagen_actual.getImagen()));
		img_act.setIcon(resize_icon(imagen_actual.getAnt().getImagen()));
		img_ant_ant.setIcon(resize_icon(imagen_actual.getAnt().getAnt().getAnt().getImagen()));
		img_sig_sig.setIcon(resize_icon(imagen_actual.getSig().getImagen()));
		img_sigx3.setIcon(resize_icon(imagen_actual.getSig().getSig().getImagen()));
		img_sigx4.setIcon(resize_icon(imagen_actual.getSig().getSig().getSig().getImagen()));
		img_antx3.setIcon(resize_icon(imagen_actual.getAnt().getAnt().getAnt().getAnt().getImagen()));
		img_antx4.setIcon(resize_icon(imagen_actual.getAnt().getAnt().getAnt().getAnt().getAnt().getImagen()));
		img_antx5.setIcon(resize_icon(imagen_actual.getAnt().getAnt().getAnt().getAnt().getAnt().getAnt().getImagen()));
		img_sigx5.setIcon(resize_icon(imagen_actual.getSig().getSig().getSig().getSig().getImagen()));
		imagen_actual = imagen_actual.getAnt();
	}
	
	public ImageIcon resize_icon(ImageIcon image) {
		Image img = image.getImage().getScaledInstance(100, 77, Image.SCALE_SMOOTH);
		return new ImageIcon(img);
	}
	
	public void addActionListeners() {
		openItem.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent event) {
				int result = chooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
        	String name = chooser.getSelectedFile().getPath();
          lista.meter(new Imagen(new ImageIcon(name)));
				}
			}
    });

		menu.add(exitItem);
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		
		btn_next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (imagen_actual.getSig() != null) move_next();
			}
		});
		
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (imagen_actual.getAnt() != null) move_back();
			}
		});
	}
}
