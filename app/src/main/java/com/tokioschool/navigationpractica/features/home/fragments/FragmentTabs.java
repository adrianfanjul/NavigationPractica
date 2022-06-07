package com.tokioschool.navigationpractica.features.home.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.tokioschool.navigationpractica.R;
import com.tokioschool.navigationpractica.databinding.FragmentTabsBinding;
import com.tokioschool.navigationpractica.features.home.adapters.PageAdapterHome;


public class FragmentTabs extends Fragment {

    private FragmentTabsBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentTabsBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        PageAdapterHome pageAdapter = new PageAdapterHome(getActivity());
        binding.homeViewPager.setAdapter(pageAdapter);
        new TabLayoutMediator(binding.homeTabs,binding.homeViewPager,((tab, position) -> {
            if(position==0){
                tab.setIcon(getActivity().getDrawable(R.drawable.home_camera_icon));
                tab.getIcon().setTint(getActivity().getColor(R.color.primaryTextColor));
            }
            if(position==1){
                tab.setIcon(getActivity().getDrawable(R.drawable.home_car_icon));
            }
            if(position==2){
                tab.setIcon(getActivity().getDrawable(R.drawable.home_calendar_icon));
            }
            if(position==3){
                tab.setIcon(getActivity().getDrawable(R.drawable.home_face_icon));
            }
        })).attach();

        binding.homeTabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getIcon().setTint(getActivity().getColor(R.color.primaryTextColor));
                binding.homeContainer.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setTint(getActivity().getColor(R.color.secondaryTextColor));
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                tab.getIcon().setTint(getActivity().getColor(R.color.primaryTextColor));
                binding.homeContainer.setVisibility(View.INVISIBLE);
            }
        });
    }
}