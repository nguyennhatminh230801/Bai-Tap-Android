package com.example.btvntuan7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Covid19Adapter extends RecyclerView.Adapter<Covid19Adapter.ViewHolder> implements Filterable{
    List<Covid19> list;
    List<Covid19> listAll;
    Context context;
    IOnClickCovid19 iOnClickCovid19;

    public void setiOnClickCovid19(IOnClickCovid19 iOnClickCovid19) {
        this.iOnClickCovid19 = iOnClickCovid19;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView countries, numbersofCase, numbersofDeath, numbersofRelief;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            countries = itemView.findViewById(R.id.Countries);
            numbersofCase = itemView.findViewById(R.id.NumberofCase1);
            numbersofDeath = itemView.findViewById(R.id.NumberofDeath1);
            numbersofRelief = itemView.findViewById(R.id.NumberofRelief1);
        }
    }

    public Covid19Adapter(List<Covid19> list, Context context) {
        this.list = list;
        listAll = new ArrayList<>(list);
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.student_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Covid19 covid19 = list.get(position);
        holder.countries.setText(covid19.getCountries());
        holder.numbersofCase.setText(covid19.getNumbersofCases());
        holder.numbersofDeath.setText(covid19.getNumbersofDeath());
        holder.numbersofRelief.setText(covid19.getNumbersofRelief());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public Filter getFilter() {
        return Filter1;
    }

    private Filter Filter1 = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Covid19> filteredList = new ArrayList<>();
            String test1 = constraint.toString();

            if(constraint == null || constraint.length() == 0) {
                filteredList.addAll(listAll);
            }
            else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Covid19 covid19 : listAll){
                    if(covid19.getCountries().toLowerCase().contains(filterPattern)){
                        filteredList.add(covid19);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            list.clear();
            list.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
}
