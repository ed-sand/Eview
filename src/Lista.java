//Author: Jose Eduardo Sandoval Polanco

import javax.swing.ImageIcon;

class Lista {
	Imagen inicio, fin;
	
	public Lista() {
		inicio = fin = null;
	}
	
	public void meter(Imagen imagen) {
		if (inicio == null) {
			inicio = fin = imagen;
			fin.setSig(inicio);
			inicio.setAnt(fin);
		}
		else {
			fin.setSig(imagen);
			fin.getSig().setAnt(fin);
			fin = fin.getSig();
			fin.setSig(inicio);
			inicio.setAnt(fin);
		}
	}
	
	public void sacar() {
		if (inicio == null) System.out.println("Lista vacia!");
		else if (inicio == fin) inicio = fin = null;
		else {
			fin = fin.getAnt();
			fin.setSig(inicio);
		}
	}
	
	public void paso_izq() {
		Imagen tmp = inicio;
		inicio = inicio.getSig();
		meter(tmp);
	}
	
	public void paso_der() {
		Imagen tmp = fin;
		fin = fin.getAnt();
		inicio.setAnt(tmp);
		inicio = tmp;
	}
	
	public Imagen getInicio() {
		return inicio;
	}
}
