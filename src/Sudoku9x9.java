/**
 * Nom du programme : TN4                                     
 * Fichier : Sudoku9x9.java                                          
 * @author Maxime Drouin                                      
 */

import java.util.BitSet;

public class Sudoku9x9 extends Sudoku {
	
	// Taille du sudoku 9x9
	private static final int TAILLE = 9;
	// Nom du sudoku
	private static final String NOM_SUDOKU = "Sudoku 81 Cases";

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
		super(TAILLE, lesPlacements, laComplexite);
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
	@Override
	public boolean validate() {
		// Vérifie les lignes et les colonnes
		for (int row = 0; row < grille.length; row++) {
			BitSet bsRow = new BitSet(9);
			BitSet bsColumn = new BitSet(9);
			for (int col = 0; col < grille[row].length; col++) {
				if (grille[row][col] == 0 || grille[col][row] == 0)
					continue;
				if (bsRow.get(grille[row][col] - 1)
						|| bsColumn.get(grille[col][row] - 1))
					return false;
				else {
					bsRow.set(grille[row][col] - 1);
					bsColumn.set(grille[col][row] - 1);
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

	/*********************************************************************************/
	/*
	 * Getter pour le nom du Sudoku
	 * 
	 * @return NOM_SUDOKU - Le nom du sudoku
	 */
	/********************************************************************************/
	public static String getNom() {
		return NOM_SUDOKU;
	}

}
