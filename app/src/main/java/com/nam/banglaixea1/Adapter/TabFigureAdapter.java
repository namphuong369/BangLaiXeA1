package com.nam.banglaixea1.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.nam.banglaixea1.Fragment.Fragment_A;
import com.nam.banglaixea1.Fragment.Fragment_B;
import com.nam.banglaixea1.Fragment.Fragment_C;
import com.nam.banglaixea1.Fragment.Fragment_D;
import com.nam.banglaixea1.Fragment.Fragment_E;
import com.nam.banglaixea1.Fragment.Fragment_F;

public class TabFigureAdapter extends FragmentStatePagerAdapter {
    private String listTab[] = {"BIỂN BÁO CẤM", "BIỂN BÁO NGUY HIỂM", "BIỂN BÁO HIỆU LỆNH","BIỂN BÁO CHỈ DẪN","BIỂN PHỤ","VẠCH KẺ ĐƯỜNG"};
    private Fragment_A fragment_a;
    private Fragment_B fragment_b;
    private Fragment_C fragment_c;
    private Fragment_D fragment_d;
    private Fragment_E fragment_e;
    private Fragment_F fragment_f;

    public TabFigureAdapter(@NonNull FragmentManager fm) {
        super(fm);
        fragment_a=new Fragment_A();
        fragment_b=new Fragment_B();
        fragment_c=new Fragment_C();
        fragment_d=new Fragment_D();
        fragment_e=new Fragment_E();
        fragment_f=new Fragment_F();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return fragment_a;
        }else if(position ==1 ){
            return fragment_b;
        }else if(position ==2 ){
            return fragment_c;
        }else if(position ==3 ){
            return fragment_d;
        }else if(position ==4 ){
            return fragment_e;
        }else if(position ==5 ){
            return fragment_f;
        }
        return null;
    }

    @Override
    public int getCount() {
        return listTab.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listTab[position];
    }
}
