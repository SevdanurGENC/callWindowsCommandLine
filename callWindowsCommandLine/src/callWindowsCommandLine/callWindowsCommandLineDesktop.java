package callWindowsCommandLine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JFrame; 

public class callWindowsCommandLineDesktop extends JFrame{
	
	public static void callCMDLine() { 
		try { 
			Process process = Runtime.getRuntime().exec("cmd.exe /c start helloNano.bat", null, new File("C:\\Users\\Nano\\"));
			
	        StringBuilder output = new StringBuilder();
	        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

	        String line;
	        while ((line = reader.readLine()) != null) {
	            output.append(line + "\n");
	        }

	        int exitVal = process.waitFor();
	        if (exitVal == 0) {
	            System.out.println("Success!");
	            System.out.println(output);
	            System.exit(0);
	        } else {
	        	System.out.println("Fail!");
	        }

	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}

	public static void main(String[] args) {
		
		JFrame frame = new JFrame();  
	        frame.setTitle("HelloNano");
	        frame.getContentPane().setLayout(null);
	        frame.setVisible(true);
	        frame.setBounds(200,200,500,300);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		 
        JButton button = new JButton("Execute Command Line!");
	        button.setBounds(100,100,250,40);
	        frame.add(button);
        
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	callCMDLine();
            }
        }); 
	} 

}
