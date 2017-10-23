//Author: Jose Eduardo Sandoval Polanco

package com.edsand;

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


public class Eview extends JFrame {
  private JPanel panel;
  private JButton btn_next, btn_back;
  private JLabel lblBigImage, lblAct;
  private JMenu menu;
  private JMenuBar menuBar;
  private JMenuItem openItem, exitItem;
  private JLabel lblAnt1, lblAnt2, lblAnt3, lblAnt4, lblAnt5;
  private JLabel lblSig1, lblSig2, lblSig3, lblSig4, lblSig5;
  private File image_dir;
  private JFileChooser chooser;
  private Imagen imagen_actual;
  private Lista lista;
  private static final int DEFAULT_WIDTH = 1366;
  private static final int DEFAULT_HEIGHT = 722;

  public Eview() {
    setTitle("Eview");
    setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    setVariables();
    JButton Buttons[] = {btn_back, btn_next};
    getImagenes();
    setLabelIcons(getLabels());
    setLabelBounds(getLabels());
    addComponets(Buttons, getLabels());
    addActionListeners();
  }
  
  public void getImagenes() {
    for (File f: image_dir.listFiles()) {
      ImageIcon icon = new ImageIcon(f.getPath());
      lista.meter(new Imagen(icon));
    }
    imagen_actual = lista.getInicio();
  }
  
  public void setVariables() {
    lblBigImage = new JLabel();
    lblAnt1 = new JLabel();
    lblSig1 = new JLabel();
    lblAct = new JLabel();
    lblAnt2 = new JLabel();
    lblSig2 = new JLabel();
    lblAnt3 = new JLabel();
    lblAnt4 = new JLabel();
    lblSig3 = new JLabel();
    lblSig4 = new JLabel();
    lblSig5 = new JLabel();
    lblAnt5 = new JLabel();
    image_dir = new File("images/");
    chooser = new JFileChooser();
    lista = new Lista();
    menu = new JMenu("Archivo");
    menuBar = new JMenuBar();
    openItem = new JMenuItem("Abrir");
    btn_next = new JButton("Sig");
    btn_back = new JButton("Atras");
    exitItem = new JMenuItem("Exit");
    chooser.setCurrentDirectory(new File("."));
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
  
  public void setLabelIcons(JLabel Labels[]) {
    Labels[0].setIcon(imagen_actual.getImagen());
    Labels[1].setIcon(resize(imagen_actual.getImagen()));
    for (int i = 2; i < 7; i++) 
      Labels[i].setIcon(resize(getAnt(imagen_actual, i-1)));
    for (int i = 7; i < Labels.length; i++) 
      Labels[i].setIcon(resize(getSig(imagen_actual, i-6)));
  }
  
  public ImageIcon getAnt(Imagen imagen, int recorrido) {
    if (recorrido == 0) return imagen.getImagen();
    return getAnt(imagen.getAnt(), --recorrido);
  }
  
  public ImageIcon getSig(Imagen imagen, int recorrido) {
    if (recorrido == 0) return imagen.getImagen();
    return getSig(imagen.getSig(), --recorrido);
  }
  
  public void setLabelBounds(JLabel Labels[]) {
    panel.setLayout(null);
    int middle_x = DEFAULT_WIDTH/2;
    int act_x = middle_x-50;
    int act_y = DEFAULT_HEIGHT-200;
    int x_offset = 120;
    btn_back.setBounds(middle_x-110, 630, 100, 50);
    btn_next.setBounds(middle_x+10, 630, 100, 50);
    Labels[0].setBounds((DEFAULT_WIDTH-600)/2, 30, 600, 462);
    Labels[1].setBounds(act_x, act_y, 100, 77);
    for (int i = 2; i < 7; i++) {
      Labels[i].setBounds(act_x - x_offset, act_y, 100, 77);
      Labels[i+5].setBounds(act_x + x_offset, act_y, 100, 77);
      x_offset += 120;
    }
  }
  
  public void addComponets(JButton Buttons[], JLabel Labels[]) {
    menuBar.add(menu);
    setJMenuBar(menuBar);
    for (JButton button: Buttons) panel.add(button);
    for (JLabel label: Labels) panel.add(label);
    menu.add(openItem);
    this.getContentPane().add(panel);
  }
  
  public void move_next(JLabel Labels[]) {
    Labels[0].setIcon(getSig(imagen_actual, 1));
    Labels[1].setIcon(resize(getSig(imagen_actual, 1)));
    for (int i = 2; i < 7; i++)
      Labels[i].setIcon(resize(getAnt(imagen_actual, i-2)));
    for (int i = 7; i < Labels.length; i++)
      Labels[i].setIcon(resize(getSig(imagen_actual, i-5)));
    imagen_actual = imagen_actual.getSig();
  }
    
  public void move_back(JLabel Labels[]) {
    Labels[0].setIcon(getAnt(imagen_actual, 1));
    for (int i = 1; i < 7; i++)
      Labels[i].setIcon(resize(getAnt(imagen_actual, i)));
    for (int i = 7; i < Labels.length; i++) 
      Labels[i].setIcon(resize(getSig(imagen_actual, i-7)));
    imagen_actual = imagen_actual.getAnt();
  }
  
  public ImageIcon resize(ImageIcon image) {
    Image img = image.getImage().getScaledInstance(100, 77, Image.SCALE_SMOOTH);
    return new ImageIcon(img);
  }
  
  public JLabel[] getLabels() {
    JLabel Labels[] = {lblBigImage, lblAct, 
                       lblAnt1,     lblAnt2,  lblAnt3, lblAnt4, lblAnt5,
                       lblSig1,     lblSig2,  lblSig3, lblSig4,  lblSig5};   
    return Labels;      
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
        if (imagen_actual.getSig() != null) move_next(getLabels());
      }
    });
    btn_back.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        if (imagen_actual.getAnt() != null) move_back(getLabels());
      }
    });
  }
  
  public static void main(String[] args) {
    JFrame frame = new Eview();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}
