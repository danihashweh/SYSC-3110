package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.ColorUIResource;

import resources.Resources;

public class GUIUtilities {

	private GUIUtilities() {

	}

	public static void configureFrame(JFrame frame) {
		frame.setIconImage(Resources.WINDOW_ICON.getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	/**
	 * Forces the look and feel of the application to remain consistent across
	 * platforms, and removes the focus border form all buttons.
	 */
	public static void applyDefaults() {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			Resources.LOGGER.error("Could not set the default look and feel", e);
		}
		UIManager.getLookAndFeelDefaults().put("Button.focus", new ColorUIResource(new Color(0, 0, 0, 0)));
	}

	/**
	 * Displays an informational message dialog.
	 * 
	 * @param parent  The parent component of this option dialog
	 * @param message The message to display
	 * @param title   The title of the dialog box
	 */
	public static void displayMessageDialog(Component parent, String message, String title) {
		JOptionPane.showMessageDialog(parent, message, title, JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Displays an option dialog, returning the choice selected by the user.
	 * 
	 * @param parent  The parent component of this option dialog
	 * @param message The message to display
	 * @param title   The title of the dialog box
	 * @param options The options to be provided in the dialog - the initial option
	 *                selected is the first element of the provided object array
	 * @return The choice made by the user
	 */
	public static int displayOptionDialog(Component parent, String message, String title, Object[] options) {
		return JOptionPane.showOptionDialog(parent, message, title, JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
	}

	/**
	 * Binds the specified keystroke to the specified JComponent.
	 * 
	 * @param component  The component on which the keystroke should be bound
	 * @param keystroke  The keystroke to bind
	 * @param actionName The name of keystroke action
	 * @param method     The method to execute when the keystroke is activated
	 */
	public static void bindKeyStroke(JComponent component, String keystroke, String actionName, Runnable method) {
		if (keystroke.length() == 1) {
			component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(keystroke.charAt(0)),
					actionName);
		} else {
			component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(keystroke), actionName);
		}
		component.getActionMap().put(actionName, new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				method.run();
			}

		});
	}
}
