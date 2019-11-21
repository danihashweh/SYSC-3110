package ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.SwingUtilities;

import model.Board;
import resources.Resources;

/**
 * This class represents a level builder which allows the user to create and
 * save their own levels.
 * 
 * @author Abdalla El Nakla
 * @author Mohamed Radwan
 * @author Samuel Gamelin
 */
public class LevelBuilder extends JFrame implements ActionListener {

	private JButton menuReset;
	private JButton menuHelp;
	private JButton menuMainScreen;
	private JButton saveBoard;

	private Board board;
	private JButton[][] buttons;

	public LevelBuilder() {
		this.board = new Board();

		this.setTitle("Level Builder");
		JLabel boardLabel = new JLabel(Resources.BOARD);
		boardLabel.setLayout(new GridLayout(5, 5));

		this.add(boardLabel, BorderLayout.CENTER);

		// Menu bar
		JMenuBar menuBar = new JMenuBar();

		menuMainScreen = ui.GUIUtilities.createMenuBarButton("Main Menu", true);
		menuReset = ui.GUIUtilities.createMenuBarButton("Reset", false);
		saveBoard = ui.GUIUtilities.createMenuBarButton("Save", true);
		menuHelp = ui.GUIUtilities.createMenuBarButton("Help", false);

		menuBar.add(menuMainScreen);
		menuBar.add(menuReset);
		menuBar.add(saveBoard);
		menuBar.add(menuHelp);

		this.setJMenuBar(menuBar);
		this.setContentPane(new JLabel(Resources.BOARD));
		this.getContentPane().setLayout(new GridLayout(5, 5));

		// Create all buttons
		buttons = new JButton[5][5];
		for (int y = 0; y < Board.SIZE; y++) {
			for (int x = 0; x < Board.SIZE; x++) {
				JButton button = new JButton();
				button.setOpaque(false);
				button.setContentAreaFilled(false);
				buttons[x][y] = button;
				boardLabel.add(buttons[x][y]);
			}
		}
		menuMainScreen.addActionListener(this);
		menuReset.addActionListener(this);
		menuHelp.addActionListener(this);
		saveBoard.addActionListener(this);

		GUIUtilities.configureFrame(this);
	}

	// Added for testing frame
	public static void main(String[] args) {
		SwingUtilities.invokeLater(LevelBuilder::new);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		if (e.getSource() == menuMainScreen
//				&& GUIUtilities.displayOptionDialog(null, "Are you sure you want to return to main menu?",
//						"Return to Main Menu", new String[] { "Yes", "No" }) == 0) {
//			this.dispose();
//			SwingUtilities.invokeLater(MainMenu::new);
//		} else if (e.getSource() == menuHint) {
//			Move bestMove = gameController.getNextBestMove();
//			if (!buttons[bestMove.xStart][bestMove.yStart].getBorder().equals(selectedBorder)) {
//				buttons[bestMove.xStart][bestMove.yStart].setBorder(hintBorderStart);
//			}
//			buttons[bestMove.xEnd][bestMove.yEnd].setBorder(hintBorderEnd);
//		} else if (e.getSource() == boardSave) {
//			int returnVal = fc.showSaveDialog(this);
//			if (returnVal == JFileChooser.APPROVE_OPTION) {
//				File file = fc.getSelectedFile();
//				gameController.saveGame(file);
//			}
//		} else if (e.getSource() == menuHelp) {
//			displayHelpDialog();
//		} else if ((e.getSource() == menuQuit) && GUIUtilities.displayOptionDialog(this,
//				"Are you sure you want to exit?", "Exit Rabbits and Foxes!", new String[] { "Yes", "No" }) == 0) {
//			System.exit(0);
//		} else if ((e.getSource() == menuReset) && (GUIUtilities.displayOptionDialog(this,
//				"Are you sure you want to reset the game? (Your progress will be lost)", "Reset Rabbits and Foxes!",
//				new String[] { "Yes", "No" }) == 0)) {
//			resetGame();
//		} else if (e.getSource() == menuUndo) {
//			clearButtonBorders();
//			if (!gameController.undoMove()) {
//				GUIUtilities.displayMessageDialog(this, "No moves to undo", "Undo Move");
//			}
//		} else if (e.getSource() == menuRedo) {
//			clearButtonBorders();
//			if (!gameController.redoMove()) {
//				GUIUtilities.displayMessageDialog(this, "No moves to redo", "Redo Move");
//			}
//		}

	}
}
