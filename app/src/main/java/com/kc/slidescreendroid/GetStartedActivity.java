package com.kc.slidescreendroid;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.kc.slidescreendroid.adapter.GetStartedPagerAdapter;

import me.relex.circleindicator.CircleIndicator;

/**
 * Get Started Activity is launcher activity and will have a View Pager to show three guide screen for users
 * to give a brief about what application can do.
 * View Pager is being seted up in @OnCreate Method.
 *
 * @author Khemchand Joshi
 * @version 1.0
 */
public class GetStartedActivity extends AppCompatActivity {
    //Define a TAG to log the values for debugging purpose or identity in logs from which class is being printed.
    private final static String TAG = GetStartedActivity.class.getSimpleName();
    private ViewPager mGetStartedViewPager;              //Initialize View Pager.
    private GetStartedPagerAdapter mPagerAdapter;        //Initialize Adapter, its fragment Pager adapter to show fixed number of screens.
    private CircleIndicator mIndicator;                  //Circle Indicator to show dots and highlight dots when slide on other screen.
    private Button mGetStartedButton;                    //Get Started Button will appear on last screen so after guide, user can redirect to application main screen.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);
        //Initialize all the Views defined in xml
        mIndicator = (CircleIndicator) findViewById(R.id.indicator);
        mGetStartedButton = (Button) findViewById(R.id.getStartedButton);
        mGetStartedViewPager = (ViewPager) findViewById(R.id.getStartedViewPager);
        //Initialize adapter which will generate views for all three screens.
        mPagerAdapter = new GetStartedPagerAdapter(getSupportFragmentManager());
        //Set adapter in View Pager to show pages.
        mGetStartedViewPager.setAdapter(mPagerAdapter);
        //Also set dot indicator with View Pager.
        mIndicator.setViewPager(mGetStartedViewPager);
        //Attach a on Page Listener so if any action has to be taken on any page then can be taken in @OnPageSelected
        mGetStartedViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //When user is on last screen then show Get Started Button to user to redirect to application main screen.
                if (position == 2) {
                    mGetStartedButton.setVisibility(View.VISIBLE);
                    mGetStartedButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //Redirect on screen wherever you want to.
                        }
                    });
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
