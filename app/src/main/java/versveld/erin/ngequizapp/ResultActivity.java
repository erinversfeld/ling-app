package versveld.erin.ngequizapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		
		RatingBar bar = (RatingBar)findViewById(R.id.ratingBar1);
		TextView text = (TextView)findViewById(R.id.textResult);
        TextView scoreText = (TextView)findViewById(R.id.textScore);
		Bundle b = getIntent().getExtras();
		
		int score = b.getInt("score");
		scoreText.setText(score+" out of 20");
		bar.setRating(score/3);
		
		if(score<10){
			text.setText("Keep practicing!");
		}
		
		else if(score<=15 && score>=10){
			text.setText("You're doing really well, keep up the hard work!");
		}
		
		else if(score<20 && score>15){
			text.setText("Your effort has paid off - you're almost there!");
		}
		
		else if(score==20){
			text.setText("Wow, 100%!! That's amazing! Well done on your hard-work!");
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		getMenuInflater().inflate(R.menu.activity_result, menu);
		return true;
	}
}
