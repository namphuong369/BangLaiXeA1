package com.nam.banglaixea1.SQLite;

import android.provider.BaseColumns;

public final class QuesContract {
    private QuesContract(){}
    public static class CategoriesTable implements BaseColumns {
        public static final String TABLE_NAME="categories";
        public static final String COLUMN_NAME="name";
        public static final String COLUMN_COUNT_QUES="count_ques";
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
        public static final String COLUMN_CATEGORY="category";
        public static final String COLUMN_WARNING="warning";
    }
}
