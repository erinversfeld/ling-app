package versveld.erin.ngequizapp;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.*;

import java.util.List;

public class QuizActivity extends Activity {

	List<Question> questionList;
	
	int score = 0;
	int questionInd = 0;
	
	Question currentQuestion;
	TextView textQuestion;
	RadioButton rCAns, rWAns1, rWAns2;
	RadioGroup radioGroup;
	Button buttonNext;
	ImageView image;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_quiz);
		DbHelper db = new DbHelper(this);
		questionList = db.getAllQuestions();
		currentQuestion = questionList.get((int)(Math.random()*questionList.size()));
		textQuestion = (TextView)findViewById(R.id.textView1);
		radioGroup = (RadioGroup)findViewById(R.id.radioGroup1);
		buttonNext = (Button)findViewById(R.id.button1);
		image = (ImageView)findViewById(R.id.imageView1);

		setQuestionView();
		
		buttonNext.setOnClickListener(new View.OnClickListener(){
			/**
			 * @param v
			 */
			@Override
			public void onClick(View v){
				RadioButton selectedAnswer = (RadioButton)findViewById(radioGroup.getCheckedRadioButtonId());
				//TODO: localise text
				if(currentQuestion.getCorrectAnswer().equals(selectedAnswer.getText())){
					score++;
					Toast correct = Toast.makeText(getApplicationContext(), "Well done, that was correct!", Toast.LENGTH_SHORT);
					correct.show();
				}
				else{
					Toast incorrect = Toast.makeText(getApplicationContext(), "Sorry, that answer was incorrect.", Toast.LENGTH_SHORT);
					incorrect.show();
				}

				Log.d("score", "Your score " + score);

				if(questionInd <20){
					currentQuestion = questionList.get((int)(Math.random()*questionList.size()));
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

		radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				MediaPlayer mp = MediaPlayer.create(QuizActivity.this, R.raw.sound21lion);
				Integer[] soundRefs = currentQuestion.getSoundRefs();
				if(checkedId == rCAns.getId()){
					mp = MediaPlayer.create(QuizActivity.this, soundRefs[0]);
				} else if(checkedId == rWAns1.getId()){
					mp = MediaPlayer.create(QuizActivity.this, soundRefs[1]);
				} else if(checkedId == rWAns2.getId()){
					mp = MediaPlayer.create(QuizActivity.this, soundRefs[2]);
				}
				mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
				mp.start();
				Log.d("item id: ", checkedId + "");
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		getMenuInflater().inflate(R.menu.activity_quiz, menu);
		return true;
	}
	
	private void setQuestionView(){
		textQuestion.setText(currentQuestion.getQuestionText());

		int correctButton = (int)(Math.random()*3);
		switch (correctButton){
			case 0:
				rCAns =(RadioButton)findViewById(R.id.radio0);
				rWAns1 =(RadioButton)findViewById(R.id.radio1);
				rWAns2 =(RadioButton)findViewById(R.id.radio2);
				break;
			case 1:
				rCAns =(RadioButton)findViewById(R.id.radio1);
				rWAns1 =(RadioButton)findViewById(R.id.radio0);
				rWAns2 =(RadioButton)findViewById(R.id.radio2);
				break;
			case 2:
				rCAns =(RadioButton)findViewById(R.id.radio2);
				rWAns1 =(RadioButton)findViewById(R.id.radio1);
				rWAns2 =(RadioButton)findViewById(R.id.radio0);
				break;
		}

		rCAns.setText(currentQuestion.getCorrectAnswer());
		rWAns1.setText(currentQuestion.getWrongAnswer1());
		rWAns2.setText(currentQuestion.getWrongAnswer2());
		
		//work out how to reference the picture in a more dynamic manner
		int newImageResource = currentQuestion.getImageRef();
		image.setImageResource(newImageResource);
		questionInd++;
		
	}

}