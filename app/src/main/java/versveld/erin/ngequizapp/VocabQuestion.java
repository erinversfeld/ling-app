package versveld.erin.ngequizapp;

public class VocabQuestion extends Question{
	
	//In future, will have an image displayed too
	private String vocabQuestion;
	private String correctAnswer;
	private String wrongAnswer1;
	private String wrongAnswer2;
	private int ID;
	
	public VocabQuestion(){
		super();
	}

	//in future, must include the location of the name of the image
	public VocabQuestion(String q, String a, String wrongAns1, String wrongAns2) {
		super(q, a);
		vocabQuestion = q;
		correctAnswer = a;
		//image = new QuestionImage(imageDirectory);
		wrongAnswer1 = wrongAns1;
		wrongAnswer2 = wrongAns2;
	}
	
	public int getId(){
		return ID;
	}
	
	public String getQuestion(){
		return vocabQuestion;
	}
	
	public String getAnswer(){
		return correctAnswer;
	}
	
	/*public String getImageDirectory(){
		return image.getImageDirectory();
	}*/
	
	public String getWrongAnswer1(){
		return wrongAnswer1;
	}
	
	public String getWrongAnswer2(){
		return wrongAnswer2;
	}
	
	public void setID(int identityNumber){
		ID = identityNumber;
	}
	
	public void setQuestion(Question newQuestion){
		vocabQuestion = newQuestion.getQuestion();
	}
	
	public void setQuestion(String newQuestion){
		vocabQuestion = newQuestion;
	}
	
	public void setAnswer(String newOption){
		correctAnswer = newOption;
	}
	
	/*public void setImageDirectory(String newDirectory){
		image.setImageDirectory(newDirectory);
	}*/
	
	public void setWrongAnswer1(String newWrongAns1){
		wrongAnswer1 = newWrongAns1;
	}
	
	public void setWrongAnswer2(String newWrongAns2){
		wrongAnswer2 = newWrongAns2;
	}
}
