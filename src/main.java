import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {

	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Gioco newGame = new Gioco();
    newGame.play();
    reader.close();
    
	}

}
