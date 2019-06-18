package com.agri.atef.myapplication.Adabter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.agri.atef.myapplication.R;
import com.agri.atef.myapplication.model.frt;
import com.agri.atef.myapplication.showitems;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class fruitsAdabter extends RecyclerView.Adapter<fruitsAdabter.fruitsHolder> implements Filterable  {

    private final Context context;
    private static List<frt> dataSource;
    private static  List<frt> dataSourcefull;

  //searc
   // private ArrayList<dataSourcefull> dataSourcefull;

    public fruitsAdabter(Context context){
        this.context=context;

    }
    @NonNull
    @Override
    public fruitsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.row_item,parent,false);
        fruitsHolder holder=new fruitsHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull fruitsHolder holder, int position) {
        frt frts= dataSource.get(position);
        holder.textView.setText(frts.getName());
        Picasso.with(context).load(frts.getImage()).into(holder.imageView);
//        holder.imageView.setImageResource(frts.getImage());
    }

    @Override
    public int getItemCount() {
        return dataSource!=null?dataSource.size():0;
    }

    public void setDataSource(List<frt> dataSource) {
        this.dataSource=dataSource;

//search
        dataSourcefull=new ArrayList<>(dataSource);
    }

    class fruitsHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;
        public fruitsHolder(@NonNull View itemView) {

            super(itemView);
            imageView=(ImageView) itemView.findViewById(R.id.imgfrts);
            textView=(TextView) itemView.findViewById(R.id.txtfrts);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v ) {
                    int itemPosition = getLayoutPosition();
                   frt frts = dataSource.get(getAdapterPosition());
                    Toast.makeText(context,frts.getName(),Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(context,showitems.class);
                     intent.putExtra("name",frts.getName());
                    intent.putExtra("img",frts.getImage());
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
            List<frt> filteredList=new ArrayList<>();
            if (constraint == null || constraint.length()==0){
                filteredList.addAll(dataSourcefull);
            }
            else {
                String filterpattern = constraint.toString().toLowerCase().trim();

                for(frt item :dataSourcefull)
                {
                    if(item.getName().toLowerCase().contains(filterpattern)){
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

