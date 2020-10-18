package com.example.covid_19tracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends ArrayAdapter<Country>{
    private Context context;
    private List<Country> countryList;
    private List<Country> countryListFilter;
    public MyAdapter(@NonNull Context context, List<Country> countryList){

        super(context,R.layout.list_custom_item,countryList);
        this.context=context;
        this.countryList=countryList;
        this.countryListFilter=countryList;
    }
    @NonNull
    @Override
    public View getView(int position,@Nullable View convertView,@NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_custom_item,null,true);
        TextView tvCountryName=view.findViewById(R.id.countryName);
        ImageView imageView=view.findViewById(R.id.imageFlag);
        tvCountryName.setText(countryListFilter.get(position).getCountry());
        Glide.with(context).load(countryListFilter.get(position).getFlag()).into(imageView);
        return view;
    }

    @Override
    public int getCount() {
        return countryListFilter.size();
    }
    @Nullable
    @Override
    public Country getItem(int position){
        return countryListFilter.get(position);
    }
    @Override
    public long getItemId(int position){
        return position;
    }

    @NonNull
    @Override
    public Filter getFilter() {
        Filter filter=new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults=new FilterResults();
                if(constraint==null||constraint.length()==0){
                    filterResults.count=countryList.size();
                    filterResults.values=countryList;
                }else{
                    List<Country> result=new ArrayList<>();
                    String search=constraint.toString().toLowerCase();
                    for(Country item:countryList){
                        if(item.getCountry().toLowerCase().contains(search)){
                            result.add(item);
                        }
                        filterResults.count=result.size();
                        filterResults.values=result;
                    }
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                       countryListFilter=(List<Country>)results.values;
                       AffectedCountries.countryListView=(List<Country>) results.values;
                       notifyDataSetChanged();
            }
        };

        return filter;
    }
}
