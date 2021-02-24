package com.nam.banglaixea1.SQLite;

import android.provider.BaseColumns;

public final class LessonContract {
    private LessonContract(){}
    public static class LessonTable implements BaseColumns{
        public static final String TABLE_NAME="lesson";
        public static final String COLUMN_NAME="name";
        public static final String COLUMN_COLOR="color";
        public static final String COLUMN_CONTENT="content";
        public static final String COLUMN_CHECK_LESSON="check_ls";
        public static final String COLUMN_TIME_LESSON="time_ls";
        public static final String COLUMN_STATE_LESSON="state_ls";
        public static final String COLUMN_NUMBER_WARNING="warning";
        public static final String COLUMN_NUMBER_NULL_ANSWER="null_answer";
        public static final String COLUMN_NUMBER_CORRECT_ANSWER="correct_answer";
        public static final String COLUMN_NUMBER_WRONG_ANSWER="wrong_answer";
    }
    public static class QuestionTable implements BaseColumns{
        public static final String TABLE_NAME="questions";
        public static final String COLUMN_QUESTION="question";
        public static final String COLUMN_IMAGE_QUESTION="question_image";
        public static final String COLUMN_OPTION1="op1";
        public static final String COLUMN_OPTION2="op2";
        public static final String COLUMN_OPTION3="op3";
        public static final String COLUMN_OPTION4="op4";
        public static final String COLUMN_ANSWER="ans";
        public static final String COLUMN_YOUR_ANSWER="y_ans";
        public static final String COLUMN_LESSON="lesson";
        public static final String COLUMN_WARNING="warning";
    }
}
