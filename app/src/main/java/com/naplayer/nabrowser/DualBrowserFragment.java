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

public class DualBrowserFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private static final String ARG_URL_1 = "url1";
    private static final String ARG_URL_2 = "url2";

    private String mSectionNumber;
    private String mUrl1;
    private String mUrl2;

    private OnFragmentInteractionListener mListener;

    public static DualBrowserFragment newInstance(String sectionNumber, String url1, String url2) {
        DualBrowserFragment fragment = new DualBrowserFragment();
        Bundle args = new Bundle();
        args.putString(ARG_SECTION_NUMBER, sectionNumber);
        args.putString(ARG_URL_1, url1);
        args.putString(ARG_URL_2, url2);
        fragment.setArguments(args);
        return fragment;
    }

    public DualBrowserFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mSectionNumber = getArguments().getString(ARG_SECTION_NUMBER);
            mUrl1 = getArguments().getString(ARG_URL_1);
            mUrl2 = getArguments().getString(ARG_URL_2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String position = getArguments().getString(ARG_SECTION_NUMBER);
        String url1 = getArguments().getString(ARG_URL_1);
        String url2 = getArguments().getString(ARG_URL_2);
        Toast.makeText((Activity)mListener, position, Toast.LENGTH_SHORT).show();

        View v = inflater.inflate(R.layout.fragment_dual_browser, container, false);
        WebView web1 = (WebView)v.findViewById(R.id.webview1);
        web1.setWebViewClient(new WebViewClient());
        web1.getSettings().setJavaScriptEnabled(true);
        web1.getSettings().setBuiltInZoomControls(true);
        web1.loadUrl(url1);

        WebView web2 = (WebView)v.findViewById(R.id.webview2);
        web2.setWebViewClient(new WebViewClient());
        web2.getSettings().setJavaScriptEnabled(true);
        web2.getSettings().setBuiltInZoomControls(true);
        web2.loadUrl(url2);

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
