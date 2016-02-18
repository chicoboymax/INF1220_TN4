/**
 * Nom du programme : TN4 
 * Fichier : Case.java
 * 
 * @author Maxime Drouin
 */

public class Case {
	private int row;
	private int col;
	private int ancValeur;
	private int nouValeur;

	/*********************************************************************************/
	/*
	 * Constructeur de la classe 'Case' permettant d'instancier un Objet case
	 * afin de sauvegarder tous les placements
	 * 
	 * @param row - Sur qu'elle ligne faire le placement
	 * 
	 * @param col - Dans qu'elle colonne faire le placement
	 * 
	 * @param ancValeur - Afin de sauvegarder la valeur actuelle de la case
	 * 
	 * @param nouValeur - Spécifie la nouvelle valeur de la case
	 */
	/*********************************************************************************/
	public Case(int row, int col, int ancValeur, int nouValeur) {
		this.setRow(row);
		this.setCol(col);
		this.setAncValeur(ancValeur);
		this.setNouValeur(nouValeur);
	}
	
	/*********************************************************************************/
	/* 
	 * @return
	 */
	/********************************************************************************/
	public int getAncValeur() {
		return ancValeur;
	}
	
	/*********************************************************************************/
	/* 
	 * @param
	 */
	/********************************************************************************/
	public void setAncValeur(int ancValeur) {
		this.ancValeur = ancValeur;
	}
	
	/*********************************************************************************/
	/* 
	 * @return
	 */
	/********************************************************************************/
	public int getNouValeur() {
		return nouValeur;
	}
	
	/*********************************************************************************/
	/* 
	 * @param
	 */
	/********************************************************************************/
	public void setNouValeur(int nouValeur) {
		this.nouValeur = nouValeur;
	}
	
	/*********************************************************************************/
	/* 
	 * @return
	 */
	/********************************************************************************/
	public int getRow() {
		return row;
	}
	
	/*********************************************************************************/
	/* 
	 * @param
	 */
	/********************************************************************************/
	public void setRow(int row) {
		this.row = row;
	}
	
	/*********************************************************************************/
	/* @return
	 */
	/********************************************************************************/
	public int getCol() {
		return col;
	}
	
	/*********************************************************************************/
	/* 
	 * @param
	 */
	/********************************************************************************/
	public void setCol(int col) {
		this.col = col;
	}

}
