package view;

import model.Alunos;

public class TesteAlunos {

	public static void main(String[] args) {
		Alunos alunos = new Alunos("Ruan",18,55,'M');
		
		System.out.println(alunos.toString());
	}

}
