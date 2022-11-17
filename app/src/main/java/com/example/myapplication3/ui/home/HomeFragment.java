package com.example.myapplication3.ui.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication3.DogItems;
import com.example.myapplication3.R;
import com.example.myapplication3.RecyclerViewAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ArrayList<DogItems> dogItemsArrayList;
    private int[] dogImages;
    private String[] dogNames;
    private RecyclerView recyclerView;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeBreedsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dataInitialite();

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), dogItemsArrayList);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerViewAdapter.notifyDataSetChanged();

    }


    private void dataInitialite() {

        dogItemsArrayList = new ArrayList<>();

        dogNames = new String[]{
                getString(R.string.dog_name1),
                getString(R.string.dog_name2),
                getString(R.string.dog_name3),
                getString(R.string.dog_name4),
                getString(R.string.dog_name5),
                getString(R.string.dog_name6),
                getString(R.string.dog_name7),
                getString(R.string.dog_name8),
                getString(R.string.dog_name9)

        };

        dogImages = new int[]{
                R.drawable.australian_shepherd2,
                R.drawable.chiuauau2,
                R.drawable.german2,
                R.drawable.golden2,
                R.drawable.labrador2,
                R.drawable.newfoundland2,
                R.drawable.poodle2,
                R.drawable.rottweiler2,
                R.drawable.shih_tzu2
        };
        for (int i = 0; i < dogNames.length; i++)
        {
            DogItems dogItems = new DogItems(dogNames[i], dogImages[i]);
            dogItemsArrayList.add(dogItems);
        }
    }
}

