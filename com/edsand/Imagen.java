//Author: Jose Eduardo Sandoval Polanco

package com.edsand;

import javax.swing.ImageIcon;
import java.awt.Image;

class Imagen {
  private Imagen sig, ant;
  private ImageIcon image;
  
  public Imagen(ImageIcon image, int WIDTH, int HEIGHT) {
    sig = ant = null;
    Image img = image.getImage().getScaledInstance(WIDTH, HEIGHT,  
    																							 java.awt.Image.SCALE_SMOOTH);
    this.image = new ImageIcon(img);
  }
  
  public ImageIcon getImagen() {
    return image;
  }
  
  public Imagen getSig() {
    return sig;
  }
  
  public Imagen getAnt() {
    return ant;
  }
  
  public void setSig(Imagen imagen) {
    sig = imagen;
  }
  
  public void setAnt(Imagen imagen) {
    ant = imagen;
  }
}
