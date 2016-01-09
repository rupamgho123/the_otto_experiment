package com.example.ottoexperiment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.squareup.otto.Subscribe;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by rupam.ghosh on 08/01/16.
 */
public class OneFragment extends BaseFragment {

    @Bind(R.id.button1)
    TextView button;

    int count;

    public OneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false);
    }

    @OnClick(R.id.button1)
    public void buttonClicked() {
        count++;
        BusProvider.getInstance().post(fragmentOneButtonClickEvent());
    }

    public FragmentOneButtonClickEvent fragmentOneButtonClickEvent() {
        return new FragmentOneButtonClickEvent(count);
    }

    @Subscribe
    public void fragmentTwoButtonClicked(FragmentTwoButtonClickEvent event) {
        button.setText(String.format("Received from Fragment2 click count: %d", event.getCount()));
    }

}
