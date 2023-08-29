Traccia Extra - Sette e mezzo : esercizio svolto in solitaria 

Realizzare un programma che simuli il gioco del "Sette e mezzo", nel quale il giocatore tenta
di vincere avvicinandosi il più possibile al valore 7 e mezzo sommando i punti delle carte
richieste:
 le carte dall'asso al 7 valgono il valore della carta (l'asso vale 1);
 le figure (8, 9, 10) valgono mezzo punto.
Il gioco si svolge ottenendo una carta e decidendo se "restare" o chiederne un'altra, finché
non si "sballa" (superando il 7 e mezzo) o si decide di restare.
Dopo aver deciso che il punteggio ottenuto è soddisfacente, il giocatore "resta" e, se non ha
"sballato", il banco effettua la propria giocata, mediante un random() che fornisce un
punteggio tra [4, 4.5, 5, 5.5, 6, 6.5, 7, 7.5, 8], con 8 che equivale ad aver "sballato" con
vincita automatica del giocatore.
Il gioco richiede l'implementazione del mazzo di 40 carte che, una volta estratte e assegnate
al giocatore, vanno tolte dal mazzo e non possono più essere estratte.
Dopo ogni partita, si raccolgono tutte le carte distribuite e il mazzo viene ricomposto per una
nuova mano.
Funzionalità da implementare del "Sette e mezzo Java":
 A inizio gioco, il giocatore decide un'unica volta quanti soldi cambiare in fiches.
 Dopo aver ricevuto la prima carta decide quante fiches puntare, se più di quante ne
possiede, il programma considera tutte quelle che ha, con un messaggio di avviso;
tali fiches vanno sottratte subito al giocatore.
 Quando il giocatore non "sballa" ma "resta" con un certo punteggio, il banco effettua
la propria giocata, dalla quale si evince il vincitore:
o Il giocatore se aveva realizzato un punteggio maggiore di quello del banco; in
tal caso ottiene il doppio delle fiches puntate.
o Il banco se realizza senza "sballare" un punteggio maggiore o uguale a quello
del giocatore.
 Dopo ogni mano, il giocatore deve avere la possibilità di uscire dal gioco cambiando
le fiches rimastegli in soldi.
 Dopo ogni mano, il mazzo va ricostituito.
 La partita termina all'uscita volontaria del giocatore con almeno una fiche residua,
oppure se esaurisce tutte le fiches cambiate a inizio partita.