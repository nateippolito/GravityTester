package SpaceProj;
import java.awt.*;
import javax.swing.*;

import java.util.*;
public class Main{
  public static Display f = new Display();
  public static int w=1000;
  public static int h=1000;
  public static double z;
  public static boolean run=true;
  public static double[] grav= {9.8,24.7,3.7,10.4,8.8,8.8,11.15,3.7,1.6};
  public static int pla;
  public static String planet;
  public static String[] planets={"Earth","Jupiter","Mars","Saturn","Venus","Uranus","Saturn","Mercury","Moon"};
  public static Color[] colors;
  public static Color curCol;
  public static JLabel mLabel;
  public Main(){
    mLabel=new JLabel("Earth - 9.8 m/s^2");
    mLabel.setForeground(Color.white);
    mLabel.setFont(new Font("Arial", Font.PLAIN, 20));
    colors=new Color[9];
    z=9.8;
    pla=1;
    planet="Earth";
    colors[0]=new Color(68,82,52);
    colors[1]=new Color(186,173,152);
    colors[2]=new Color(218,96,54);
    colors[3]=new Color(229,196,109);
    colors[4]=new Color(218,171,63);
    colors[5]=new Color(211,242,252);
    colors[6]=new Color(194,165,106);
    colors[7]=new Color(119,115,114);
    colors[8]=new Color(121,120,118);
    curCol=colors[0];
  }
  public static void main(String[] args){
    
    f.setSize(w,h);
    f.setResizable(true);
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setTitle("Gravity Explorer - Currently on: Earth");
    f.setLocationRelativeTo(null);
    f.setAlwaysOnTop(true);
    
    Scanner scan=new Scanner(System.in);
    while(run){
      
      askQ();
      int i=scan.nextInt();
      if(i>0&&i<10){
      for(int k=1;k<=grav.length;k++){
        if(i==k){
          z=grav[k-1];
          f.setTitle("Gravity Explorer - Currently on: "+planets[k-1]);
          planet=planets[k-1];
          curCol=colors[k-1];
          mLabel.setText(planets[k-1]+" - "+grav[k-1]+" m/s");
          pla=k-1;
        }
      }
    }
    else{
      System.exit(0);
    }
    }
    
  }
  public static void askQ(){
    System.out.println("Which planet would you like to visit? \nEnter anything but 1-9 to stop.");
    System.out.println("1: Earth");
    System.out.println("2: Jupiter");
    System.out.println("3: Mars");
    System.out.println("4: Saturn");
    System.out.println("5: Venus");
    System.out.println("6: Uranus ");
    System.out.println("7: Saturn");
    System.out.println("8: Mercury");
    System.out.println("9: Moon");
  }
}
