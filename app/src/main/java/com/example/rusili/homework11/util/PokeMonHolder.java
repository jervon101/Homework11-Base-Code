package com.example.rusili.homework11.util;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.rusili.homework11.R;
import com.example.rusili.homework11.detailscreen.view.PokemonDetailActivity;
import com.example.rusili.homework11.pokedexActivity.model.objects.PokemonEntries;
import com.squareup.picasso.Picasso;

/**
 * Created by jervon.arnoldd on 11/30/17.
 */

public class PokeMonHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView textView;
    Context context;
    CardView cardView;




    public PokeMonHolder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.pokeimage);
        textView = (TextView) itemView.findViewById(R.id.text);
        context = itemView.getContext();
        cardView =(CardView) itemView.findViewById(R.id.cardview);

    }

    public void onBind(final PokemonEntries entries) {

//        String url = log.getString(entries.getPokemon_species().getName(), null);







        textView.setText(entries.getPokemon_species().getName() +"   "+ entries.getEntry_number());
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(itemView.getContext(), PokemonDetailActivity.class);
                intent.putExtra("name", entries.getPokemon_species().getName());
                context.startActivity(intent);
            }
        });

       StringBuilder stringBuilder = new StringBuilder("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/");

       stringBuilder.append(entries.getEntry_number()).append(".png");


        Glide.with(itemView.getContext())
                        .load(stringBuilder.toString())
                        .into(imageView);
//

//        Picasso.with(itemView.getContext()).load(entries.getPokemon_species().getUrl()).into(imageView);


        Log.e("The VAlue is ", entries.getPokemon_species().getUrl() + "");
//        Log.e(".getUrl() :", url + "");

    }
}
