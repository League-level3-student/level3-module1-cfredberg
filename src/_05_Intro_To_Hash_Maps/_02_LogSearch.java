package _05_Intro_To_Hash_Maps;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
    /* 
     * Crate a HashMap of Integers for the keys and Strings for the values.
     * Create a GUI with three buttons. 
     * Button 1: Add Entry
     *      When this button is clicked, use an input dialog to ask the user
     *      to enter an ID number.
     *      After an ID is entered, use another input dialog to ask the user
     *      to enter a name. Add this information as a new entry to your
     *      HashMap.
     * 
     * Button 2: Search by ID
     *      When this button is clicked, use an input dialog to ask the user
     *      to enter an ID number.
     *      If that ID exists, display that name to the user.
     *      Otherwise, tell the user that that entry does not exist.
     * 
     * Button 3: View List
     *      When this button is clicked, display the entire list in a message
     *      dialog in the following format:
     *      ID: 123  Name: Harry Howard
     *      ID: 245  Name: Polly Powers
     *      ID: 433  Name: Oliver Ortega
     *      etc...
     * 
     * When this is complete, add a fourth button to your window.
     * Button 4: Remove Entry
     *      When this button is clicked, prompt the user to enter an ID using
     *      an input dialog.
     *      If this ID exists in the HashMap, remove it. Otherwise, notify the
     *      user that the ID is not in the list. 
     */
	public static void main(String[] args) {
		_02_LogSearch ls = new _02_LogSearch();
		ls.run();
	}
	
	JFrame frame = new JFrame("Hash Maps");
	JPanel panel = new JPanel();
	JButton add = new JButton("Add Entry");
	JButton search = new JButton("Search By ID");
	JButton view = new JButton("View List");
	JButton remove = new JButton("Remove Entry");
	
	HashMap<Double, String> hm = new HashMap<Double, String>();
	
	public void run() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setPreferredSize(new Dimension(500, 500));
		
		frame.add(panel);
		
		panel.add(add);
		panel.add(search);
		panel.add(view);
		panel.add(remove);
		
		add.addActionListener(this);
		
		search.addActionListener(this);
		
		view.addActionListener(this);
		
		remove.addActionListener(this);
		
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == add) {
			String idString = JOptionPane.showInputDialog("Please Enter an ID Number (Other Than 0)");
			
			String name = JOptionPane.showInputDialog("Please Enter Your Name");
			
			double id = Double.parseDouble(idString);
			
			hm.put(id, name);
		}else if (e.getSource() == search) {
			boolean stop = true;
			
			double id = 0;
			
			while (stop) {
				String idString = JOptionPane.showInputDialog("Please Enter Your ID Number");
				
				try {
					id = Double.parseDouble(idString);
					if (id == 0) {
						JOptionPane.showMessageDialog(null, "Please Enter an ID Other Than 0");
					}else {
						stop = false;
					}
				} catch (Exception e2){
					JOptionPane.showMessageDialog(null, "Please Enter an ID");
				}
			}
			
			
				
			//String name = "";
			boolean didFindName = false;
			
			Set set = hm.keySet();
			
			for (int i = 0; i < set.size(); i++) {
				if (set.contains(id)) {
					didFindName = true;
				}
			}
			
			if (didFindName == true) {
				JOptionPane.showMessageDialog(null, "Name: " + hm.get(id));
			}else {
				JOptionPane.showMessageDialog(null, "ID Does Not Exist");
			}
		}else if (e.getSource() == view) {
			Set set = hm.keySet();
			
			String message = "";
			
			Object[] setA = set.toArray();
			
			for (int i = 0; i < setA.length; i++) {
				message = message + "ID: " + setA[i] + " Name: " + hm.get(setA[i]) + "\n\n";
			}
			
			JOptionPane.showMessageDialog(null, message);
		}
	}
}
