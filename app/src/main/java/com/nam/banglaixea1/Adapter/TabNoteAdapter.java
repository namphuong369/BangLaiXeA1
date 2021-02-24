package com.nam.banglaixea1.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.nam.banglaixea1.Fragment.Fragment_Note_A;
import com.nam.banglaixea1.Fragment.Fragment_Note_B;

public class TabNoteAdapter extends FragmentStatePagerAdapter {
    private String listTab[]={"MẸO LÝ THUYẾT","MẸO THỰC HÀNH"};
    private Fragment_Note_A fragment_note_a;
    private Fragment_Note_B fragment_note_b;
    public TabNoteAdapter(@NonNull FragmentManager fm) {
        super(fm);
        fragment_note_a=new Fragment_Note_A();
        fragment_note_b=new Fragment_Note_B();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return fragment_note_a;
        }else if(position==1){
            return fragment_note_b;
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
