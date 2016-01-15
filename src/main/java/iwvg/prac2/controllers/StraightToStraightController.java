package iwvg.prac2.controllers;

import iwvg.prac2.models.Game;
import iwvg.prac2.models.Position;
import iwvg.prac2.utils.LimitedIntDialog;
import iwvg.prac2.utils.Option;

public class StraightToStraightController extends MoveController{

	public StraightToStraightController(Game game) {
		super(game);
	}
	
	public Error move(){
		Position origin;
		Position destiny;
		
		int option_origin = new LimitedIntDialog("De que escalera desea mover?", 1, 7).read();
		int num_cards = new LimitedIntDialog("Cuantas cartas desea mover?", 1, 7).read();
		int option_destiny = new LimitedIntDialog("A que escalera desea mover?", 1, 7).read();
		
		origin = getPile(option_origin);
		destiny = getPile(option_destiny);
		
		return this.game.moveCards(origin, destiny, num_cards);
		
	}
	
	private Position getPile(int option){
		switch(option){
			case 1:
				return Position.STRAIGHT_ONE;
			case 2:
				return Position.STRAIGHT_TWO;
			case 3:
				return Position.STRAIGHT_THREE;
			case 4:
				return Position.STRAIGHT_FOUR;
			case 5:
				return Position.STRAIGHT_FIVE;
			case 6:
				return Position.STRAIGHT_SIX;
			case 7:
				return Position.STRAIGHT_SEVEN;
			default:
				return null;
		}
	}
	
	@Override
	public Option accept(OperationControllerVisitor controllerVisitor) {
		return controllerVisitor.visit(this);
	}

	@Override
	public Option accept(MoveControllerVisitor moveControllerVisitor) {
		return moveControllerVisitor.visit(this);
	}
	
}
