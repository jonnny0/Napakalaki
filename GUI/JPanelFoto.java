/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author 
 */
public class JPanelFoto extends JPanel{
    private Image imagen;
    
    public JPanelFoto(){
    
    }
    
    public JPanelFoto(String nombreImagen){
        if (nombreImagen != null){
            imagen = new ImageIcon(getClass().getResource(nombreImagen)).getImage().getScaledInstance(128, 91, Image.SCALE_DEFAULT); //"src/imgs/TESOROS/Shogulador.jpg"
        }
    }
    
    public JPanelFoto(Image imagenInicial){
        if (imagenInicial != null){
            imagen = imagenInicial;
        }
    }
    
    public void setImagen(String nombreImagen){
        if (nombreImagen != null){
            imagen = new ImageIcon(getClass().getResource(nombreImagen)).getImage().getScaledInstance(128, 91, Image.SCALE_DEFAULT);
        }else{
            imagen = null;
        }
        repaint();
    }
    
    public void setImagen(Image nuevaImagen){
        imagen = nuevaImagen;        
        repaint();
    }
    //Sobreescribo metodo paint para agregar la imagen ya seteada
    @Override
    public void paint(Graphics g){
        if (imagen != null){
            g.drawImage(imagen, 0, 0, this.getWidth(), this.getHeight(), this);
            this.setOpaque(false);  //No muestre su fondo por defecto
        }
        else{
            this.setOpaque(true);
        }
        super.paint(g);
    }
    
}
