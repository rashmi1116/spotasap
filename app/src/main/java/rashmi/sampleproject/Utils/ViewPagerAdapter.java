package rashmi.sampleproject.Utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rashmi.ramesh on 20-05-2017.
 */

public class ViewPagerAdapter  extends FragmentPagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList<>();//CONTAINS THE FRAGMENTS AS A LIST
    private final List<String> mFragmentTitleList = new ArrayList<>();//CONTAINS THE FRAGMNT TITLE AS A LIST

    public ViewPagerAdapter(FragmentManager manager) {
        super(manager);//MUST USE THIS AS IT AS A SUPER CLASS CONTAINS SOME DEFAULT PROPERTIES
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);//current position of tab start from 0 first tab
        // viewPager.getCurrentItem()
    }



    /*@Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }*/

    @Override
    public int getCount() {
        return mFragmentList.size();//here the size is 3
        //return 4; as here is no 4th fragment crash after 3rd fragment
    }

    public void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);//adds the fragment
        mFragmentTitleList.add(title);//adds the title for respective fragment

    }
    public Fragment getFragment(int position){
        return  mFragmentList.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }
}

