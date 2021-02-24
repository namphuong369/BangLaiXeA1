package com.nam.banglaixea1.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.nam.banglaixea1.Module.Category;
import com.nam.banglaixea1.Module.Lesson;
import com.nam.banglaixea1.Module.Question;
import com.nam.banglaixea1.R;

import java.util.ArrayList;

public class LessonDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "LessonDb.db";
    private static final int DATABASE_VERSION = 1;
    private static LessonDbHelper instance;
    private SQLiteDatabase db;

    public static synchronized LessonDbHelper getInstance(Context context) {
        if (instance == null) {
            instance = new LessonDbHelper(context.getApplicationContext());
        }
        return instance;
    }

    public LessonDbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        final String SQL_CREATE_LESSON_TABLE = "CREATE TABLE " +
                LessonContract.LessonTable.TABLE_NAME + " ( " +
                LessonContract.LessonTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                LessonContract.LessonTable.COLUMN_NAME + " INTEGER, " +
                LessonContract.LessonTable.COLUMN_COLOR + " INTEGER, " +
                LessonContract.LessonTable.COLUMN_CONTENT + " TEXT, " +
                LessonContract.LessonTable.COLUMN_CHECK_LESSON + " INTEGER, " +
                LessonContract.LessonTable.COLUMN_TIME_LESSON + " INTEGER, " +
                LessonContract.LessonTable.COLUMN_STATE_LESSON + " INTEGER, " +
                LessonContract.LessonTable.COLUMN_NUMBER_WARNING + " INTEGER, " +
                LessonContract.LessonTable.COLUMN_NUMBER_NULL_ANSWER + " INTEGER, " +
                LessonContract.LessonTable.COLUMN_NUMBER_CORRECT_ANSWER + " INTEGER, " +
                LessonContract.LessonTable.COLUMN_NUMBER_WRONG_ANSWER + " INTEGER " + " ) ";
        final String SQL_CREATE_QUESTION_TABLE = "CREATE TABLE " +
                LessonContract.QuestionTable.TABLE_NAME + " ( " +
                LessonContract.QuestionTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                LessonContract.QuestionTable.COLUMN_QUESTION + " TEXT, " +
                LessonContract.QuestionTable.COLUMN_OPTION1 + " TEXT, " +
                LessonContract.QuestionTable.COLUMN_OPTION2 + " TEXT, " +
                LessonContract.QuestionTable.COLUMN_OPTION3 + " TEXT, " +
                LessonContract.QuestionTable.COLUMN_OPTION4 + " TEXT, " +
                LessonContract.QuestionTable.COLUMN_ANSWER + " INTEGER, " +
                LessonContract.QuestionTable.COLUMN_YOUR_ANSWER + " INTEGER, " +
                LessonContract.QuestionTable.COLUMN_LESSON + " INTEGER, " +
                LessonContract.QuestionTable.COLUMN_IMAGE_QUESTION + " INTEGER, " +
                LessonContract.QuestionTable.COLUMN_WARNING + " INTEGER, " + " FOREIGN KEY ( " +
                LessonContract.QuestionTable.COLUMN_LESSON + " ) REFERENCES " +
                LessonContract.LessonTable.TABLE_NAME + " ( " +
                LessonContract.LessonTable._ID + " ) " +
                "ON DELETE CASCADE" + " ) ";
        db.execSQL(SQL_CREATE_LESSON_TABLE);
        db.execSQL(SQL_CREATE_QUESTION_TABLE);
        allLesson();
    }

    public void allLesson() {
        addLesson(new Lesson(R.color.color1, "25 câu / 19 phút", -1, 0, 0));
        addLesson(new Lesson(R.color.color2, "25 câu / 19 phút", -1, 0, 0));
        addLesson(new Lesson(R.color.color3, "25 câu / 19 phút", -1, 0, 0));
        addLesson(new Lesson(R.color.color4, "25 câu / 19 phút", -1, 0, 0));
        addLesson(new Lesson(R.color.color5, "25 câu / 19 phút", -1, 0, 0));
        addLesson(new Lesson(R.color.color6, "25 câu / 19 phút", -1, 0, 0));
    }

    public void addLesson(Lesson lesson) {
        ContentValues cv = new ContentValues();
        cv.put(LessonContract.LessonTable.COLUMN_COLOR, lesson.getColor());
        cv.put(LessonContract.LessonTable.COLUMN_CONTENT, lesson.getContent());
        cv.put(LessonContract.LessonTable.COLUMN_CHECK_LESSON, lesson.getCheck());
        cv.put(LessonContract.LessonTable.COLUMN_TIME_LESSON, lesson.getTimer());
        cv.put(LessonContract.LessonTable.COLUMN_STATE_LESSON, lesson.getState());
        db.insert(LessonContract.LessonTable.TABLE_NAME, null, cv);
    }

    public void addNewLesson(Lesson lesson) {
        db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(LessonContract.LessonTable.COLUMN_COLOR, lesson.getColor());
        cv.put(LessonContract.LessonTable.COLUMN_CONTENT, lesson.getContent());
        cv.put(LessonContract.LessonTable.COLUMN_CHECK_LESSON, lesson.getCheck());
        cv.put(LessonContract.LessonTable.COLUMN_TIME_LESSON, lesson.getTimer());
        cv.put(LessonContract.LessonTable.COLUMN_STATE_LESSON, lesson.getState());
        db.insert(LessonContract.LessonTable.TABLE_NAME, null, cv);
    }

    public void addQuestion(Question question) {
        db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(LessonContract.QuestionTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(LessonContract.QuestionTable.COLUMN_OPTION1, question.getOption1());
        cv.put(LessonContract.QuestionTable.COLUMN_OPTION2, question.getOption2());
        cv.put(LessonContract.QuestionTable.COLUMN_OPTION3, question.getOption3());
        cv.put(LessonContract.QuestionTable.COLUMN_OPTION4, question.getOption4());
        cv.put(LessonContract.QuestionTable.COLUMN_ANSWER, question.getAnswer());
        cv.put(LessonContract.QuestionTable.COLUMN_YOUR_ANSWER, question.getYour_answer());
        cv.put(LessonContract.QuestionTable.COLUMN_LESSON, question.getCategory());
        cv.put(LessonContract.QuestionTable.COLUMN_IMAGE_QUESTION, question.getQuestion_image());
        cv.put(LessonContract.QuestionTable.COLUMN_WARNING, question.getWarning());
        db.insert(LessonContract.QuestionTable.TABLE_NAME, null, cv);
    }

    public ArrayList<Lesson> getLesson() {
        ArrayList<Lesson> list = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + LessonContract.LessonTable.TABLE_NAME, null);
        if (c.moveToFirst()) {
            do {
                Lesson lesson = new Lesson();
                lesson.setId(c.getInt(c.getColumnIndex(LessonContract.LessonTable._ID)));
                lesson.setNumber(c.getInt(c.getColumnIndex(LessonContract.LessonTable._ID)));
                lesson.setColor(c.getInt(c.getColumnIndex(LessonContract.LessonTable.COLUMN_COLOR)));
                lesson.setContent(c.getString(c.getColumnIndex(LessonContract.LessonTable.COLUMN_CONTENT)));
                lesson.setCheck(c.getInt(c.getColumnIndex(LessonContract.LessonTable.COLUMN_CHECK_LESSON)));
                lesson.setTimer(c.getInt(c.getColumnIndex(LessonContract.LessonTable.COLUMN_TIME_LESSON)));
                lesson.setState(c.getInt(c.getColumnIndex(LessonContract.LessonTable.COLUMN_STATE_LESSON)));
                lesson.setNumber_warning(c.getInt(c.getColumnIndex(LessonContract.LessonTable.COLUMN_NUMBER_WARNING)));
                lesson.setNumber_null_answer(c.getInt(c.getColumnIndex(LessonContract.LessonTable.COLUMN_NUMBER_NULL_ANSWER)));
                lesson.setNumber_correct_answer(c.getInt(c.getColumnIndex(LessonContract.LessonTable.COLUMN_NUMBER_CORRECT_ANSWER)));
                lesson.setNumber_wrong_answer(c.getInt(c.getColumnIndex(LessonContract.LessonTable.COLUMN_NUMBER_WRONG_ANSWER)));
                list.add(lesson);
            } while (c.moveToNext());
        }
        c.close();
        return list;
    }

    public ArrayList<Question> getQuestions(int lesson) {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        String selection = LessonContract.QuestionTable.COLUMN_LESSON + " = ? ";
        String[] selectionArgs = new String[]{String.valueOf(lesson)};
        Cursor c = db.query(LessonContract.QuestionTable.TABLE_NAME, null, selection, selectionArgs, null, null, null
        );
        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setId(c.getInt(c.getColumnIndex(LessonContract.QuestionTable._ID)));
                question.setQuestion(c.getString(c.getColumnIndex(LessonContract.QuestionTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(LessonContract.QuestionTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(LessonContract.QuestionTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(LessonContract.QuestionTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(LessonContract.QuestionTable.COLUMN_OPTION4)));
                question.setAnswer(c.getInt(c.getColumnIndex(LessonContract.QuestionTable.COLUMN_ANSWER)));
                question.setYour_answer(c.getInt(c.getColumnIndex(LessonContract.QuestionTable.COLUMN_YOUR_ANSWER)));
                question.setCategory(c.getInt(c.getColumnIndex(LessonContract.QuestionTable.COLUMN_LESSON)));
                question.setQuestion_image(c.getInt(c.getColumnIndex(LessonContract.QuestionTable.COLUMN_IMAGE_QUESTION)));
                question.setWarning(c.getInt(c.getColumnIndex(LessonContract.QuestionTable.COLUMN_WARNING)));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }

    public int updateYourAnswer(String id, Question question) {
        db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(LessonContract.QuestionTable.COLUMN_YOUR_ANSWER, question.getYour_answer());
        return db.update(LessonContract.QuestionTable.TABLE_NAME, cv, LessonContract.QuestionTable._ID + " = ? ", new String[]{id});
    }

    public int updateCheckTimer(String id, Lesson lesson) {
        db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(LessonContract.LessonTable.COLUMN_CONTENT, lesson.getContent());
        cv.put(LessonContract.LessonTable.COLUMN_CHECK_LESSON, lesson.getCheck());
        cv.put(LessonContract.LessonTable.COLUMN_TIME_LESSON, lesson.getTimer());
        cv.put(LessonContract.LessonTable.COLUMN_STATE_LESSON, lesson.getState());
        cv.put(LessonContract.LessonTable.COLUMN_NUMBER_WARNING, lesson.getNumber_warning());
        cv.put(LessonContract.LessonTable.COLUMN_NUMBER_NULL_ANSWER, lesson.getNumber_null_answer());
        cv.put(LessonContract.LessonTable.COLUMN_NUMBER_CORRECT_ANSWER, lesson.getNumber_correct_answer());
        cv.put(LessonContract.LessonTable.COLUMN_NUMBER_WRONG_ANSWER, lesson.getNumber_wrong_answer());
        return db.update(LessonContract.LessonTable.TABLE_NAME, cv, LessonContract.LessonTable._ID + " = ? ", new String[]{id});
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + LessonContract.LessonTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + LessonContract.QuestionTable.TABLE_NAME);
        onCreate(db);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }
}
