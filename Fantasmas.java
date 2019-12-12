
package pacman;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;

public class Fantasmas {
    
    Laberinto lab = new Laberinto();
    private int x; //columnas
    private int y; //filas
    private final int ancho = 30;
    private final int alto = 30;
    private final int movimiento = 30; //porq se incremenyo de 30 pixeles
    int direccion;
    Random aleatorio;
    Timer timer;
    
    public Fantasmas(int x, int y){
        
        aleatorio = new Random();
        this.x = x;
        this.y = y;
        direccion = aleatorio.nextInt(4);
        this.movimiento();
    }
        
    public void paint(Graphics grafico){
            grafico.setColor(Color.LIGHT_GRAY);
            grafico.fillOval(x, y, ancho, alto);
            grafico.setColor(Color.BLACK);
            grafico.drawOval(x, y, ancho, alto);
    }    
    
    
    public void movimiento(){
        
        timer = new Timer(500, new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){
                //System.out.println("esta funcionando timer");
                int[][] laberinto = lab.obtieneLaberinto();
                
                if(direccion == 0){   //izquierda
                    //System.out.println("aqui 0"+ direccion);
                    
                    //caminar y evitar muro
                    if(laberinto[(y/30)][(x/30)-1] == 0){
                        x = x-movimiento;
                    }else{
                         direccion = aleatorio.nextInt(4);
                    }
                   
                    if(laberinto[(y/30)][(x/30)-1] == laberinto[y/30][x/30] ){
                        direccion = aleatorio.nextInt(4);
                    }
                }
                
                if(direccion == 1){   //derecha
                    //System.out.println("aqui 1"+ direccion);
                    
                    //caminar y evitar muro
                    if(laberinto[(y/30)][(x/30)+1] == 0){
                        x = x+movimiento;
                    }else{
                        direccion = aleatorio.nextInt(4);
                    }
                    
                    /*if(laberinto[(y/30)][(x/30)+1] == laberinto[y/30][x/30] ){
                        direccion = aleatorio.nextInt(4);
                    }*/
                }
                
                if(direccion == 2){   //arriba
                    //System.out.println("aqui 2");
                    
                    //caminar y evitar muro
                    if(laberinto[(y/30)-1][(x/30)] == 0){
                        y = y-movimiento;
                    }else{
                        direccion = aleatorio.nextInt(4);
                    }
                   
                    /*if(laberinto[(y/30)-1][(x/30)] == laberinto[y/30][x/30]){
                        direccion = aleatorio.nextInt(4);
                    }*/
                }
                
                if(direccion == 3){   //abajo
                    //System.out.println("aqui3");
                    
                    //caminar y evitar muro
                    if(laberinto[(y/30)+1][(x/30)] == 0){
                        y = y+movimiento;
                    }else{
                        direccion = aleatorio.nextInt(4);
                    }
                    
                    /*if(laberinto[(y/30)+1][(x/30)] == laberinto[y/30][x/30]){
                        direccion = aleatorio.nextInt(4);
                    }*/
                }
            }
        });     
        timer.start();
    }
        
}
