package GUI;

import java.util.Comparator;
/**
 * Clase que representa el comparador de los puntajes de los jugadores.
 * @author Tomás Perotti - Iván Petrini
 *
 */
public class ScoreComparator implements Comparator<Score> {
	
	
        public int compare(Score score1, Score score2) {

            int h1 = score1.getHoras();
            int h2 = score2.getHoras();
            int m1 = score1.getMin();
            int m2 = score2.getMin();
            int s1 = score1.getSeg();
            int s2 = score2.getSeg();
            

            if (h1 < h2)
                return -1;
            else if (h2 < h1)
                	return 1;
            	else if (m1 < m2)
            			return -1;
            		else if (m2 < m1)
            				return 1;
            			else if (s1 < s2)
            				return -1;
            				else if (s2 < s1) 
            						return 1;
            					else return 0;
            
        }
}