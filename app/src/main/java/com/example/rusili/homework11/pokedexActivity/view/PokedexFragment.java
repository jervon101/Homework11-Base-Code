package com.example.rusili.homework11.pokedexActivity.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;

import com.example.rusili.homework11.PokemonAdapter;
import com.example.rusili.homework11.R;
import com.example.rusili.homework11.detailscreen.view.PokemonDetailActivity;
import com.example.rusili.homework11.network.RetrofitFactory;
import com.example.rusili.homework11.pokedexActivity.model.Pokedex;
import com.example.rusili.homework11.pokedexActivity.model.objects.PokemonEntries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rusi.li on 11/22/17.
 */

public class PokedexFragment extends Fragment {

    Context context;
    RecyclerView recyclerView;
    Intent intent;

    private static final String SHARED_PREFS_KEY = "notes";
    private SharedPreferences log;

    private RetrofitFactory.PokedexNetworkListener pokedexNetworkListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cycle_view, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycle_view);
        getPokedexList();
        intent = new Intent(container.getContext(), PokemonDetailActivity.class);

//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);

//        recyclerView.setLayoutManager(linearLayoutManager);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        return view;

    }

    private void getPokedexList() {
        pokedexNetworkListener = new RetrofitFactory.PokedexNetworkListener() {
            @Override
            public void pokedexCallback(Pokedex pokedex) {
                List<PokemonEntries> entriesList = new ArrayList<>();
                // TODO: show Pokemon
                // Each pokemon is in the Pokemon_Species object.


                PokemonEntries[] entries = pokedex.getPokemon_entries();



                Log.e("Lenght ", entries.length + "");


//                List<PokemonEntries> entriesList = new ArrayList<>(Arrays.asList(entries));


                for (int i = 0; i < entries.length; i++) {

//                    String url = log.getString(pokedex.getPokemon_entries()[i].getPokemon_species().getName(), null);

//                    pokedex.getPokemon_entries()[i].getPokemon_species().setUrl(url);

                    entriesList.add(pokedex.getPokemon_entries()[i]);
//name





                    intent.putExtra("test", true);
                    intent.putExtra("1", pokedex.getPokemon_entries()[i].getPokemon_species().getName());


//                    Log.e("Lenght of list ", pokedex.getPokemon_entries()[i].getPokemon_species().getName()+ "");
                }


                PokemonAdapter adapter = new PokemonAdapter(entriesList);

                recyclerView.setAdapter(adapter);

//                Log.e("Lenght of list ", entriesList.size() + "");


            }
        };
        RetrofitFactory.getInstance().setPokedexListener(pokedexNetworkListener);
        RetrofitFactory.getInstance().getPokedex(2);
    }
}
