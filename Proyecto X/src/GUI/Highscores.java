package GUI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
/**
 * Clase que representa los mayores resultados logrados por el usuario durante el juego.
 * @author Tomás Perotti - Iván Petrini
 *
 */
public class Highscores {

    private ArrayList<Score> scores;
	@SuppressWarnings("unused")
	private static final long serialVersionUID = -3484711864026060041L;
    private static final String HIGHSCORE_FILE = "scores.txt";

    ObjectOutputStream outputStream = null;
    ObjectInputStream inputStream = null;
    /**
     * Constructor que inicializa el arreglo de Score.
     */
    public Highscores() {
        scores = new ArrayList<Score>();
    }
	/**
	 * Método que retorna los scores de los juegadores.
	 * @return scores
	 */
    public ArrayList<Score> getScores() {
        loadScoreFile();
        sort();
        return scores;
    }
	
    private void sort() {
        ScoreComparator comparator = new ScoreComparator();
        Collections.sort(scores, comparator);
    }
    /**
     * Método que agrega un score al arreglo de scores.
     * @param score
     */
    public void addScore(Score s) {
        loadScoreFile();
        scores.add(s);
        updateScoreFile();
    }
    /**
     * Método que carga en la pantalla los highscores del juego.
     */
    @SuppressWarnings("unchecked")
	public void loadScoreFile() {
        try { if (!HIGHSCORE_FILE.isEmpty()){
        	inputStream = new ObjectInputStream(new FileInputStream(HIGHSCORE_FILE));           
            scores = (ArrayList<Score>) inputStream.readObject();
        }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
            }
        }
    }
   /**
    * Método que actualiza los highscores del juego.     
    */
    public void updateScoreFile() {
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(HIGHSCORE_FILE));
            outputStream.writeObject(scores);
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
           } catch (IOException e) {

            }
        }
    }
    /**
     * Método que retorna un string con el highscore del juego.
     * @return string
     */
    public String getHighscoreString() {
        String highscoreString = "";
        int max = 8;

        ArrayList<Score> scores;
        scores = getScores();

        int i = 0;
        int x = scores.size();
        if (x > max) {
            x = max;
        }
        while (i < x) {
            highscoreString += (i + 1) +") "+ String.format("%02d",scores.get(i).getHoras() )+ ": " +String.format("%02d",scores.get(i).getMin()) +": "+String.format("%02d",scores.get(i).getSeg())+"\n";
            i++;
        }
        return highscoreString;
    }
}

