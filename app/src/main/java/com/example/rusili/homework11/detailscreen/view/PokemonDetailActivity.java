package com.example.rusili.homework11.detailscreen.view;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.rusili.homework11.R;
import com.example.rusili.homework11.detailscreen.model.Pokemon;
import com.example.rusili.homework11.network.RetrofitFactory;
import com.example.rusili.homework11.pokedexActivity.view.PokedexFragment;
import com.squareup.picasso.Picasso;

public class PokemonDetailActivity extends AppCompatActivity {
    private RetrofitFactory.PokemonNetworkListener pokemonNetworkListener;

    RecyclerView recyclerView;
    Boolean bol;
    TextView name, type1, type2;
    ImageView view1;
    String id;
    ProgressBar hp, ak, special_ak, special_dk, speed, def;
    String imgane;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        setContentView();

        Intent intent = getIntent();

        id = intent.getStringExtra("name");
        bol = intent.getBooleanExtra("test", false);
        initialize();
        imgane = intent.getStringExtra("1");

//
        initialize();

    }

    private void setContentView() {

        view1 = (ImageView) findViewById(R.id.image1);

        type1 = (TextView) findViewById(R.id.type1);
        type2 = (TextView) findViewById(R.id.type2);

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

                name.setText(id.toUpperCase());


                Picasso.with(getApplicationContext())
                        .load(pokemon.getSprites().getFront_default()).centerCrop().fit()
                        .into((ImageView) findViewById(R.id.image1));

//                Glide.with(getApplicationContext())
//                        .load(pokemon.getSprites().getFront_default())
//                        .into(view1);


                if (pokemon.getTypes()[0] != null) {
                    type1.setText(pokemon.getTypes()[0].getType().getName());
                    switch (pokemon.getTypes()[0].getType().getName()) {
                        case "fire":
                            type1.setBackgroundColor(getResources().getColor(R.color.fire));
                            break;
                        case "water":
                            type1.setBackgroundColor(getResources().getColor(R.color.water));
                            break;
                        case "poison":
                            type1.setBackgroundColor(getResources().getColor(R.color.poison));
                            break;
                        case "bug":
                            type1.setBackgroundColor(getResources().getColor(R.color.bug));
                            break;
                        case "ground":
                            type1.setBackgroundColor(getResources().getColor(R.color.ground));
                            break;
                        case "electric":
                            type1.setBackgroundColor(getResources().getColor(R.color.electric));
                            break;
                        case "normal":
                            type1.setBackgroundColor(getResources().getColor(R.color.normal));
                            break;
                        case "fairy":
                            type1.setBackgroundColor(getResources().getColor(R.color.fairy));
                            break;
                        case "fighting":
                            type1.setBackgroundColor(getResources().getColor(R.color.fighting));
                            break;
                        case "psychic":
                            type1.setBackgroundColor(getResources().getColor(R.color.psychic));
                            break;
                        case "steel":
                            type1.setBackgroundColor(getResources().getColor(R.color.steel));
                            break;
                        case "ice":
                            type1.setBackgroundColor(getResources().getColor(R.color.ice));
                            break;
                        case "ghost":
                            type1.setBackgroundColor(getResources().getColor(R.color.ghost));
                            break;
                        case "rock":
                            type1.setBackgroundColor(getResources().getColor(R.color.rock));
                            break;
                        case "dragon":
                            type1.setBackgroundColor(getResources().getColor(R.color.dragon));
                            break;
                        case "flying":
                            type1.setBackgroundColor(getResources().getColor(R.color.flying));
                            break;
                    }
                }


                if (pokemon.getTypes().length >= 2) {
                    type2.setText(pokemon.getTypes()[1].getType().getName());
                    switch (pokemon.getTypes()[1].getType().getName()) {
                        case "fire":
                            type2.setBackgroundColor(getResources().getColor(R.color.fire));
                            break;
                        case "water":
                            type2.setBackgroundColor(getResources().getColor(R.color.water));
                            break;
                        case "poison":
                            type2.setBackgroundColor(getResources().getColor(R.color.poison));
                            break;
                        case "bug":
                            type2.setBackgroundColor(getResources().getColor(R.color.bug));
                            break;
                        case "ground":
                            type2.setBackgroundColor(getResources().getColor(R.color.ground));
                            break;
                        case "electric":
                            type2.setBackgroundColor(getResources().getColor(R.color.electric));
                            break;
                        case "normal":
                            type2.setBackgroundColor(getResources().getColor(R.color.normal));
                            break;
                        case "fairy":
                            type2.setBackgroundColor(getResources().getColor(R.color.fairy));
                            break;
                        case "fighting":
                            type2.setBackgroundColor(getResources().getColor(R.color.fighting));
                            break;
                        case "psychic":
                            type2.setBackgroundColor(getResources().getColor(R.color.psychic));
                            break;
                        case "steel":
                            type2.setBackgroundColor(getResources().getColor(R.color.steel));
                            break;
                        case "ice":
                            type2.setBackgroundColor(getResources().getColor(R.color.ice));
                            break;
                        case "ghost":
                            type2.setBackgroundColor(getResources().getColor(R.color.ghost));
                            break;
                        case "rock":
                            type2.setBackgroundColor(getResources().getColor(R.color.rock));
                            break;
                        case "dragon":
                            type2.setBackgroundColor(getResources().getColor(R.color.dragon));
                            break;
                        case "flying":
                            type2.setBackgroundColor(getResources().getColor(R.color.flying));
                            break;
                        case "grass":
                            type2.setBackgroundColor(getResources().getColor(R.color.grass));
                            break;
                    }
                }


                speed.setProgress(pokemon.getStats()[0].getBase_stat());
                special_dk.setProgress(pokemon.getStats()[1].getBase_stat());
                special_ak.setProgress(pokemon.getStats()[2].getBase_stat());
                def.setProgress(pokemon.getStats()[3].getBase_stat());
                ak.setProgress(pokemon.getStats()[4].getBase_stat());
                hp.setProgress(pokemon.getStats()[5].getBase_stat());


            }
        };

        RetrofitFactory.getInstance().setPokemonNetworkListener(pokemonNetworkListener);
        RetrofitFactory.getInstance().getPokemon(id);

        Log.e("You clicked this", id);
    }
}
