package com.slinky.foodies;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class FeaturedPager extends FragmentPagerAdapter {

    public FeaturedPager(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new TestPicFragment();
        } else if (position == 1) {
            return new PicTwoFragmrnt();
        } else if(position == 2){
            return new PicThreeFragment();
        }
        return new TestPicFragment();
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "restaurant1";
        } else if (position == 1) {
            return "restaurant2";
        }else if (position == 2) {
            return "restaurant3";
        }
        return super.getPageTitle(position);
    }

}
