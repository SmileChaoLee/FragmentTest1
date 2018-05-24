package com.smile.fragmenttest1;

import android.graphics.Point;
import android.os.Bundle;
import android.app.Fragment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by lee on 2/18/2016.
 */
public class FragmentTwo extends Fragment {

    private Point fragmentSize;
    private View  fragmentView = null;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.view_fragment_two,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {
        super.onViewCreated(view,savedInstanceState);
        // fragmentView = getView();
        fragmentView = view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Display display = getActivity().getWindowManager().getDefaultDisplay();
        fragmentSize = new Point();
        display.getSize(fragmentSize);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.MATCH_PARENT);
        lp.width = fragmentSize.x/2;
        // lp.height = fragmentSize.y;
        lp.leftMargin = lp.width+1;

        fragmentView.setLayoutParams(lp);
    }
}

