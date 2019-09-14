package com.ucr.micuenca;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;
import android.view.View.OnClickListener;

import com.ucr.micuenca.BaseDeDatos.DatoGeneral;

import java.util.List;


/**
 * {@link RecyclerView}
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

    private List<DatoGeneral> temp;
    Context context;

    private final ListAdapterOnClickHandler mClickHandler;


    public interface ListAdapterOnClickHandler{
        void onClick(String title);
    }


    public ListAdapter(ListAdapterOnClickHandler clickHandler){
        mClickHandler = clickHandler;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements OnClickListener{
        public TextView mTitle, mDescription;

        public MyViewHolder(View view) {
            super(view);
            mTitle = (TextView) view.findViewById(R.id.tv_item_title);
            mDescription = (TextView) view.findViewById(R.id.tv_item_description);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int posicionAdaptador = getAdapterPosition();
            DatoGeneral datoGeneral = temp.get(posicionAdaptador);
            mClickHandler.onClick(datoGeneral.getTitulo());
        }
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        //View view = inflater.inflate(R.layout.list_item, viewGroup, false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position) {
        DatoGeneral datoGeneral = temp.get(position);
        myViewHolder.mTitle.setTextColor(Util.getColor(position, context));
        myViewHolder.mTitle.setText(datoGeneral.getTitulo());
        myViewHolder.mDescription.setText(Util.recortarTexto(datoGeneral.getDescripcion(), Util.TAMANO_DESCRIPCION_LISTA) + "...");
    }


    @Override
    public int getItemCount() {
        return temp.size();
    }

    public void setListData(List<DatoGeneral> datos){
        temp = datos;
        notifyDataSetChanged();
    }

    // Toast.makeText(this, ", Toast.LENGTH_SHORT).show();
}
