package com.example.rusili.homework11.detailscreen.view;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.detailscreen.model.Pokemon;
import com.example.rusili.homework11.network.RetrofitFactory;
import com.example.rusili.homework11.pokedexActivity.view.PokedexFragment;
import com.squareup.picasso.Picasso;

public class PokemonDetailActivity extends AppCompatActivity {
    private RetrofitFactory.PokemonNetworkListener pokemonNetworkListener;
    TextView name;
    ImageView view1;
    String id;
    ProgressBar hp, ak, special_ak, special_dk, speed, def;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        setContentView();
        Intent  intent = getIntent();

        String id = intent.getStringExtra("name");

        initialize();
    }

    private void setContentView() {
        final ImageView view1;
        view1 = (ImageView) findViewById(R.id.image1);


        name = (TextView) findViewById(R.id.name);
        hp = (ProgressBar) findViewById(R.id.hp);
        ak = (ProgressBar) findViewById(R.id.ak);
        special_ak = (ProgressBar) findViewById(R.id.special_ak);
        special_dk = (ProgressBar) findViewById(R.id.special_dk);
        speed = (ProgressBar) findViewById(R.id.speed);
        def = (ProgressBar) findViewById(R.id.def);

    }


    private void initialize() {
        getPokemonDetails();
    }

    private void getPokemonDetails() {
        pokemonNetworkListener = new RetrofitFactory.PokemonNetworkListener() {
            @Override
            public void pokemonCallback(Pokemon pokemon) {
                //TODO: Display pokemon data
                //Hint: Learn how to use Glide to display an image.
//
//				Picasso.with(getApplicationContext()).load(pokemon.getSprites().getFront_default().toString()).into(view1);
//
//				Log.e("URL",pokemon.getSprites().getFront_default());


//				for (int i = 0; i < pokemon.getStats().length; i++) {
//
//					switch (i){
//
//
//						case 0:
//							pokemon.getStats()[i].getStat().getName();
//							speed.setProgress(pokemon.getStats()[i].getBase_stat());
//							break;
//						case 1:
//							pokemon.getStats()[i].getStat().getName();
//							special_dk.setProgress(pokemon.getStats()[i].getBase_stat());
//							break;
//						case 2:
//							pokemon.getStats()[i].getStat().getName();
//							special_ak.setProgress(pokemon.getStats()[i].getBase_stat());
//							break;
//						case 3:
//							pokemon.getStats()[i].getStat().getName();
//							def.setProgress(pokemon.getStats()[i].getBase_stat());
//							break;
//						case 4:
//							pokemon.getStats()[i].getStat().getName();
//							ak.setProgress(pokemon.getStats()[i].getBase_stat());
//							break;
//						case 5:
//							pokemon.getStats()[i].getStat().getName();
//							hp.setProgress(pokemon.getStats()[i].getBase_stat());
//							break;
//					}
//				}

            }
        };


        RetrofitFactory.getInstance().setPokemonNetworkListener(pokemonNetworkListener);
        RetrofitFactory.getInstance().getPokemon(id);

        Log.e("You clicked this", id);
    }
}
