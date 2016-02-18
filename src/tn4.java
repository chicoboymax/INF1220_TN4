/**
 * Nom du programme : TN4                                     
 * Fichier : TN4.java                                          
 * @author Maxime Drouin                                      
 */

public class tn4 {

	public static void main(String[] args) {

		// Créer une instance de la classe Sudoku9x9
		Sudoku9x9 sudoku9x9 = new Sudoku9x9(0, 0);
		// Imprimer la grille de Sudoku d'origine;
		System.out
				.println("\n*********************************************************************************");
		System.out.println("** Grille de Sudoku d'origine **");
		System.out
				.println("*********************************************************************************");
		sudoku9x9.imprimerGrille();

		// Imprimer le degré de difficulté de la grille
		System.out
				.println("\n*********************************************************************************");
		System.out.println("** Complexité **");
		System.out
				.println("*********************************************************************************");
		System.out.println(sudoku9x9.getComplexite());  

		// Effectuer 10 placements

		sudoku9x9.fairePlacement(0, 0, 1);
		sudoku9x9.fairePlacement(1, 1, 2);
		sudoku9x9.fairePlacement(2, 2, 3);
		sudoku9x9.fairePlacement(3, 3, 4);
		sudoku9x9.fairePlacement(4, 4, 5);
		sudoku9x9.fairePlacement(5, 5, 6);
		sudoku9x9.fairePlacement(6, 6, 7);
		sudoku9x9.fairePlacement(0, 7, 8);
		sudoku9x9.fairePlacement(8, 8, 9);
		sudoku9x9.fairePlacement(0, 1, 1);

		// Imprimer la grille de Sudoku suite aux placements
		System.out
				.println("\n*********************************************************************************");
		System.out.println("** Grille de Sudoku après 10 placements **");
		System.out
				.println("*********************************************************************************");
		sudoku9x9.imprimerGrille();

		// Annuler 2 placements
		sudoku9x9.annulerPlacement();
		sudoku9x9.annulerPlacement();
		System.out
				.println("\n*********************************************************************************");
		System.out
				.println("** Grille de Sudoku après 2 annulations de placements **");
		System.out
				.println("*********************************************************************************");

		// Imprimer la grille de Sudoku suite à l’annulation
		sudoku9x9.imprimerGrille();

		// Valider la solution et imprimer le résultat de la validation.
		System.out
				.println("\n*********************************************************************************");
		System.out.println("** Validation de la grille de Sudoku **");
		System.out
				.println("*********************************************************************************");
		if (sudoku9x9.validate()) {
			System.out.println("La grille est valide !\n");
		} else {
			System.out.println("La grille est invalide !\n");
		}
		;

		// Réinitialise la grille à la grille d'origine (Pas demandé dans description du travail noté)
		sudoku9x9.reInitialiser();
		System.out
				.println("\n*********************************************************************************");
		System.out.println("** EXTRA - Grille de Sudoku après réinitialisation à la grille d'origine **");
		System.out
				.println("*********************************************************************************");
		sudoku9x9.imprimerGrille();
	}

}
