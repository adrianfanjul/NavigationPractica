package com.tokioschool.navigationpractica.features.home.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.tokioschool.navigationpractica.features.home.fragments.FragmentHomeFour;
import com.tokioschool.navigationpractica.features.home.fragments.FragmentHomeOne;
import com.tokioschool.navigationpractica.features.home.fragments.FragmentHomeThree;
import com.tokioschool.navigationpractica.features.home.fragments.FragmentHomeTwo;

public class PageAdapterHome extends FragmentStateAdapter {

    public PageAdapterHome(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment;
        switch (position){
            case 0:
                fragment= FragmentHomeOne.newInstance();
                break;
            case 1:
                fragment= FragmentHomeTwo.newInstance();
                break;
            case 2:
                fragment= FragmentHomeThree.newInstance();
                break;
            case 3:
                fragment= FragmentHomeFour.newInstance();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + position);
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
