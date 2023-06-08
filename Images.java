package SpaceProj;
import java.awt.*;
import javax.swing.*;
public class Images extends JPanel{
  public int w=Main.w;
  public int h=Main.h;
public boolean imagesLoaded=false;
  public Image bg;
  public Image astro;
  public Image astro2;
  public Images(){
    this.setBackground(Color.black);
    
  }

  public void loadImages(){
    bg=new ImageIcon("SpaceProj\\stars.png").getImage();
    astro=new ImageIcon("SpaceProj\\astro.gif").getImage();
    astro2=new ImageIcon("SpaceProj\\astro2.gif").getImage();
    imagesLoaded=true;
  }
}
