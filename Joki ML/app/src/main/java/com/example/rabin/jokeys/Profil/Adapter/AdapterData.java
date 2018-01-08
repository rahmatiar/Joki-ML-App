package com.example.rabin.jokeys.Profil.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rabin.jokeys.Profil.InsertData;
import com.example.rabin.jokeys.Profil.Model.ModelData;
import com.example.rabin.jokeys.R;

import java.util.List;

/**
 * Created by rabin on 04/01/2018.
 */

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData>{

    private List<ModelData> mItems;
    private Context context;

    public AdapterData(Context context,List<ModelData> items){
        this.mItems = items;
        this.context = context;
    }

    @Override
    public HolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_row,parent,false);
        HolderData holderData = new HolderData(layout);
        return holderData;
    }

    @Override
    public void onBindViewHolder(HolderData holder, int position) {
        ModelData md = mItems.get(position);
        holder.tvnama_game.setText(md.getNama_game());
        holder.tvranked.setText(md.getRanked());
        holder.tvid.setText(md.getId());

        holder.md = md;
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class HolderData extends RecyclerView.ViewHolder{
        TextView tvnama_game,tvranked, tvid;
        ModelData md;

        public HolderData(View view){
            super(view);

            tvnama_game=(TextView)view.findViewById(R.id.nama_game);
            tvranked=(TextView)view.findViewById(R.id.ranked);
            tvid=(TextView)view.findViewById(R.id.id);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent update = new Intent(context, InsertData.class);
                    update.putExtra("update",1);
                    update.putExtra("id",md.getId());
                    update.putExtra("nama_game",md.getNama_game());
                    update.putExtra("id_game",md.getId_game());
                    update.putExtra("ranked",md.getRanked());

                    context.startActivity(update);


                }
            });
        }
    }
}
