package com.miempresa.applistpersonas.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.miempresa.applistpersonas.Model.PersonaModel;
import com.miempresa.applistpersonas.R;

import java.util.ArrayList;
import java.util.List;

public class ListaPersonasAdapter extends RecyclerView.Adapter<ListaPersonasAdapter.PersonaHolder> {

    private List<PersonaModel>listaPersonas = new ArrayList<>(  );

    public void setListaPersonas(List<PersonaModel> listaPersonas) {
        this.listaPersonas = listaPersonas;
        //ref
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PersonaHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {//nos dice que layout bamos aA UTILIZAR
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        PersonaHolder personaHolder = new PersonaHolder(inflater.inflate(R.layout.celda_persona,viewGroup,false ));
        return personaHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonaHolder personaHolder, int position) {
        PersonaModel persona = listaPersonas.get( position );

        personaHolder.tvNombres.setText( persona.getNombres() );
        personaHolder.tvTelefono.setText( persona.getTelefono() );

    }

    @Override
    public int getItemCount() {//cuantos elementos hay en la lista
        return listaPersonas.size();
    }

    class PersonaHolder extends RecyclerView.ViewHolder{

        TextView tvNombres;
        TextView tvTelefono;
        public PersonaHolder(View itemView) {
            super( itemView );
            tvNombres = itemView.findViewById( R.id.tvNombres );
            tvTelefono = itemView.findViewById( R.id.tvTelefono );

        }
    }
}
