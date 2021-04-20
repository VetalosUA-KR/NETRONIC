package com.vitalii.netronic.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.vitalii.netronic.R;
import com.vitalii.netronic.pojo.Result;

import java.util.ArrayList;
import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {

    private List<Result> persons = new ArrayList<>();
    private OnPersonClickListener onPersonClickListener;

    public List<Result> getPersons() {
        return persons;
    }

    public void setPersons(List<Result> persons) {
        this.persons = persons;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_item, parent, false);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {

        Result person = persons.get(position);
        holder.textViewFirstName.setText(person.getName().getFirst());
        holder.textViewLastName.setText(person.getName().getLast());

        Picasso.get().load(person.getPicture().getThumbnail()).into(holder.imageViewPhoto);

    }

    @Override
    public int getItemCount() {
        return persons.size();
    }


    class PersonViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageViewPhoto;
        private TextView textViewFirstName;
        private TextView textViewLastName;

        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewPhoto = itemView.findViewById(R.id.person_photo);
            textViewFirstName = itemView.findViewById(R.id.person_first_name);
            textViewLastName = itemView.findViewById(R.id.person_last_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(onPersonClickListener != null) {
                        onPersonClickListener.onPersonClick(getAdapterPosition());
                    }
                }
            });
        }
    }

    public interface  OnPersonClickListener {
        void onPersonClick(int position);
    }

    public void setOnPersonClickListener(OnPersonClickListener onPersonClickListener) {
        this.onPersonClickListener = onPersonClickListener;
    }
}
