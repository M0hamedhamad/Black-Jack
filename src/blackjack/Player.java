package blackjack;

public class Player {
		private String Name;
		private Card[] handcard=new Card[11];
		public int Score=0;
		public  boolean winner,blackjack,busted;
		public Player(int s) {
			
			Score=s;
		}
		public Player(String n) {
			Name=n;
		}
		public String getName() {
			return Name;
		}
		public int getScore() {
			return Score;
		}
		public Card[] getHandcard() {
			return handcard;
		}
}
