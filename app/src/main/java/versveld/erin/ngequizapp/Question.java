package versveld.erin.ngequizapp;

public class Question {
	
	private String question;
	private String answer;
	private int ID;
	
	public Question(){
		question = "no question set";
		answer = "no answer";
		ID = 0;
	}
	
	public Question(String q, String a){
		question = q;
		answer = a;

	}
	
	public String getQuestion(){
		return question;
	}
	
	public String getAnswer(){
		return answer;
	}
	
	public int getID(){
		return ID;
	}
	
	public void setQuestion(String q){
		question = q;
	}
	
	public void setAnswer(String a){
		answer = a;
	}
	
	public void setID(int idNum){
		ID = idNum;
	}
}
