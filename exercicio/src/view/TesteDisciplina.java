package view;

import model.Disciplina;

public class TesteDisciplina {

	public static void main(String[] args) {
		Disciplina disciplina = new Disciplina("Dallas","Ruan",3,true);
		
		System.out.println(disciplina.toString());
	}

}
