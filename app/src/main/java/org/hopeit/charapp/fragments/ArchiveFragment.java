package org.hopeit.charapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.hopeit.charapp.R;


public class ArchiveFragment extends Fragment {
    
    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;

    public static ArchiveFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        ArchiveFragment fragment = new ArchiveFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_archive, container, false);
        TextView textView = (TextView) view.findViewById(R.id.content);
        return view;
    }

}
