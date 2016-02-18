/**
 * Nom du programme : TN4                                      
 * Fichier : Sudoku.java                                          
 * @author Maxime Drouin                                      
 */

import java.util.ArrayList;

public abstract class Sudoku {
	// Matrice de nombre entier représentant la grille de Sudoku
	protected final int[][] grille;
	// Une liste d’action de placement
	private ArrayList<Case> historiquePlacements = new ArrayList<>();
	// La taille du jeu
	private int n;
	// Le degré de complexité de la grille
	private int complexite;
	// Attribut indiquant le nombre de chiffre restant à placer dans la grille
	private int placements;

	
	/*********************************************************************************/
	/* Constructeur de la classe Sudoku permattent d'instancier un objet Sudoku.
	 * protected, car la méthode ne peut être utilisée que par les sous-classes.
	 * Cette méthode est déclarée dans la superclasse, car elle commune à tous les types
	 * de Sudoku.
	 * 
	 * @param n - La taille du Sudoku
	 * @param lesPlacements - Les placemments restants à placer dans la grille
	 * @param laComplexite - Le niveau de complexité du Sudoku
	 */
	/*********************************************************************************/
	protected Sudoku(int n, int lesPlacements, int laComplexite) {
		this.grille = new int[n][n];
		this.n = n;
		this.setPlacements(lesPlacements);
		this.setComplexite(laComplexite);
		this.initialiser();

	}

	/*********************************************************************************/
	/* Méthode permettant d'initialiser la grille sudoku à 0. Private, car pour l'instant
	 * est seulement utilisée par le constructeur. 
	 * 
	 */
	/*********************************************************************************/
	private void initialiser() {
		for (int row = 0; row < grille.length; row++) {
			for (int col = 0; col < grille[row].length; col++) {
				grille[row][col] = 0;
			}
		}
	}

	/*********************************************************************************/
	/* Méthode permettant de ré-initialiser la grille sudoku à sa valeur d'origine. 
	 * protected, car la méthode ne peut être utilisée que par les sous-classes. 
	 * Cette méthode est déclarée dans la superclasse, car elle commune à tous les types
	 * de Sudoku.
	 */
	/*********************************************************************************/
	protected void reInitialiser() {
		for (int i = this.historiquePlacements.size(); i > 0; i--) {
			Case placement = this.historiquePlacements.get(this.historiquePlacements
					.size() - i);
			int row = placement.getRow();
			int col = placement.getCol();
			int ancValeur = placement.getAncValeur();
			this.grille[row][col] = ancValeur;
			this.historiquePlacements.remove(this.historiquePlacements.size() - i);
		}
	}

	/*********************************************************************************/
	/* Méthode utlisée pour changé la valeur d'une case de la grille
	 * 
	 * @param row - Indique sur qu'elle ligne on désire faire le placement
	 * @param col - Indique sur qu'elle colonne on désire faire le placement
	 * @param valeur - La valeur que l'on désire placer dans la colonne
	 */
	/*********************************************************************************/
	protected void fairePlacement(int row, int col, int valeur) {
		int n = this.getN();
		if (row >= n || col >= n) {
			System.out.println("Case invalide");
		} else {
			Case placement = new Case(row, col, this.grille[row][col], valeur);
			this.historiquePlacements.add(placement);
			this.grille[row][col] = valeur;
		}

	}

	/*********************************************************************************/
	/* 
	 */
	/********************************************************************************/
	protected void annulerPlacement() {
		Case placement = this.historiquePlacements
				.get(this.historiquePlacements.size() - 1);
		int row = placement.getRow();
		int col = placement.getCol();
		int ancValeur = placement.getAncValeur();
		this.grille[row][col] = ancValeur;
		this.historiquePlacements.remove(this.historiquePlacements.size() - 1);
	}

	/*********************************************************************************/
	/* 
	 */
	/********************************************************************************/
	protected void imprimerGrille() {
		String temp = "";
		for (int row = 0; row < grille.length; row++) {
			temp += " \n ";
			for (int col = 0; col < grille[row].length; col++) {
				temp += " " + Integer.toString(grille[row][col]);
			}
		}
		System.out.println(temp);
	}

	/*********************************************************************************/
	/* 
	 * @return
	 */
	/********************************************************************************/
	protected int calculerPlacements() {
		for (int row = 0; row < grille.length; row++) {
			for (int col = 0; col < grille[row].length; col++) {
				if (grille[row][col] == 0) {
					placements++;
				}
				;
			}
		}
		return placements;
	}

	/*********************************************************************************/
	/* 
	 * @return
	 */
	/********************************************************************************/
	protected abstract boolean validate();
	
	/*********************************************************************************/
	/* 
	 * @return
	 */
	/********************************************************************************/
	protected int getComplexite() {
		return complexite;
	}
	
	/*********************************************************************************/
	/* 
	 * @param
	 */
	/********************************************************************************/
	protected void setComplexite(int complexite) {
		this.complexite = complexite;
	}
	
	/*********************************************************************************/
	/* 
	 * @return
	 */
	/********************************************************************************/
	protected int getPlacements() {
		return placements;
	}
	
	/*********************************************************************************/
	/* 
	 * @param
	 */
	/********************************************************************************/
	protected void setPlacements(int placements) {
		this.placements = placements;
	}
	
	/*********************************************************************************/
	/* 
	 * @return
	 */
	/********************************************************************************/
	protected int getN() {
		return n;
	}
	
	/*********************************************************************************/
	/* 
	 * @param
	 */
	/********************************************************************************/
	protected void setN(int n) {
		this.n = n;
	}

}
