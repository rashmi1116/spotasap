package rashmi.sampleproject.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import rashmi.sampleproject.R;
import rashmi.sampleproject.Utils.OnSwipeTouchListener;
import rashmi.sampleproject.Utils.ViewFlipperPoints;
import rashmi.sampleproject.Utils.ViewPagerAdapter;
import rashmi.sampleproject.fragment.ImagesFragment;
import rashmi.sampleproject.fragment.MilestoneFragment;
import rashmi.sampleproject.fragment.VideosFragment;

public class MainActivity extends AppCompatActivity {
    private ViewFlipperPoints viewFlipperPoints = null;
    private int view_Flipper_Images[] = {R.drawable.slider1, R.drawable.slider2,
            R.drawable.slider3,R.drawable.slider4,R.drawable.slider5  };
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
    }

    private void initializeViews() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//for pre lollipop versions

        viewFlipperPoints = (ViewFlipperPoints) findViewById(R.id.viewflipper);
        viewFlipperPoints.removeAllViews();
        for (int view_Flipper_Image : view_Flipper_Images) {
            //  This will create dynamic image view and add them to ViewFlipper
            ImageView image = new ImageView(getApplicationContext());
            image.setBackgroundResource(view_Flipper_Image);
            image.setImageDrawable(image.getDrawable());
            viewFlipperPoints.addView(image);

        }
        viewFlipperPoints.setFlipInterval(5000);
        viewFlipperPoints.setAutoStart(true);

        // To handle Swipe touch
        OnSwipeTouchListener onSwipeTouchListener = new OnSwipeTouchListener(this) {
            public void onSwipeRight() {
                viewFlipperPoints.showPrevious();
            }

            public void onSwipeLeft() {
                viewFlipperPoints.showNext();
            }
        };
        viewFlipperPoints.setOnTouchListener(onSwipeTouchListener);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(3);
        setupViewPager(viewPager);

         tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        createTabIcons();

    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());//contains the number of views
        adapter.addFragment(new VideosFragment(), "Videos");//title of the tab
        adapter.addFragment(new ImagesFragment(), "Images");
        adapter.addFragment(new MilestoneFragment(), "Milestone");
        viewPager.setAdapter(adapter);
    }
    private void createTabIcons() {

        final TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabOne.setText("Videos");
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.select_video, 0, 0);
        tabOne.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.red));
        tabLayout.getTabAt(0).setCustomView(tabOne);

        final TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTwo.setText("Images");
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.image, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);


        final TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabThree.setText("Milestone");
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.milestone, 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabThree);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.select_video, 0, 0);
                        tabOne.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.red));
                        break;
                    case 1:
                        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.select_image, 0, 0);
                        tabTwo.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.red));
                     break;
                    case 2:
                        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.select_milestone, 0, 0);
                        tabThree.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.red));
                        break;

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.video, 0, 0);
                        tabOne.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.grey));
                        break;
                    case 1:
                        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.image, 0, 0);
                        tabTwo.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.grey));
                        break;
                    case 2:
                        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.milestone, 0, 0);
                        tabThree.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.grey));
                        break;
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}
