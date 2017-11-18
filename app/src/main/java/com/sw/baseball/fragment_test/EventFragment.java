package com.sw.baseball.fragment_test;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

/**
 * Created by jungseokwon on 2017. 11. 17..
 */

public class EventFragment extends Fragment {

    PrintFragmetnInterface listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try{
            listener = (PrintFragmetnInterface) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString());
        }


    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try{
            listener = (PrintFragmetnInterface) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString());
        }
    }


    @Override
    public void onStart() {
        super.onStart();

        listener.next();
    }
}
