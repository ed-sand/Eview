import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Eview {
	public static void main(String[] args) {
		JFrame frame = new ImageViewerFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
	}
}


class ImageViewerFrame extends JFrame {
	public ImageViewerFrame() {
		setTitle("Eview");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
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
		chooser = new JFileChooser();
		lista = new Lista();
		JMenu menu = new JMenu("Archivo");
		JMenuBar menuBar = new JMenuBar();
		JMenuItem openItem = new JMenuItem("Abrir");
		btn_next = new JButton("Sig");
		btn_back = new JButton("Atras");
		panel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				g.setColor(Color.lightGray);
				g.fillRect(0, 0, 1366, 722);
				g.setColor(Color.white);
				g.fillRect(1366/2-65, 722-215, 130, 107);
			}
		};
		
		for (File f: image_dir.listFiles()) {
			ImageIcon icon = new ImageIcon(f.getPath());
			lista.meter(new Imagen(icon));
		}
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
		
		openItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
        	String name = chooser.getSelectedFile().getPath();
          lista.meter(new Imagen(new ImageIcon(name)));
				}
			}
		});

		JMenuItem exitItem = new JMenuItem("Exit");
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
		Image img = image.getImage().getScaledInstance(100, 77,  java.awt.Image.SCALE_SMOOTH);
		return new ImageIcon(img);
	}
   
  private JLabel img_antx5;
  private JLabel img_sigx5;
  private JLabel img_antx3;
  private JLabel img_sigx3;
  private JLabel img_antx4;
  private JLabel img_sigx4;
  private JLabel img_ant_ant;
  private JLabel img_sig_sig;
  private JLabel img_act;
  private JLabel img_ant;
	private JLabel img_sig;
  private File image_dir = new File("/home/esand/Pictures/");
  private JButton btn_next;
  private JButton btn_back;
  private JPanel panel;
 	private JLabel label;
	private Lista lista;
	private Imagen inicio_de_lista;
	private Imagen imagen_actual;
  private JFileChooser chooser;
  private static final int DEFAULT_WIDTH = 1366;
  private static final int DEFAULT_HEIGHT = 722;
}
