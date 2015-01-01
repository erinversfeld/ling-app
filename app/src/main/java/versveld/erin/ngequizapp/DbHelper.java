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
	
	private static final String KEY_QUESTION = "q";
	private static final String KEY_ANSWER = "a";
	private static final String KEY_ID = "id";
	private static final String KEY_IMAGE = "imageDirectory";
	private static final String KEY_WRONG_OPTION_1 = "wrongOp1";
	private static final String KEY_WRONG_OPTION_2 = "wrongOp2";
	
	
	private SQLiteDatabase dBase;
	
	public DbHelper(Context context){
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db){
        Log.d("LOOOOOL","LOOOOOL");
		dBase = db;
		String sql = "CREATE TABLE IF NOT EXISTS "+TABLE_QUESTION+" ("
		+KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+KEY_QUESTION
		+" TEXT,"+KEY_ANSWER+" TEXT,"+KEY_WRONG_OPTION_1
		+" TEXT,"+KEY_WRONG_OPTION_2+" TEXT)";
		
		db.execSQL(sql);
		addQuestions();
	}
	
	private void addQuestions(){
		VocabQuestion[] questionArray = new VocabQuestion[37];
		String[] answerArray = new String[37];
		String[] imageArray = new String[37];
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
		
		/*for(int i = 0; i<37; i++){
			imageArray[i] = "/res/drawable/image"+i+".jpg";
            Log.w("app image reference", imageArray[i]);
		}*/
		
		for(int i = 0; i<37; i++){
			questionArray[i] = new VocabQuestion("What kind of animal is in this picture?", answerArray[i], answerArray[index.nextInt(20)], answerArray[index.nextInt(20)]);
			this.addQuestion(questionArray[i]);
		}
	}
	
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
		db.execSQL("DROP TABLE IF EXISTS "+TABLE_QUESTION);
		onCreate(db);
	}
	
	private void addQuestion(VocabQuestion question){
		
		ContentValues values = new ContentValues();
		values.put(KEY_QUESTION, question.getQuestion());
		values.put(KEY_ANSWER, question.getAnswer());
		values.put(KEY_WRONG_OPTION_1, question.getWrongAnswer1());
		values.put(KEY_WRONG_OPTION_2, question.getWrongAnswer2());
		
		dBase.insert(TABLE_QUESTION, null, values);
	}
	
	public List<VocabQuestion> getAllQuestions(){
		List<VocabQuestion> questionList = new ArrayList<VocabQuestion>();
		
		String selectQuery = "SELECT * FROM "+ TABLE_QUESTION;
		dBase = this.getReadableDatabase();
		Cursor cursor = dBase.rawQuery(selectQuery, null);
		
		if(cursor.moveToFirst()){
			do{
				VocabQuestion question = new VocabQuestion();
				question.setID(cursor.getInt(0));
				question.setQuestion(cursor.getString(1));
				question.setAnswer(cursor.getString(2));
                //question.setImageDirectory(cursor.getString(3));
				question.setWrongAnswer1(cursor.getString(3));
                question.setWrongAnswer2(cursor.getString(4));
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
