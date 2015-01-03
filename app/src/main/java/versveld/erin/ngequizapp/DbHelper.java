package versveld.erin.ngequizapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class DbHelper extends SQLiteOpenHelper {
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "vocabQuiz";
	private static final String TABLE_QUESTION = "question";

	private static final String KEY_ID = "id";
	private static final String KEY_QUESTION = "q";
	private static final String KEY_ANSWER = "a";
	private static final String KEY_WRONG_OPTION_1 = "wrongOp1";
	private static final String KEY_WRONG_OPTION_2 = "wrongOp2";
	private static final String KEY_IMG = "image";
	private static final String KEY_SND_ANS = "answerSound";
	private static final String KEY_SND_WRONG_ANS_1 = "wrongSound1";
	private static final String KEY_SND_WRONG_ANS_2 = "wrongSound2";

	private SQLiteDatabase dBase;
	
	public DbHelper(Context context){
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db){
        Log.d("LOOOOOL","LOOOOOL");
		dBase = db;
		String sql = "CREATE TABLE IF NOT EXISTS "+TABLE_QUESTION+" ("+
				KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
				KEY_QUESTION+" TEXT,"+
				KEY_ANSWER+" TEXT,"+
				KEY_WRONG_OPTION_1+" TEXT,"+
				KEY_WRONG_OPTION_2+" TEXT,"+
				KEY_IMG +" INTEGER,"+
				KEY_SND_ANS+" INTEGER,"+
				KEY_SND_WRONG_ANS_1+" INTEGER,"+
				KEY_SND_WRONG_ANS_2+" INTEGER"+
				")";
		
		db.execSQL(sql);
		addQuestions();
	}

	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
		db.execSQL("DROP TABLE IF EXISTS "+TABLE_QUESTION);
		onCreate(db);
	}

	private void addQuestions(){
		Question[] questionArray = new Question[37];
		String[] answerArray = new String[37];
		Integer[] imageReferences = new Integer[37];
		Integer[] soundReferences = new Integer[37];
		Random index = new Random();

		answerArray[0] = "ǀqhuisi";
		answerArray[1] = "ǁhaqba";
		answerArray[2] = "gǃuuke";
		answerArray[3] = "ǃ'abakakeha";
		answerArray[4] = "ǀqhui";
		answerArray[5] = "nǃûu";
		answerArray[6] = "tjoe";
		answerArray[7] = "si ǃu xu";
		answerArray[8] = "ǀee";
		answerArray[9] = "ǃae";
		answerArray[10] = "saa ";
		answerArray[11] = "ǃaa";
		answerArray[12] = "ǂun";
		answerArray[13] = "gǃae";
		answerArray[14] = "nǃâu";
		answerArray[15] = "ts'uruke";
		answerArray[16] = "!oqe";
		answerArray[17] = "ǃae ǃhai";
		answerArray[18] = "ǀqere ";
		answerArray[19] = "!'ubi";
		answerArray[20] = "ǃqhoeke";
		answerArray[21] = "nǂôqa ";
		answerArray[22] = "koro";
		answerArray[23] = "ǀâaqsi";
		answerArray[24] = "ǁqhana";
		answerArray[25] = "ǀhoqesi";
		answerArray[26] = "nǀui";
		answerArray[27] = "purukutsi";
		answerArray[28] = "ǂ'haqu";
		answerArray[29] = "gǁoo";
		answerArray[30] = "gum";
		answerArray[31] = "donkisi";
		answerArray[32] = "hâasi";
		answerArray[33] = "piri";
		answerArray[34] = "ǀaxusi";
		answerArray[35] = "mʘôa";
		answerArray[36] = "ǂhun";

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

		soundReferences[0] = R.raw.sound1bird;
		soundReferences[1] = R.raw.sound2korhaan;
		soundReferences[2] = R.raw.sound3kori_bustard;
		soundReferences[3] = R.raw.sound4secretary_bird;
		soundReferences[4] = R.raw.sound5vulture;
		soundReferences[5] = R.raw.sound6owl;
		soundReferences[6] = R.raw.sound7ostrich;
		soundReferences[7] = R.raw.sound8zebra;
		soundReferences[8] = R.raw.sound9blue_wildebeast;
		soundReferences[9] = R.raw.sound10gemsbok;
		soundReferences[10] = R.raw.sound11eland;
		soundReferences[11] = R.raw.sound12red_hartebeest;
		soundReferences[12] = R.raw.sound13steenbok;
		soundReferences[13] = R.raw.sound14springbok;
		soundReferences[14] = R.raw.sound15hare;
		soundReferences[15] = R.raw.sound16mouse;
		soundReferences[16] = R.raw.sound17tortoise;
		soundReferences[17] = R.raw.sound18ground_squirrel;
		soundReferences[18] = R.raw.sound19yellow_mongoose;
		soundReferences[19] = R.raw.sound20suricate;
		soundReferences[20] = R.raw.sound21lion;
		soundReferences[21] = R.raw.sound22large_spotted_genet;
		soundReferences[22] = R.raw.sound23black_backed_jackal;
		soundReferences[23] = R.raw.sound24snake;
		soundReferences[24] = R.raw.sound25scorpion;
		soundReferences[25] = R.raw.sound26millipede;
		soundReferences[26] = R.raw.sound27spider;
		soundReferences[27] = R.raw.sound28butterfly;
		soundReferences[28] = R.raw.sound29dung_beetle;
		soundReferences[29] = R.raw.sound30bull;
		soundReferences[30] = R.raw.sound31cow;
		soundReferences[31] = R.raw.sound32donkey;
		soundReferences[32] = R.raw.sound33horse;
		soundReferences[33] = R.raw.sound34goat;
		soundReferences[34] = R.raw.sound35sheep;
		soundReferences[35] = R.raw.sound36cat;
		soundReferences[36] = R.raw.sound37dog;

		int wrongInd1, wrongInd2;
		for(int i = 0; i<37; i++){
			// The id of this question and the id of the question from getAllQuestions() won't necessarily
			// match up - this id is arbitrary, while the one in getAllQuestions() is set by the db.
			wrongInd1 = index.nextInt(answerArray.length);
			wrongInd2 = index.nextInt(answerArray.length);
			questionArray[i] = new Question(i, "What kind of animal is in this picture?", answerArray[i],
					answerArray[wrongInd1], answerArray[wrongInd2],
					imageReferences[i], soundReferences[i], soundReferences[wrongInd1], soundReferences[wrongInd2]);
			this.addQuestion(questionArray[i]);
		}
	}

	private void addQuestion(Question question){
		
		ContentValues values = new ContentValues();
		// Note: id autoincrements, and is not placed in the db.
		values.put(KEY_QUESTION, question.getQuestionText());
		values.put(KEY_ANSWER, question.getCorrectAnswer());
		values.put(KEY_WRONG_OPTION_1, question.getWrongAnswer1());
		values.put(KEY_WRONG_OPTION_2, question.getWrongAnswer2());
		values.put(KEY_IMG, question.getImageRef());
		Integer[] soundRefs = question.getSoundRefs();
		values.put(KEY_SND_ANS, soundRefs[0]);
		values.put(KEY_SND_WRONG_ANS_1, soundRefs[1]);
		values.put(KEY_SND_WRONG_ANS_2, soundRefs[2]);

		dBase.insert(TABLE_QUESTION, null, values);
	}
	
	public List<Question> getAllQuestions(){
		List<Question> questionList = new ArrayList<Question>();
		
		String selectQuery = "SELECT * FROM "+ TABLE_QUESTION;
		dBase = this.getReadableDatabase();
		Cursor cursor = dBase.rawQuery(selectQuery, null);
		Integer[] soundRefs;
		
		if(cursor.moveToFirst()){
			do{
				Question question = new Question();
				question.setID(cursor.getInt(0));
				question.setQuestionText(cursor.getString(1));
				question.setCorrectAnswer(cursor.getString(2));
				question.setWrongAnswer1(cursor.getString(3));
				question.setWrongAnswer2(cursor.getString(4));
				question.setImageRef(cursor.getInt(5));
				soundRefs = new Integer[]{cursor.getInt(6), cursor.getInt(7), cursor.getInt(8)};
				question.setSoundRefs(soundRefs);
				questionList.add(question);
			}while(cursor.moveToNext());
		}
        Log.d("<DDD>", String.valueOf(questionList.size()));
        return questionList;
	}
	
	public int rowCount(){
		
		int row = 0;
		String selectQuery = "SELECT * FROM "+TABLE_QUESTION;
		
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
		
		row = cursor.getCount();
		
		return row;
	}
		
}
