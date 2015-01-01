package versveld.erin.ngequizapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

public class QuizActivity extends Activity {

	List<VocabQuestion> questionList;
	
	int score = 0;
	int questionID = 0;
	
	VocabQuestion currentQuestion;
	TextView textQuestion;
	RadioButton rCAns, rWAns1, rWAns2;
	Button buttonNext;
	QuestionImage currentImage;
	ImageView image;
	Integer[] imageReferences = new Integer[37];
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_quiz);
		DbHelper db = new DbHelper(this);
		questionList = db.getAllQuestions();
		currentQuestion = questionList.get(questionID);
		textQuestion = (TextView)findViewById(R.id.textView1);
		rCAns =(RadioButton)findViewById(R.id.radio0);
		rWAns1 =(RadioButton)findViewById(R.id.radio1);
		rWAns2 =(RadioButton)findViewById(R.id.radio2);
		buttonNext = (Button)findViewById(R.id.button1);
		image = (ImageView)findViewById(R.id.imageView1);
		
		imageReferences[0] = R.drawable.image0;
		imageReferences[1] = R.drawable.image1;
		imageReferences[2] = R.drawable.image2;
		imageReferences[3] = R.drawable.image3;
		imageReferences[4] = R.drawable.image4;
		imageReferences[5] = R.drawable.image5;
		imageReferences[6] = R.drawable.image6;
		imageReferences[7] = R.drawable.image7;
		imageReferences[8] = R.drawable.image8;
		imageReferences[9] = R.drawable.image9;
		imageReferences[10] = R.drawable.image10;
		imageReferences[11] = R.drawable.image11;
		imageReferences[12] = R.drawable.image12;
		imageReferences[13] = R.drawable.image13;
		imageReferences[14] = R.drawable.image14;
		imageReferences[15] = R.drawable.image15;
		imageReferences[16] = R.drawable.image16;
		imageReferences[17] = R.drawable.image17;
		imageReferences[18] = R.drawable.image18;
		imageReferences[19] = R.drawable.image19;
		imageReferences[20] = R.drawable.image20;
		imageReferences[21] = R.drawable.image21;
		imageReferences[22] = R.drawable.image22;
		imageReferences[23] = R.drawable.image23;
		imageReferences[24] = R.drawable.image24;
		imageReferences[25] = R.drawable.image25;
		imageReferences[26] = R.drawable.image26;
		imageReferences[27] = R.drawable.image27;
		imageReferences[28] = R.drawable.image28;
		imageReferences[29] = R.drawable.image29;
		imageReferences[30] = R.drawable.image30;
		imageReferences[31] = R.drawable.image31;
		imageReferences[32] = R.drawable.image32;
		imageReferences[33] = R.drawable.image33;
		imageReferences[34] = R.drawable.image34;
		imageReferences[35] = R.drawable.image35;
		imageReferences[36] = R.drawable.image36;
		
		
		setQuestionView();
		
		buttonNext.setOnClickListener(new View.OnClickListener(){
			/**
			 * @param v
			 */
			@Override
			public void onClick(View v){
				RadioGroup grp = (RadioGroup)findViewById(R.id.radioGroup1);
				RadioButton selectedAnswer = (RadioButton)findViewById(grp.getCheckedRadioButtonId());
				
				if(currentQuestion.getAnswer().equals(selectedAnswer.getText())){
					score++;
					Log.d("score", "Your score " + score);
				}
				
				if(questionID<20){
					currentQuestion = questionList.get(questionID);
					setQuestionView();
				}
				
				else{
					Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
					Bundle b = new Bundle();
					b.putInt("score", score);
					intent.putExtras(b);
					startActivity(intent);
					finish();
				}
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		getMenuInflater().inflate(R.menu.activity_quiz, menu);
		return true;
	}
	
	private void setQuestionView(){
		textQuestion.setText(currentQuestion.getQuestion());
		rCAns.setText(currentQuestion.getAnswer());
		rWAns1.setText(currentQuestion.getWrongAnswer1());
		rWAns2.setText(currentQuestion.getWrongAnswer2());
		
		//work out how to reference the picture in a more dynamic manner
		int newImageResource = imageReferences[questionID];
		image.setImageResource(newImageResource);
		questionID++;
		
	}
	
	
}
