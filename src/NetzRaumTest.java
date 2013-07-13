
public class NetzRaumTest {

	/**Zum Test des Netzwerkraums
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Initialisiere Variablen
		double[] player1={0.3,.3};
		double[] player2={0.7,.5};
		boolean door=false;
		
		//Rufe Raum auf
		NetzwerkRaum.execute(player1, player2, door);
	}

}
