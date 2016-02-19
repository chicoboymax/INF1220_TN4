/**
 * Nom du programme : TN4                                      
 * Fichier : Sudoku.java                                          
 * @author Maxime Drouin                                      
 */

import java.util.ArrayList;

public abstract class Sudoku {
	// Matrice de nombre entier représentant la grille de Sudoku
	protected int[][] grille;
	// Une liste d’action de placement
	private ArrayList<Case> historiquePlacements = new ArrayList<>();
	// La taille du jeu
	private int taille;
	// Le degré de complexité de la grille
	private int complexite;
	// Attribut indiquant le nombre de chiffre restant à placer dans la grille
	private int placements;

	/*********************************************************************************/
	/*
	 * Constructeur de la classe Sudoku permattent d'instancier un objet Sudoku.
	 * protected, car la méthode ne peut être utilisée que par les sous-classes.
	 * Cette méthode est déclarée dans la superclasse, car elle commune à tous
	 * les types de Sudoku.
	 * 
	 * @param taille - La taille du Sudoku
	 * 
	 * @param lesPlacements - Les placemments restants à placer dans la grille
	 * 
	 * @param laComplexite - Le niveau de complexité du Sudoku
	 */
	/*********************************************************************************/
	protected Sudoku(int taille, int lesPlacements, int laComplexite) {
		this.grille = new int[taille][taille];
		this.taille = taille;
		this.setPlacements(lesPlacements);
		this.setComplexite(laComplexite);
		this.initialiser();

	}

	/*********************************************************************************/
	/*
	 * Méthode permettant d'initialiser la grille sudoku à 0. Private, car pour
	 * l'instant est seulement utilisée par le constructeur.
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
	/*
	 * Méthode permettant de ré-initialiser la grille sudoku à sa valeur
	 * d'origine. protected, car la méthode ne peut être utilisée que par les
	 * sous-classes. Cette méthode est déclarée dans la superclasse, car elle
	 * commune à tous les types de Sudoku.
	 */
	/*********************************************************************************/
	protected void reInitialiser() {
		for (int i = this.historiquePlacements.size(); i > 0; i--) {
			Case placement = this.historiquePlacements
					.get(this.historiquePlacements.size() - i);
			int row = placement.getRow();
			int col = placement.getCol();
			int ancValeur = placement.getAncValeur();
			this.grille[row][col] = ancValeur;
			this.historiquePlacements.remove(this.historiquePlacements.size()
					- i);
		}
	}

	/*********************************************************************************/
	/*
	 * Méthode utlisée pour changé la valeur d'une case de la grille
	 * 
	 * @param row - Indique sur qu'elle ligne on désire faire le placement
	 * 
	 * @param col - Indique sur qu'elle colonne on désire faire le placement
	 * 
	 * @param valeur - La valeur que l'on désire placer dans la colonne
	 */
	/*********************************************************************************/
	protected void fairePlacement(int row, int col, int valeur) {
		int taille = this.getTaille();
		if (row >= taille || col >= taille) {
			System.out.println("Case invalide");
		} else {
			Case placement = new Case(row, col, this.grille[row][col], valeur);
			this.historiquePlacements.add(placement);
			this.grille[row][col] = valeur;
		}

	}

	/*********************************************************************************/
	/*
	 * Méthode utilisée pour annuler le dernier placement Protected, car
	 * utilisée seulement par les sous-classes. Dans Sudoku.java, car le
	 * fonctionnement est commun pour tous les types de Sudoku
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
	 * Méthode utilisée pour imprimer la grille de sudoku dans le terminal
	 * 
	 * Protected, car utilisée seulement par les sous-classes. Dans Sudoku.java,
	 * car le fonctionnement est commun pour tous les types de Sudoku
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
	 * Méthode pour calculer le nom de placements restant à faire dans la grille
	 * 
	 * Protected, car utilisée seulement par les sous-classes. Dans Sudoku.java,
	 * car le fonctionnement est commun pour tous les types de Sudoku
	 * 
	 * @return placements - le nombre de cases vide dans la grille.
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
	 * Méthode pour vérifier si la grille de Sudoku est valide Protected, car
	 * utilisée seulement par les sous-classes. Abstract, car la validation est
	 * différente pour chaque type de sudoku.
	 * 
	 * @return boolean - si la grille est valide ou non
	 */
	/********************************************************************************/
	protected abstract boolean validate();

	/*********************************************************************************/
	/*
	 * Méthode pour afficher si la grille est valide ou non, elle appelle la
	 * méthode validate(). Protected, car seulement disponible pour les sous-classes.
	 */
	/********************************************************************************/
	protected void validateGrid() {
		if (validate()) {
			System.out.println("La grille est valide !\n");
		} else {
			System.out.println("La grille est invalide !\n");
		}
		;
	};

	/*********************************************************************************/
	/*
	 * Getter pour la complexité Protected, car utilisée seulement par les
	 * sous-classes.
	 * 
	 * @return complexite - La complexite du Sudoku
	 */
	/********************************************************************************/
	protected int getComplexite() {
		return complexite;
	}

	/*********************************************************************************/
	/*
	 * Setter pour la complexite Protected, car utilisée seulement par les
	 * sous-classes.
	 * 
	 * @param complexite - La complexité du Sudoku
	 */
	/********************************************************************************/
	protected void setComplexite(int complexite) {
		this.complexite = complexite;
	}

	/*********************************************************************************/
	/*
	 * Getter pour les placements Protected, car utilisée seulement par les
	 * sous-classes.
	 * 
	 * @return placements - Les placements restants à faire dans la grille
	 */
	/********************************************************************************/
	protected int getPlacements() {
		return placements;
	}

	/*********************************************************************************/
	/*
	 * Setter pour les placements Protected, car utilisée seulement par les
	 * sous-classes.
	 * 
	 * @param placements - Les placements restants à faire dans la grille
	 */
	/********************************************************************************/
	protected void setPlacements(int placements) {
		this.placements = placements;
	}

	/*********************************************************************************/
	/*
	 * Getter pour la taille de la grille Protected, car utilisée seulement par
	 * les sous-classes.
	 * 
	 * @return taille - Le nombre de case en largeur et hauteur de la grille
	 */
	/********************************************************************************/
	protected int getTaille() {
		return taille;
	}

	/*********************************************************************************/
	/*
	 * Setter pour la taille de la grille Protected, car utilisée seulement par
	 * les sous-classes.
	 * 
	 * @param taille - Le nombre de case en largeur et hauteur de la grille
	 */
	/********************************************************************************/
	protected void setTaille(int taille) {
		this.taille = taille;
	}

}
