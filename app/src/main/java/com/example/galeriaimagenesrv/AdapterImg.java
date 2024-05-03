package com.example.galeriaimagenesrv;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.galeriaimagenesrv.databinding.ListaImagenesBinding;

import java.util.List;

public class AdapterImg extends RecyclerView.Adapter<AdapterImg.GaleriaViewHolder> {
    //1-Añadir representación de datos
    private List<Item> itemGaleria;
    private Context contexto;
    private SendItem escuchador;

    public AdapterImg(List<Item> itemGaleria, Context contexto, SendItem escuchador) {
        this.itemGaleria = itemGaleria;
        this.contexto = contexto;
        this.escuchador = escuchador;
    }

    @NonNull
    @Override
    public GaleriaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListaImagenesBinding mBiding = ListaImagenesBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new GaleriaViewHolder(mBiding);
    }

    @Override
    public void onBindViewHolder(@NonNull GaleriaViewHolder holder, int position) {
        final Item item = itemGaleria.get(position);
        holder.descripcionImg.setText(item.getDescripcion());

        Glide.with(contexto).
                load(item.getUrl())
                .centerCrop()
                .override(300, 300)
                .into(holder.imgRV);

    }

    @Override
    public int getItemCount() {

        return itemGaleria.size();
    }


    //2- Clase interna que representa vista lista_imagenes
    public class GaleriaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView descripcionImg;
        private ImageView imgRV;

        public GaleriaViewHolder(@NonNull ListaImagenesBinding mBiding) {
            super(mBiding.getRoot());

            imgRV = mBiding.imgRV;
            descripcionImg = mBiding.descripcionImg;

            // OnClickListener en el el layout inflado(vista)
            // Cuando se hace clic en cualquier parte del elemento del RecyclerView, se activará este OnClickListener
            mBiding.getRoot().setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {
            // Se obtiene la posición del elemento dentro del adaptador
            int position = getAdapterPosition();
            Log.d("AdapterPosition", "Position: " + position);

            // Se verifica si la posición obtenida es válida
            if (position != RecyclerView.NO_POSITION) {
                // Se envía el elemento correspondiente a través de un método de la interfaz "escuchador" que es  una instancia de una interfaz que tiene el método "sendItem()"
                // itemGaleria es la lista de elementos que se están mostrando en el RecyclerVie
                escuchador.sendItem(itemGaleria.get(position));
            }
        }
    }


    public interface SendItem {
        void sendItem(Item item);
    }

}
