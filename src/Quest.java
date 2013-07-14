import java.awt.event.KeyEvent;

/**
 * Die Quests Abhängig vom Level
 * 
 */

public class Quest {
	private static int height = 1;
	private static int i = 1;

	/**
	 * Hierüber geschieht der Aufruf aus dem Spiel
	 * 
	 * @throws InterruptedException
	 */

	public static void start() throws InterruptedException {
		Globals.quest.level = Globals.level;
		i = 1;
		if (Globals.quest.level == 1) {
			while (true) {
				// Buffering:
				StdDraw.show(10);
				paint();
				arrow(height);

				if (StdDraw.isKeyPressed(KeyEvent.VK_ENTER)) {
					if (height % 2 == 0) {
						Globals.quest.zeiger = 0;
						Globals.quest.draw = true;
						break;
					} else if (height % 2 == 1) {
						while (true) {

							if (Globals.quest.array[0] == 3
									&& Globals.quest.array[1] == 1
									&& Globals.quest.array[2] == 4
									&& Globals.quest.array[3] == 1) {
								i = 2;
								paint();
								Globals.quest.zeiger = 0;
								Globals.quest.draw = false;
								Globals.npc.npc = false;
								Globals.quest.ready = true;

								// if (StdDraw.hasNextKeyTyped()){
								// if (StdDraw.isKeyPressed(KeyEvent.VK_ENTER)){
								// break;
								// }
								// }
								StdDraw.show(5000);

								break;

							} else {
								i = 3;
								paint();
								Globals.quest.zeiger = 0;
								Globals.quest.draw = true;

								// if (StdDraw.hasNextKeyTyped()){
								// if (StdDraw.isKeyPressed(KeyEvent.VK_ENTER)){
								// break;
								// }
								// }

								StdDraw.show(5000);
								break;
							}
						}

						break;
					}
				}

				if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) {
					if (height % 2 == 1) {
					} else {
						height--;
					}

				} else if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) {
					if (height % 2 == 0) {
					} else {
						height++;
					}
				}
				Thread.sleep(100);
			}

		} else if (Globals.quest.level == 2) {
			while (true) {
				// Buffering:
				StdDraw.show(10);
				paint();
				arrow(height);

				if (StdDraw.isKeyPressed(KeyEvent.VK_ENTER)) {
					if (height % 2 == 0) {
						Globals.quest.zeiger = 0;
						Globals.quest.draw = true;
						break;
					} else if (height % 2 == 1) {
						while (true) {

							if (Globals.quest.array[0] == 5) {
								i = 2;
								paint();
								Globals.quest.zeiger = 0;
								Globals.quest.draw = false;
								Globals.npc.npc = false;
								Globals.quest.ready = true;
								// if (StdDraw.isKeyPressed(KeyEvent.VK_ENTER)){
								// break;
								// }
								StdDraw.show(5000);

								break;

							} else {
								i = 3;
								paint();
								Globals.quest.zeiger = 0;
								Globals.quest.draw = true;

								// boolean
								// hasNextKeyTyped=StdDraw.hasNextKeyTyped();
								// if (hasNextKeyTyped){
								// break;
								// }
								StdDraw.show(5000);
								break;
							}
						}

						break;
					}
				}

				if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) {
					if (height % 2 == 1) {
					} else {
						height--;
					}

				} else if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) {
					if (height % 2 == 0) {
					} else {
						height++;
					}
				}
				Thread.sleep(100);
			}

		} else if (Globals.quest.level == 3) {
			while (true) {
				// Buffering:
				StdDraw.show(10);
				paint();
				Globals.quest.zeiger = 0;
				Globals.quest.draw = true;
				Globals.quest.schalter = true;

				if (StdDraw.isKeyPressed(KeyEvent.VK_ENTER)) {
					break;

				}

				Thread.sleep(100);

			}

		}

	}

	/**
	 * Auf welche Höhe soll der Pfeil gezeichnet werden? Oben oder unten?
	 * 
	 * @param height
	 */
	private static void arrow(int height) {

		if (height % 2 == 1) {
			// Life is chosen
			StdDraw.picture(0.05, .3, "pfeil_rechts.png", .1, .1);
		} else if (height % 2 == 0) {
			// Health is chosen
			StdDraw.picture(0.05, .2, "pfeil_rechts.png", .1, .1);
		}

	}

	/**
	 * Zeichnet Text des Professors
	 */
	private static void paint() {
		// paint Text für Quest
		StdDraw.setPenColor(StdDraw.YELLOW);
		StdDraw.clear(StdDraw.BLACK);

		if (Globals.quest.level == 1) {

			if (i == 1) {
				StdDraw.text(0.5, .9, "Hallo mein junger Student");
				StdDraw.textLeft(0, .85,
						"Ich habe schon auf jemanden, wie dich gewartet.");
				StdDraw.textLeft(0, .8,
						"Ich kann mich einfach nicht mehr an die ersten 4 Ziffern von PI erinnern.");
				StdDraw.textLeft(0, .75,
						"Leider sind sie hier überall verteilt.");
				StdDraw.textLeft(0, .7, "Such sie bitte für mich und");
				StdDraw.textLeft(0, .65,
						"achte darauf sie in der richtigen Reihenfolge einzusammeln.");

				StdDraw.text(0.5, 0.3,
						"Ich habe die Zahlen gefunden, hier sind sie.");
				StdDraw.text(0.5, 0.2, "Ok ich mach mich auf die Suche!");
			} else if (i == 2) {
				StdDraw.textLeft(0, .85, "Danke für deine Hilfe.");
				StdDraw.textLeft(0, .8,
						"Nun kann ich endlich den Kreisumfang berechnen.");
				StdDraw.textLeft(0, .75,
						"Level 2 wartet auf dich, aber zuerst muss du den Boss besiegen.");
			} else if (i == 3) {
				StdDraw.textLeft(0, .85, "Das kann nicht stimmen.");
				StdDraw.textLeft(0, .8, "Geh nochmal los und suche erneut.");
				StdDraw.textLeft(0, .75,
						"Denk dran die Reihenfolge muss stimmen.");
			}

		} else if (Globals.quest.level == 2) {
			if (i == 1) {
				StdDraw.text(0.5, .9,
						"Du hast das erste Level geschafft. Sehr gut!");
				StdDraw.textLeft(0, .85, "Aber ich brauche erneut deine Hilfe.");
				StdDraw.textLeft(0, .8,
						"Ich habe versucht |cos(pi)*5| zulösen.");
				StdDraw.textLeft(0, .75,
						"Wenn du mir die richtige Lösung bringst,");
				StdDraw.textLeft(0, .7,
						"kannst du gegen den Boss von Level 2 kämpfen.");

				StdDraw.text(0.5, 0.3,
						"Ich habe die Lösung bereits gefunden, hier ist sie.");
				StdDraw.text(0.5, 0.2,
						"Ok ich werde versuchen die Aufgabe zulösen und Ihnen das Ergebnis bringen.");
			} else if (i == 2) {
				StdDraw.textLeft(0, .85, "Deine Lösung ist richtig.");
				StdDraw.textLeft(0, .8,
						"Level 3 wartet auf dich, aber zuerst muss du den Boss besiegen.");
			} else if (i == 3) {
				StdDraw.textLeft(0, .85, "Das ist falsch.");
				StdDraw.textLeft(0, .8,
						"Geh nochmal los und suche das richtige Ergebnis.");

			}

		} else if (Globals.quest.level == 3) {
			if (i == 1) {
				StdDraw.textLeft(0, .9,
						"Verdammt ich habe den Schlüssel zu Raum 3 verloren.");
				StdDraw.textLeft(0, .85,
						"Aber irgendwo gab es einen geheimen Schalter.");
				StdDraw.textLeft(0, .8,
						"Finde den Schalter und du wirst in den 3 Raum gelangen,");
				StdDraw.textLeft(0, .75, "um gegen den letzten Boss zukämpfen.");

			}
		}

	}

}
