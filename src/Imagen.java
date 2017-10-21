import javax.swing.ImageIcon;
import java.awt.Image;

class Imagen {
	private Imagen sig, ant;
	private ImageIcon image;
	
	public Imagen(ImageIcon image) {
		sig = ant = null;
		Image img = image.getImage().getScaledInstance(600, 462,  java.awt.Image.SCALE_SMOOTH);
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
