package com.naplayer.nabrowser;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class SimpleBrowserFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private static final String ARG_URL = "url";

    private String mSectionNumber;
    private String mUrl;

    private OnFragmentInteractionListener mListener;

    public static SimpleBrowserFragment newInstance(String sectionNumber, String url) {
        SimpleBrowserFragment fragment = new SimpleBrowserFragment();
        Bundle args = new Bundle();
        args.putString(ARG_SECTION_NUMBER, sectionNumber);
        args.putString(ARG_URL, url);
        fragment.setArguments(args);
        return fragment;
    }

    public SimpleBrowserFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mSectionNumber = getArguments().getString(ARG_SECTION_NUMBER);
            mUrl = getArguments().getString(ARG_URL);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_simple_browser, container, false);
        WebView web = (WebView)v.findViewById(R.id.webview);

        web.setWebViewClient(new WebViewClient());
        String position = getArguments().getString(ARG_SECTION_NUMBER);
        String url = getArguments().getString(ARG_URL);

        Toast.makeText((Activity)mListener, position, Toast.LENGTH_SHORT).show();
        web.loadUrl(url);

        return v;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
    }

}
