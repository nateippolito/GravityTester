package SpaceProj;
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
public class Keying extends JPanel{
  public Timer timer;
  public int time;
  public boolean face=true;
  public Rectangle character;
  public Rectangle bottomBox;
  public boolean falling=false;
  public int charH=200;
  public int charW=170;
  public int max;
  public float jumpTime=200;
  public JLabel label;
  public boolean right=false;
  public boolean left=false;
  public boolean jumping=false;
  public Timer tickTimer;
  public double px,py;
  public double gravity;
  Main a1=new Main();
  public Keying(Display f, Images i){
    
   label=Main.mLabel;
    max=(10*(int)Main.z);
    timer = new Timer(1, new taskPerformer());
    tickTimer = new Timer(1, new tickPerformer());
    tickTimer.start();
    character=new Rectangle(180,180,charW,charH);
    bottomBox=new Rectangle(0,940,9000,30);

    f.addKeyListener(new KeyAdapter(){
      public void keyPressed(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_D){
          right=true;
          
        }
        if(e.getKeyCode()==KeyEvent.VK_A){
          left=true;
          
        }
        if(e.getKeyCode()==KeyEvent.VK_SPACE){
          if(!jumping){
          jumping=true;
          
          timer.start();}
        }
      }
      public void keyReleased(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_D){
          right=false;
          
        }
        if(e.getKeyCode()==KeyEvent.VK_A){
          left=false;
          
        }
      }
    });
  }
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    add(label);
    g.drawImage(Main.f.i.bg,0,0,1000,1000,null);
    Point pt1=new Point(character.x,character.y+character.height);
    if(!bottomBox.contains(pt1)&&!jumping&&!falling){
      character.y++;
    }
    this.setBackground(Color.black);
    g.setColor(Main.curCol);
    if(face)
    g.drawImage(Main.f.i.astro,character.x,character.y,charW,charH,null);
    else
    g.drawImage(Main.f.i.astro2,character.x,character.y,charW,charH,null);
    //g.fillRect(character.x,character.y,character.width,character.height);
    g.fillRect(bottomBox.x,bottomBox.y,bottomBox.width,bottomBox.height);

    
    
    repaint();
  }
  
  public class tickPerformer implements ActionListener{
    public int time=0;
    public void actionPerformed(ActionEvent evt){
      label=Main.mLabel;
      max=100/(int)Main.z;
      tick();
    }
  }
  public class taskPerformer implements  ActionListener {
    public int time=0;
      public void actionPerformed(ActionEvent evt) {
        time++;
        
      if(time>max&&time<max*2){
        falling=true;}
        else if(time>max*2){
        
        time=0;
        timer.stop();
        
       jumping=false;
       falling=false;
        }
        
      }
      
      
      }
     
      public void tick(){
        if(right&&character.x!=Main.w-charW){
        character.x+=5;
        if(!(Main.pla==8))
        face=true;
        else
        face=false;
        }
      if(left&&character.x!=0){
        character.x-=5;
        if(!(Main.pla==8))
        face=false;
        else
        face=true;
      }
      if(jumping&&!falling)
        character.y-=5;
      if(falling)
        character.y+=5;
      }
      
      
    
}
