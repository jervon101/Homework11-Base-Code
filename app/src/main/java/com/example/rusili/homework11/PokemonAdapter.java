package com.example.rusili.homework11;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rusili.homework11.pokedexActivity.model.objects.PokemonEntries;
import com.example.rusili.homework11.util.PokeMonHolder;

import java.util.List;

/**
 * Created by jervon.arnoldd on 11/30/17.
 */

public class PokemonAdapter extends RecyclerView.Adapter<PokeMonHolder> {


    List<PokemonEntries> pokemonEntries;


    public PokemonAdapter(List<PokemonEntries> entriesList) {
        this.pokemonEntries=entriesList;
    }

    @Override
    public PokeMonHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dex_view,parent,false);


        return new PokeMonHolder(view);

    }

    @Override
    public void onBindViewHolder(PokeMonHolder holder, int position) {
     PokemonEntries  entries = pokemonEntries.get(position);

     holder.onBind(entries);


    }

    @Override
    public int getItemCount() {
        return pokemonEntries.size();
    }
}
