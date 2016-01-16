package iwvg.prac2.views;

import iwvg.prac2.controllers.Error;
import iwvg.prac2.controllers.StraightToSuitController;
import iwvg.prac2.utils.IO;
import iwvg.prac2.utils.Option;
import iwvg.prac2.utils.YesNoDialog;

public class StraightToSuitView {

	public Option interact(StraightToSuitController straightToSuitController) {
		assert straightToSuitController != null;
		Error error = straightToSuitController.move();
		boolean finished = straightToSuitController.isGameFinished();

		if (finished) {
			Option option = checkEndGame();
			return option;
		} else if (error == null) {
			RugView rugView = new RugView(straightToSuitController);
			rugView.write();
			return rugView.read();
		} else {
			IO io = new IO();
			io.write("ERROR!!! " + error.toString());
			return new MenuView().read();
		}
	}

	private Option checkEndGame() {
		// Comprobamos si se termina el juego al pasar una carta a palo
		// Pasar una carta a un palo es el unico movimiento en el que se puede
		// terminar el juego
		IO io = new IO();
		io.writeln("Enhorabuena!!! Ha completado el solitario");
		YesNoDialog dialog = new YesNoDialog("Desea empezar un juego nuevo");
		boolean startNewGame = dialog.read();
		if (startNewGame) {
			return Option.START;
		} else {
			return Option.EXIT_ALL;
		}
	}

}
