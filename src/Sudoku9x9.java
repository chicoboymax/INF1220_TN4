/**
 * Nom du programme : TN4                                     
 * Fichier : Sudoku9x9.java                                          
 * @author Maxime Drouin                                      
 */

import java.util.BitSet;

public class Sudoku9x9 extends Sudoku {

	/*********************************************************************************/
	/*
	 * Constructeur de la classe Sudoku9x9 permattent d'instancier un objet
	 * Sudoku.
	 * 
	 * Appelle la méthode de classe mère avec 'super' et lui passe en paramètre
	 * une taille '9'.
	 * 
	 * Est public, car doit pouvoir être appellée par la classe main.
	 * 
	 * @param lesPlacements - Les placemments restants à placer dans la grille
	 * 
	 * @param laComplexite - Le niveau de complexité du Sudoku
	 */
	/*********************************************************************************/

	public Sudoku9x9(int lesPlacements, int laComplexite) {
		super(9, lesPlacements, laComplexite);
	}

	/*********************************************************************************/
	/*
	 * Méthode pour valider la grille déclarée dans la classe sudoku9x9, car la
	 * validation est différente d'une grille à l'autre.
	 * 
	 * Est public, car doit pouvoir être appellée par la classe main.
	 * 
	 * @return boolean - Si la grille est valide ou non
	 */
	/*********************************************************************************/

	// Override la méthode abstract 'validate' de la superclasse 'Sudoku'
	@Override
	public boolean validate() {
		// Vérifie les lignes et les colonnes
		for (int i = 0; i < grille.length; i++) {
			BitSet bsRow = new BitSet(9);
			BitSet bsColumn = new BitSet(9);
			for (int j = 0; j < grille[i].length; j++) {
				if (grille[i][j] == 0 || grille[j][i] == 0)
					continue;
				if (bsRow.get(grille[i][j] - 1)
						|| bsColumn.get(grille[j][i] - 1))
					return false;
				else {
					bsRow.set(grille[i][j] - 1);
					bsColumn.set(grille[j][i] - 1);
				}
			}
		}

		// Vérifie les quadrants (3x3)
		for (int row = 0; row < 9; row += 3) {
			for (int col = 0; col < 9; col += 3) {
				BitSet bsQuadrant = new BitSet(9);
				for (int i = row; i < row + 3; i++) {
					for (int j = col; j < col + 3; j++) {
						if (grille[i][j] == 0)
							continue;
						if (bsQuadrant.get(grille[i][j] - 1))
							return false;
						else
							bsQuadrant.set(grille[i][j] - 1);
					}
				}
			}
		}
		return true;
	}

}
