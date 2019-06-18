package com.agri.atef.myapplication.Adabter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.agri.atef.myapplication.R;
import com.agri.atef.myapplication.model.ourVideoList;
import com.agri.atef.myapplication.showitems;

import java.util.ArrayList;
import java.util.List;

public class videoAdabter extends RecyclerView.Adapter<videoAdabter.videoHolder> implements Filterable  {

    private final Context context;
    private static List<ourVideoList> dataSource;
    private static  List<ourVideoList> dataSourcefull;

    //search
    // private ArrayList<dataSourcefull> dataSourcefull;

    public videoAdabter(Context context){
        this.context=context;

    }

    @Override
    public videoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.videodept,parent,false);
        videoHolder holder=new videoHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull videoHolder holder, int position) {
        ourVideoList ourVideo= dataSource.get(position);
        holder.textView.setText(ourVideo.getVideoDescription());
//        Picasso.with(context).load(ourVideo.getVideoList()).into((Target) holder.videoView);
        holder.videoView.setVideoURI(Uri.parse("android.resource://"+context.getPackageName()+"/"+R.raw.omar));
        holder.videoView.setMediaController(new MediaController(context));
        holder.videoView.requestFocus();
        holder.videoView.start();

//        holder.imageView.setImageResource(frts.getImage());
    }

    @Override
    public int getItemCount() {
        return dataSource!=null?dataSource.size():0;
    }

    public void setDataSource(List<ourVideoList> dataSource) {
        this.dataSource=dataSource;

//search
        dataSourcefull=new ArrayList<>(dataSource);
    }

    class videoHolder extends RecyclerView.ViewHolder{

        VideoView videoView;
        TextView textView;
        public videoHolder(@NonNull View itemView) {

            super(itemView);
            videoView= itemView.findViewById(R.id.videolist);
            textView= itemView.findViewById(R.id.videodescription);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v ) {
                    int itemPosition = getLayoutPosition();
                    ourVideoList ourVideo = dataSource.get(getAdapterPosition());
                    Toast.makeText(context,ourVideo.getVideoDescription(),Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(context, showitems.class);
                    intent.putExtra("name",ourVideo.getVideoDescription());
                    intent.putExtra("video",ourVideo.getVideoList());
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }
    private Filter exampleFilter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<ourVideoList> filteredList=new ArrayList<>();
            if (constraint == null || constraint.length()==0){
                filteredList.addAll(dataSourcefull);
            }
            else {
                String filterpattern = constraint.toString().toLowerCase().trim();

                for(ourVideoList item :dataSourcefull)
                {
                    if(item.getVideoDescription().toLowerCase().contains(filterpattern)){
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values=filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            dataSource.clear();
            dataSource.addAll((List) results.values);
            notifyDataSetChanged();

        }
    };

}