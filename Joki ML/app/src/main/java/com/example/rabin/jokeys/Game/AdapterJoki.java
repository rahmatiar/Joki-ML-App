package com.example.rabin.jokeys.Game;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.rabin.jokeys.R;

import java.util.List;

/**
 * Created by Afan on 24/12/2017.
 */

public class AdapterJoki extends RecyclerView.Adapter<AdapterJoki.HolderItemJoki> {
    List<ModelJoki> mListJoki;
    Context context;

    public AdapterJoki(List<ModelJoki> mListJoki, Context context) {
        this.mListJoki = mListJoki;
        this.context = context;
    }

    @Override
    public HolderItemJoki onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listml,parent,false);

        HolderItemJoki holderItemJoki = new HolderItemJoki(layout);

        return holderItemJoki;
    }

    @Override
    public void onBindViewHolder(HolderItemJoki holder, int position) {
        ModelJoki mList = mListJoki.get(position);

        holder.tvNama_Joki.setText(mList.getNama_Joki());
        holder.tvNo_HP_Joki.setText(mList.getNo_HP());
        final String number = mList.getNo_HP();
        holder.btTransfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+number));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mListJoki.size();
    }


    public class HolderItemJoki extends RecyclerView.ViewHolder
    {
        TextView tvNama_Joki, tvNo_HP_Joki;
        public Button btTransfer;

        public HolderItemJoki(View v)
        {
            super(v);

            tvNama_Joki = (TextView)v.findViewById(R.id.tvNama_Joki);
            tvNo_HP_Joki = (TextView)v.findViewById(R.id.tvNo_HP_Joki);
            btTransfer = (Button)v.findViewById(R.id.btTransfer);

        }

    }



}
