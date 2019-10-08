package com.cmejia.adoptame.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.cmejia.adoptame.R;
import com.cmejia.adoptame.clases.Pet;
import com.cmejia.adoptame.holders.ViewHolder;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<Pet> {
    private static List<Pet> list;

    public ListViewAdapter(@NonNull Context context, List<Pet> data) {
        super(context, R.layout.list_view_item, data);
        list = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View item = convertView;
        ViewHolder holder;

        if(item == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            item = inflater.inflate(R.layout.list_view_item, null);

            holder = new ViewHolder();
            holder.name = item.findViewById(R.id.pet_name_tv);
            holder.age = item.findViewById(R.id.pet_age_tv);
            holder.image = item.findViewById(R.id.pet_iv);

            item.setTag(holder);
        } else {
            holder = (ViewHolder) item.getTag();
        }

        holder.name.setText(list.get(position).getName());
        holder.age.setText(String.format("Edad: %s", list.get(position).getAge()));
        holder.image.setImageDrawable(list.get(position).getImage());

        return item;
    }

    public static void addItem(Pet obj) {
        list.add(obj);
    }

}
