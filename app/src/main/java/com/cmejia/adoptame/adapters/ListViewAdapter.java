package com.cmejia.adoptame.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.cmejia.adoptame.R;
import com.cmejia.adoptame.clases.Pet;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<Pet> {
    private List<Pet> list;

    public ListViewAdapter(@NonNull Context context, List<Pet> data) {
        super(context, R.layout.list_view_item, data);
        this.list = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.list_view_item, null);

        TextView name = item.findViewById(R.id.pet_name_tv);
        name.setText(list.get(position).getName());

        TextView age = item.findViewById(R.id.pet_age_tv);
        age.setText(String.format("Edad: %s", list.get(position).getAge()));

        return item;
    }
}
