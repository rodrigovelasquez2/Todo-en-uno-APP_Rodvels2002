package com.velasquez.todoenuno.cardView.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.velasquez.todoenuno.R;
import com.velasquez.todoenuno.cardView.entity.Pet;

import java.util.List;

public class AdapterData extends RecyclerView.Adapter<AdapterData.ViewHolders> {
    private List<Pet> listaMascotas;

    public AdapterData(List<Pet> listaMascotas) {
        this.listaMascotas = listaMascotas;
    }//Fin AdapterData

    /**
     * Metodo que inflara datos al Recycle
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return
     */
    @NonNull
    @Override
    public AdapterData.ViewHolders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_card_views_template, null, false);
        return new ViewHolders(view);
    }//Fin AdapterData

    @Override
    public void onBindViewHolder(@NonNull AdapterData.ViewHolders holder, int position) {
        holder.imageView.setImageResource(listaMascotas.get(position).getImagen());
        holder.textViewPetsName.setText(listaMascotas.get(position).getPetsName());
        holder.textViewIdentidad.setText(listaMascotas.get(position).getNumeroIdentidad());
        holder.textViewDescripcion.setText(listaMascotas.get(position).getDescripcion());
        holder.textViewRaza.setText(listaMascotas.get(position).getRaza());
        holder.textViewEdad.setText(listaMascotas.get(position).getEdad());
        holder.textViewGenero.setText(listaMascotas.get(position).getGenero());
        holder.textViewColor.setText(listaMascotas.get(position).getColor());
    }//Fin onBindViewHolder

    @Override
    public int getItemCount() {
        return listaMascotas.size();
    }//Fin getItemCount

    public class ViewHolders extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewPetsName;
        TextView textViewIdentidad;
        TextView textViewDescripcion;
        TextView textViewRaza;
        TextView textViewEdad;
        TextView textViewGenero;
        TextView textViewColor;

        public ViewHolders(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.avatar_images);
            textViewPetsName = itemView.findViewById(R.id.textViewPetsName_CardView);
            textViewIdentidad = itemView.findViewById(R.id.identidad_CardView);
            textViewDescripcion = itemView.findViewById(R.id.descripcion_CardView);
            textViewRaza = itemView.findViewById(R.id.raza_CardView);
            textViewEdad = itemView.findViewById(R.id.edad_CardView);
            textViewGenero = itemView.findViewById(R.id.genero_CardView);
            textViewColor = itemView.findViewById(R.id.color_CardView);
        }//Fin ViewHolders
    }//Fin ViewHolders
}//Fin AdapterData
