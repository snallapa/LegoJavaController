import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

//public class Controller {
//	public Controller() {
//		JFrame myFrame = new JFrame("Controller");
//		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		JPanel panel = new JPanel();
//		panel.setLayout(new GridLayout(3, 3, 2, 2));
//		JButton up = new JButton("Forward");
//		up.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				MyMotor move = new MyMotor();
//				move.forward();
//			}
//		});
//		JButton left = new JButton("Left");
//		left.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				MyMotor move = new MyMotor();
//				move.left();
//			}
//		});
//		JButton stop = new JButton("Stop");
//		stop.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				MyMotor move = new MyMotor();
//				move.stop();
//			}
//		});
//		JButton right = new JButton("Right");
//		right.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				MyMotor move = new MyMotor();
//				move.right();
//			}
//		});
//		JButton down = new JButton("Backward");
//		down.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				MyMotor move = new MyMotor();
//				move.backward();
//			}
//		});
//		panel.add(up);
//		panel.add(left);
//		panel.add(stop);
//		panel.add(right);
//		panel.add(down);
//		myFrame.getContentPane();
//		myFrame.add(panel);
//		myFrame.pack();
//		myFrame.setVisible(true);
//	}
//
//}

public class Controller {

	public Controller() {
		JFrame myFrame = new JFrame("Controller");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		
		panel.setPreferredSize(new Dimension(400, 400));
		bind(panel);
		myFrame.getContentPane();
		myFrame.add(panel);
		myFrame.pack();
		myFrame.setVisible(true);

	}

	private void bind(JPanel panel) {

		ActionMap actionMap = panel.getActionMap();
		int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
		InputMap inputMap = panel.getInputMap(condition);

		for (Direction direction : Direction.values()) {
			inputMap.put(direction.getKeyStroke(), direction.getText());
			actionMap.put(direction.getText(),
					new MyArrowBinding(direction.getText()));
		}
	}

	private class MyArrowBinding extends AbstractAction {

		private static final long serialVersionUID = -6932854424966036412L;

		public MyArrowBinding(String text) {
			super(text);
			putValue(ACTION_COMMAND_KEY, text);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String actionCommand = e.getActionCommand();
			Direction dir = Direction.fromText(actionCommand);

			System.out.println("Key Binding: " + actionCommand);
			MyMotor motor = new MyMotor();
			switch (dir) {
			case UP:
				
				System.out.println("sdafjsldakfjslkaj");
				motor.forward();
				break;
			case DOWN:
				
				System.out.println("sdafjsldakfjslkaj");
				motor.backward();
				break;
			case LEFT:
				
				System.out.println("sdafjsldakfjslkaj");
				motor.left();
			case RIGHT:
				
				motor.right();
			default:
				break;
			}

		}
	}
}

enum Direction {
	UP("Up", KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0)), DOWN("Down", KeyStroke
			.getKeyStroke(KeyEvent.VK_DOWN, 0)), LEFT("Left", KeyStroke
			.getKeyStroke(KeyEvent.VK_LEFT, 0)), RIGHT("Right", KeyStroke
			.getKeyStroke(KeyEvent.VK_RIGHT, 0));

	Direction(String text, KeyStroke keyStroke) {
		this.text = text;
		this.keyStroke = keyStroke;
	}

	private String text;
	private KeyStroke keyStroke;

	public String getText() {
		return text;
	}

	public KeyStroke getKeyStroke() {
		return keyStroke;
	}

	@Override
	public String toString() {
		return text;
	}

	public static Direction fromText(String text) {
		for (Direction direction : Direction.values()) {
			if (text.equalsIgnoreCase(direction.getText())) {
				return direction;
			}
		}
		return UP;
	}
}
