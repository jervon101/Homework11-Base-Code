package com.example.rusili.homework11.util;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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

    public PokeMonHolder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.image);
        textView= (TextView) itemView.findViewById(R.id.text);
        context = itemView.getContext();

    }

    public void onBind(final PokemonEntries entries) {


    textView.setText(entries.getPokemon_species().getName());
    textView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(itemView.getContext(), PokemonDetailActivity.class);
            intent.putExtra("name",entries.getPokemon_species().getName());
            context.startActivity(intent);
        }
    });




//        Picasso.with(itemView.getContext()).load(entries.getPokemon_species().getUrl()).into(imageView);



        Log.e("The VAlue is ",entries.getPokemon_species().getName()+"");
        Log.e(".getUrl() :",entries.getPokemon_species().getUrl()+"");

    }
}
