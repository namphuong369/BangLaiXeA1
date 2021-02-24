package com.nam.banglaixea1.Module;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.nam.banglaixea1.R;

public class CustomToast extends Toast {
    public static int ERROR = 1;
    public static int SUCCESS=2;
    private static long SHORT = 3000;
    private static long LONG = 5000;
    /**
     * Construct an empty Toast object.  You must call {@link #setView} before you
     * can call {@link #show}.
     *
     * @param context The context to use.  Usually your {@link Application}
     *                or {@link Activity} object.
     */
    public CustomToast(Context context) {
        super(context);
    }
    public static Toast makeText(Context context,String mes,int duration,int type){
        Toast toast=new Toast(context);
        View layout= LayoutInflater.from(context).inflate(R.layout.item_toast,null,false);
        TextView t1=(TextView)layout.findViewById(R.id.toast_text);
        LinearLayout linearLayout=(LinearLayout)layout.findViewById(R.id.toast_type);
        t1.setText(mes);
        if(type==1){
            linearLayout.setBackgroundResource(R.drawable.error_shape);
        }else if(type==2){
            linearLayout.setBackgroundResource(R.drawable.success_shape);
        }
        toast.setView(layout);
        return toast;
    }
}
