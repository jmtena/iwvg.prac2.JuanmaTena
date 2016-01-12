package iwvg.prac2;

public class Card {
	private Suit suit;
	private CardNumber number;
	private Orientation orientation;
	
	public Card(Suit suit, CardNumber number){
		this.suit = suit;
		this.number = number;
	}
	
	public Card(Suit suit, CardNumber number, Orientation orientation){
		this.suit = suit;
		this.number = number;
		this.orientation = orientation;
	}
	
	public boolean isEqual(Card card){
		return this.suit==card.getSuit() && this.number==card.getNumber();
	}

	public Suit getSuit() {
		return suit;
	}

	public CardNumber getNumber() {
		return number;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}
	
}