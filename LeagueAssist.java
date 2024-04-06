import java.awt.event.*; 

import javax.swing.*; 

import java.awt.*; 

class LeagueAssist extends JFrame { 
  
	
	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	int tlx = (int)(d.getWidth()/2+200);
	int tly = (int)(d.getHeight()/2+200);
	int yoffset = 0;
	int iterate = 0;
	boolean visible = true;
    // object 
    static LeagueAssist m; 
    // image 
    Image i; 
  
    AWTEventListener listener = new AWTEventListener() {
  	  @Override
  	  public void eventDispatched(AWTEvent event) {
  	    try {
  	      KeyEvent evt = (KeyEvent)event;
  	      if(evt.getID() == KeyEvent.KEY_PRESSED && evt.getModifiers() == KeyEvent.CTRL_MASK && evt.getKeyCode() == KeyEvent.VK_F) {
  	    	  visible = !visible;
  	      }
  	    }
  	    catch(Exception e) {
  	      e.printStackTrace();
  	    }
  	  }
  	};
    
    // default constrcutor 
    LeagueAssist() 
    { 
        // create a frame 
        super("LeagueAssist"); 
  
        setAlwaysOnTop(true);
        // set size of frame 
        setSize(200, 200);
        setUndecorated(true);
        setBounds(tlx-150, tly-150, 200, 200);
        show(); 
        Toolkit.getDefaultToolkit().addAWTEventListener(listener, AWTEvent.KEY_EVENT_MASK);
        // function to LeagueAssist the image 
        work(); 
    } 
  
    // main function 
    public static void main(String args[]) 
    { 
  
        // object of class 
        m = new LeagueAssist(); 
    } 
  
    public void work() 
    { 
        try { 
            // create a robot 
            Robot r = new Robot(); 
  
            // while the frame is visible 
            while (isVisible()) { 
                // get the position of mouse 
                //MouseInfo.getPointerInfo().getLocation(); 
  
                // create a screen capture around the mouse pointer 
                
                i = r.createScreenCapture(new Rectangle(tlx-267, tly-267, 200, 200)); 
                // repaint the conatiner 
                if(visible)
                	repaint(); 
            } 
            // exit the program 
            System.exit(0); 
        } 
        catch (Exception e) { 
            System.err.println(e.getMessage()); 
        } 
    } 
  
    // paint function 
    public void paint(Graphics g) 
    {
  
        // draw the image
    	
        g.drawImage(i, 0, 0, 300, 300, this);
        
        g.setColor(Color.black);
        //g.fillRect(50, 50, 50, 50);
        //g.fillRect(tlx - 300, tly - 300, 200, 200);
        try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        	
        
        //g.fillOval((int)p.getX()-3, (int)p.getY()-3, 6, 6);
        //System.out.println(p.getX() + ", " + p.getY());
    } 
} 
