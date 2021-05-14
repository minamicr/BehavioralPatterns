package br.com.cod3r.memento.swing;

import br.com.cod3r.memento.swing.component.TextAreaWithMemory.TextAreaMemento;
import br.com.cod3r.memento.swing.component.TextFieldWithMemory;
import br.com.cod3r.memento.swing.component.TextFieldWithMemory.TextFieldMemento;
import br.com.cod3r.memento.swing.memory.Caretaker;
import br.com.cod3r.memento.swing.memory.Memento;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import br.com.cod3r.memento.swing.component.TextAreaWithMemory;

public class Client {

	public static void main(String[] args) {
				
		JFrame frame = new JFrame();  
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Memento");
		frame.setLayout(new BorderLayout());
		
		JButton previous = new JButton("<<");
		JButton next = new JButton(">>");
		
		frame.add(previous, BorderLayout.WEST);
		frame.add(next, BorderLayout.EAST);
		
		TextAreaWithMemory originator = new TextAreaWithMemory(5, 10);
		JScrollPane scroll = new JScrollPane(originator, 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, 
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		frame.add(scroll, BorderLayout.CENTER);
		
		JPanel bottomPanel = new JPanel(new FlowLayout());
		JComboBox<String> mementosList = new JComboBox<String>();
		TextFieldWithMemory text = new TextFieldWithMemory("", 10);
		JButton save = new JButton("Save");
		bottomPanel.add(text);
		bottomPanel.add(mementosList);
		bottomPanel.add(save);
		
		frame.add(bottomPanel, BorderLayout.SOUTH);
		
		frame.setSize(400,200);
		frame.setVisible(true);

		Caretaker caretaker = new Caretaker();
		save.addActionListener(e -> {
			int index = caretaker.getSize() == 0 ? 1: caretaker.getSize() + 1;
			caretaker.add("textArea" + index, originator.save());
			caretaker.add("textField" + index, text.save());
			mementosList.addItem(caretaker.getSize() + "");
			mementosList.setSelectedItem(caretaker.getSize() + "");
			originator.setText("");
			text.setText("");
			originator.requestFocusInWindow();

		});

		mementosList.addItemListener(e -> {
			if (mementosList.getItemCount() > 0) {
				originator.restore((TextAreaMemento) caretaker.get("textArea" + (Integer.valueOf(mementosList.getSelectedIndex()) + 1)));
				originator.requestFocusInWindow();
				text.restore((TextFieldMemento)caretaker.get("textField" + (Integer.valueOf(mementosList.getSelectedIndex()) + 1)));
			}
		});

		previous.addActionListener(e -> {
			int index = Integer.valueOf(mementosList.getSelectedIndex()) - 1;
			if (index >= 0) {
				mementosList.setSelectedIndex(index);
				originator.restore((TextAreaMemento) caretaker.get("textArea" + (index + 1)));
				originator.requestFocusInWindow();
				text.restore((TextFieldMemento) caretaker.get("textField" + (index + 1)));
			}
		});

		next.addActionListener(e -> {
			int index = Integer.valueOf(mementosList.getSelectedIndex()) + 1;
			if (index < caretaker.getSize()) {
				mementosList.setSelectedIndex(index);
				originator.restore((TextAreaMemento) caretaker.get("textArea" + (index + 1)));
				originator.requestFocusInWindow();
				text.restore((TextFieldMemento) caretaker.get("textField" + (index + 1)));
			}
		});

	}

	private static int getIndex(Caretaker caretaker){
		switch (caretaker.getHistoryList().size()) {
			case 0:
				return 1;
			default:
				return caretaker.getHistoryList().size() / 2;
		}
	}

}
