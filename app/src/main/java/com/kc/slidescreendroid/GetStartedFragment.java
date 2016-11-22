package com.kc.slidescreendroid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link GetStartedFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GetStartedFragment extends Fragment {
    private final static String TAG = GetStartedFragment.class.getSimpleName();     //Define a TAG to log data to identify from which call its printed.
    private static final String ARG_PAGE = "page";                                  //Argument to get when creating a instance of fragment.
    private int mPage;                                                              //mPage variable to identify Page number and pass value to fragment so values can be set according to page.
    private TextView mTitleTextView, mGetStartedTextView;                           //Define TextView to initialize UI text views.
    private CircleImageView mGetStartedCircleImageView;                             //define CircleImageView to initialize ui widget.
    private RelativeLayout mGetStartedFragmentRelativeLayout;                       //Define Relative Layout to set background color according to page number.

    public GetStartedFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param _page page so content can be shown according to page(page1, page2 and page3)
     * @return A new instance of fragment GetStartedFragment.
     */
    public static GetStartedFragment newInstance(int _page) {
        GetStartedFragment fragment = new GetStartedFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, _page);
        fragment.setArguments(args);
        return fragment;
    }

    //Get Arguments from Bundle.
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPage = getArguments().getInt(ARG_PAGE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_get_started, container, false);
        //Initialize All UI widgets
        mGetStartedCircleImageView = (CircleImageView) view.findViewById(R.id.getStartedCircleImageView);
        mTitleTextView = (TextView) view.findViewById(R.id.titleTextView);
        mGetStartedTextView = (TextView) view.findViewById(R.id.getStartedTextView);
        RelativeLayout mGetStartedFragmentRelativeLayout = (RelativeLayout) view.findViewById(R.id.getStartedFragmentRelativeLayout);
        switch (mPage) {
            case 0: {
                mGetStartedFragmentRelativeLayout.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.getStartedScreen1BgColor));
                mGetStartedCircleImageView.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.one));
                mTitleTextView.setText(getResources().getString(R.string.title_1));
                mGetStartedTextView.setText(getString(R.string.text_1));
                break;
            }
            case 1: {
                mGetStartedFragmentRelativeLayout.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.getStartedScreen2BgColor));
                mGetStartedCircleImageView.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.two));
                mTitleTextView.setText(getString(R.string.title_2));
                mGetStartedTextView.setText(getString(R.string.text_2));
                break;
            }
            case 2: {
                mGetStartedFragmentRelativeLayout.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.getStartedScreen3BgColor));
                mGetStartedCircleImageView.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.three));
                mTitleTextView.setText(getString(R.string.title_3));
                mGetStartedTextView.setText(getString(R.string.text_3));
                break;
            }
            default: {
                break;
            }
        }
        return view;
    }
}
