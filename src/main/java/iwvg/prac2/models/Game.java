package iwvg.prac2.models;

import iwvg.prac2.controllers.Error;

public class Game {

	private State state;

	private Rug rug;

	private static final int NUM_STRAIGHTS = 7;
	private static final int NUM_OPTIONS = 9;

	public Game() {
		state = State.IN_GAME;
		rug = new Rug();
	}

	private void changeState() {
		state = State.FINISHED;
	}

	public boolean isFinished() {
		return state == State.FINISHED;
	}

	public void initialize() {
		rug.initialize();
	}

	public void shuffle() {
		rug.shuffle();
	}

	public void distribute() {
		rug.distribute_cards();
	}

	public Error moveCard(Position origin, Position destiny) {
		assert origin != null;
		assert destiny != null;

		Error error = rug.moveCard(origin, destiny);
		if (rug.isComplete())
			this.changeState();
		return error;
	}

	public Error moveCards(Position origin, Position destiny, int numCards) {
		assert origin != null;
		assert destiny != null;

		Error error = rug.moveCards(origin, destiny, numCards);
		if (rug.isComplete())
			this.changeState();
		return error;
	}

	public Error turnOverCard(Position pos) {
		assert pos != null;
		return rug.turnOverCard(pos);
	}

	public SetOfCards getDeck() {
		return rug.getDeck();
	}

	public SetOfCards getDiscard() {
		return rug.getDiscard();
	}

	public SetOfCards getSpadesPile() {
		return rug.getSpadesPile();
	}

	public SetOfCards getHeartsPile() {
		return rug.getHeartsPile();
	}

	public SetOfCards getDiamondsPile() {
		return rug.getDiamondsPile();
	}

	public SetOfCards getClubsPile() {
		return rug.getClubsPile();
	}

	public SetOfCards getStraight(int pos) {
		return rug.getStraight(pos);
	}

	public Position getPile(int option) {
		switch (option) {
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

	public Position getSuit(int option) {
		switch (option) {
		case 1:
			return Position.SPADES;
		case 2:
			return Position.HEARTS;
		case 3:
			return Position.DIAMONDS;
		case 4:
			return Position.CLUBS;
		default:
			return null;
		}
	}

	public static int getNumStraights() {
		return NUM_STRAIGHTS;
	}

	public static int getNumOptions() {
		return NUM_OPTIONS;
	}

}
