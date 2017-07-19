package edu.stlcc.jasonmayer.javaclass.views;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import edu.stlcc.jasonmayer.javaclass.R;
import edu.stlcc.jasonmayer.javaclass.models.Person;


public class PersonAdapter extends RecyclerView.Adapter<PersonViewHolder> {
    private LayoutInflater layoutInflater;
    private List<Person> persons = new ArrayList<>();

    public PersonAdapter(LayoutInflater layoutInflater) {
        this.layoutInflater = layoutInflater;
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PersonViewHolder(layoutInflater.inflate(R.layout.person_view, parent, false));
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {
        holder.bind(persons.get(position));
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
        for(Person person : persons) {
            Log.e("WTF", "setPersons: " + person.getDisplayText());
        }
        notifyDataSetChanged();
    }
}
