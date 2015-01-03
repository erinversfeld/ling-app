package versveld.erin.ngequizapp;

public class Question {
	
	//In future, will have an image displayed too
	private String questionText;
	private String correctAnswer;
	private String wrongAnswer1;
	private String wrongAnswer2;
	private Integer imageRef;
	private Integer[] soundRefs;
	private int id;
	
	public Question(){
		super();
	}

	//in future, must include the location of the name of the image
	public Question(int id, String q, String a, String wrongAns1, String wrongAns2, Integer imgRef,
					Integer sndRef0, Integer sndRef1, Integer sndRef2) {
		this.id = id;
		questionText = q;
		correctAnswer = a;
		wrongAnswer1 = wrongAns1;
		wrongAnswer2 = wrongAns2;
		imageRef = imgRef;
		soundRefs = new Integer[]{sndRef0, sndRef1, sndRef2};
	}
	
	public int getId(){
		return id;
	}
	
	public String getQuestionText(){
		return questionText;
	}
	
	public String getCorrectAnswer(){
		return correctAnswer;
	}
	
	public String getWrongAnswer1(){
		return wrongAnswer1;
	}

	public String getWrongAnswer2(){
		return wrongAnswer2;
	}

	public Integer getImageRef(){
		return imageRef;
	}

	public Integer[] getSoundRefs(){
		return soundRefs;
	}

	public void setID(int identityNumber){
		this.id = identityNumber;
	}
	
	public void setQuestionText(String newQuestionText){
		questionText = newQuestionText;
	}

	public void setCorrectAnswer(String answer){
		this.correctAnswer = answer;
	}
	
	public void setWrongAnswer1(String newWrongAns1){
		wrongAnswer1 = newWrongAns1;
	}

	public void setWrongAnswer2(String newWrongAns2){
		wrongAnswer2 = newWrongAns2;
	}

	public void setImageRef(Integer newImageRef){
		imageRef = newImageRef;
	}

	public void setSoundRefs(Integer[] newSoundRefs){
		soundRefs = newSoundRefs;
	}
}
