import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;


public class Gioco {

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	Giocatore player = new Giocatore();
	int ficheIniziali;
	String nomegiocatore;
	int fichePuntata;
	ArrayList<String> carte = new ArrayList<>();
	double punteggioGiocatore = 0.0;
	double punteggioBanco = 0.0;
	Random random = new Random();
	
	public void play() throws IOException, NumberFormatException, InterruptedException {
		
		datiGiocatore();
		PrimaCartaePuntata();
		restaoGioca();
	}
	
	
	public void datiGiocatore() throws IOException {
		
		// inseriamo i dati giocatore gestendo input errato
		
		System.out.println("Benvenuto nel sette e mezzo Generation \n");
		
		while(true) {
			System.out.println("Inserisci il tuo nome giocatore");
			nomegiocatore = reader.readLine();
			
			if(nomegiocatore.length() >= 2) 
				break;
			System.out.println("Il nome del giocatore deve avere almeno due lettere");
			
		}
		
		// inseriamo le fiche da cambiare gestendo input errato
		
		System.out.println("\nCiao " + nomegiocatore);
		
		while(true) {
		try {
			System.out.println("Quante fiches vuoi cambiare ?" );
			ficheIniziali = Integer.parseInt(reader.readLine());
			player.setFicheIniziali(ficheIniziali);
			
			if (player.getFicheIniziali() >= 10) {

		        break;
		    } else {
		    	System.out.println("Il numero di fiches iniziali deve essere almeno 10");
		    }
							
			
		} catch (Exception e) {
			System.out.println("Devi inserire un numero !");

		} 
		}
		
	}
	
	public void PrimaCartaePuntata() throws NumberFormatException, IOException{
		    // prima carta e puntata 
				
				punteggioGiocatore = 0;
		
				System.out.println("\nComincia il gioco!");
				
			    System.out.println("\nEccoti la prima carta ");
			    
			    for ( int i = 1; i < 11 ; i++) {
					carte.add(i + " di Coppe");
					carte.add(i + " di Spade");
					carte.add(i + " di Bastoni");
					carte.add(i + " di Denari");
				}
				 
			    
			    String CartaRicevuta = carte.get(random.nextInt(carte.size()));
			    
			    System.out.println("\nLa carta uscita è: " + CartaRicevuta);
				
			
				
				/* codice scritto da me
				 * for ( int i = 0; i < carte.size(); i++ ){
					
					if (i >= 0 && i < 7 || i >= 10 && i < 17 || i >= 20 && i < 27 || i >= 30 && i < 37) {
						if (CartaRicevuta.equals(carte.get(i+1))) {
						punteggioGiocatore = (int)carte.get(i+1).charAt(0);
						carte.remove(CartaRicevuta);
					} 
						
					} else if (i > 6 && i < 10 || i > 16 && i < 20 || i > 26 && i < 30 || i >= 36 && i < 40) {
						if (CartaRicevuta.equals(carte.get(i+1))) {
							punteggioGiocatore += 0.5 ;
							carte.remove(CartaRicevuta);
						}
					}
				}*/
			    
			    for (int i = 0; i < carte.size(); i++) {
			        String carta = carte.get(i);
			        if (CartaRicevuta.equals(carta)) {
			            if (carta.contains("8") || carta.contains("9") || carta.contains("10")) {
			                punteggioGiocatore += 0.5;
			            } else {
			                int valoreCarta = Integer.parseInt(carta.substring(0, carta.indexOf(" ")));
			                punteggioGiocatore += valoreCarta;
			            }
			            carte.remove(i);
			            break; // Esci dal ciclo una volta trovata e trattata la carta
			        }
			    }
			    
				
			    System.out.println("\nIl tuo punteggio è: " + punteggioGiocatore);
				
			    while(true) {
			    	
			    System.out.println("\nVuoi continuare con la puntata ? Digita 1 per continuare o 2 per ricominciare la partita");
			    
			    String scelta = reader.readLine();
			    
			    
			    if (scelta.equals("2")) {PrimaCartaePuntata();} 
			    else if (scelta.equals("1")) {
			    	break;
			    	
			    } else {
			    	System.out.println("Input Inserito Errato");
			    
			    }
			    
			    }
			    
			    
				System.out.println("Quante fiches vuoi puntare ?");
				
				
				while (true) {
							
				
				try {
					fichePuntata = Integer.parseInt(reader.readLine());
					
					if (fichePuntata > player.getFicheIniziali()) {
						System.out.println("Non puoi puntare più fiches di quelle che possiedi!");
						player.setFichePuntata(player.getFicheIniziali());
						System.out.println("La puntata iniziale è stata resa pari alle fiches possedute");
						break;
					} else {
		                player.setFichePuntata(fichePuntata);
		            }
					break;
					
				} catch (Exception e) {
					
					System.out.println("Input immesso errato , devi inserire un numero");
					
				}
				
				}

				
				System.out.println("Hai puntato: " + player.getFichePuntata());
				System.out.println("Il tuo punteggio attuale è: " + punteggioGiocatore);
				
	}
		
	
	
	

	
	public void restaoGioca() throws NumberFormatException, IOException, InterruptedException {

	punteggioBanco = 0;
  
	
    	if (punteggioGiocatore > 7.5) {
    		System.out.println("Hai superato 7.5!");
    		player.setFicheIniziali(player.getFicheIniziali() - player.getFichePuntata());
    		System.out.println("Ora le tue fiches sono: " + player.getFicheIniziali());
    	
    		if (player.getFicheIniziali() == 0) {
    			System.out.println("La tue fiches sono a zero. Game over!");
    			carte.clear();
    			play();  //questo è il metodo generale per reiniziare tutto
    			
    		} 
 
    		
    	Finemano();
    		
    	// ho chiuso l'if punteggio maggiore di 7.5 , sto ancora nel while
    		
        } else { 
    	
       while (true) {


    		System.out.println("Resti o vuoi un altra carta? \nDigita 1 per restare o 2 per avere un altra carta");
		
    		String restareoCarta = reader.readLine();
				
    		if (restareoCarta.equals("1")) {
    			
    			while(punteggioBanco < punteggioGiocatore) {
    				//aggiungere limite di 12
    				//fare il test per vedere cosa succede se aggiungo sempre carte : se aggiungo un altra carta
    				//esce scritto hai vinto , ma deve uscire scritto solo Resti o vuoi un altra carta? 
    				//Digita 1 per restare o 2 per avere un altra carta
    				//Poi se perdo mi vengono tolti il doppio dei soldi 
    				
    				String CartaBanco = carte.get(random.nextInt(carte.size()));
			    
			    	System.out.println("La carta uscita è: " + CartaBanco);
			    
			 
			    	for (int i = 0; i < carte.size(); i++) {
				        String carta = carte.get(i);
				        if (CartaBanco.equals(carta)) {
				            if (carta.contains("8") || carta.contains("9") || carta.contains("10")) {
				                punteggioBanco += 0.5;
				            } else {
				                int valoreCarta = Integer.parseInt(carta.substring(0, carta.indexOf(" ")));
				                punteggioBanco += valoreCarta;
				            }
				            carte.remove(i);
				            break; // Esci dal ciclo una volta trovata e trattata la carta
				        }
				    }
			    	System.out.println("Il punteggio del banco é " + punteggioBanco);
    			}
    			
    			
    		} else if (restareoCarta.equals("2")) {
    			
    			 String CartaRicevuta = carte.get(random.nextInt(carte.size()));
 			    
 			     System.out.println("La carta uscita è:" + CartaRicevuta);
 			    
 			    for (int i = 0; i < carte.size(); i++) {
			        String carta = carte.get(i);
			        if (CartaRicevuta.equals(carta)) {
			            if (carta.contains("8") || carta.contains("9") || carta.contains("10")) {
			                punteggioGiocatore += 0.5;
			            } else {
			                int valoreCarta = Integer.parseInt(carta.substring(0, carta.indexOf(" ")));
			                punteggioGiocatore += valoreCarta;
			            }
			            carte.remove(i);
			            break; // Esci dal ciclo una volta trovata e trattata la carta
			        }
			    }
 			    
 			   System.out.println("\nIl tuo punteggio è: " + punteggioGiocatore);
    			
    		} else {
    			System.out.println("Scelta sbagliata");
    			restaoGioca();
    		}
    	
    	if (punteggioGiocatore > punteggioBanco && punteggioGiocatore <= 7.5 && punteggioBanco > 0) {
    		System.out.println("Hai vinto!");
    		player.setFicheIniziali(player.getFicheIniziali() + player.getFichePuntata());
    	    System.out.println("Le tue fiches attuali sono: " + player.getFicheIniziali());
    		Finemano();
    		
    	} else if (punteggioBanco > 7.5) {
    		System.out.println("Hai vinto!");
    		player.setFicheIniziali(player.getFicheIniziali() + player.getFichePuntata());
    	    System.out.println("Le tue fiches attuali sono: " + player.getFicheIniziali());
    		Finemano();
    		
    	
    	} else if ( punteggioBanco > punteggioGiocatore && punteggioBanco <= 7.5 ) {
    		System.out.println("Hai perso!");
    		player.setFicheIniziali(player.getFicheIniziali() - player.getFichePuntata());
    		System.out.println("Le tue fiches attuali sono: " + player.getFicheIniziali());
    		Finemano();
    		 
    		
    	}
    	
    	
    	if (player.getFicheIniziali() == 0) {
			System.out.println("La tue fiches sono a zero. Game over!");
			carte.clear();
			play();  //questo è il metodo generale per reiniziare tutto
			break;
    	
    	
		}
		
		}
	
	}
    

	}


	public void Finemano() throws IOException, NumberFormatException, InterruptedException {
		System.out.println("Cosa vuoi fare ? Digita 1 per giocare un altra mano, "
    			+ "2 per cambiare le tue fiches in soldi e uscire dal gioco");
    		
    	String sceltaFineMano = reader.readLine();
    		
    		if (sceltaFineMano.equals("1")) {
    			carte.clear(); //rimuove tutti gli elementi dalla lista
    			while(true) {
    				PrimaCartaePuntata();
    				restaoGioca();}
    		        
    		} else if (sceltaFineMano.equals("2")) {
    			System.out.println("Cambio in corso..." );
    			Thread.sleep(4000);
    			System.out.println("Il tuo saldo è: " + ficheIniziali + " euro");
    			System.out.println("Grazie di aver giocato!");
    			System.exit(0);
    		} else {
    			System.out.println("Scelta errata");
    			Finemano();
    		}
	}


}


