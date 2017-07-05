package edu.stlcc.jasonmayer.javaclass.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import edu.stlcc.jasonmayer.javaclass.R;
import edu.stlcc.jasonmayer.javaclass.models.Person;

class PersonViewHolder extends RecyclerView.ViewHolder {

    private final TextView personDescription;

    public PersonViewHolder(View inflate) {
        super(inflate);
        personDescription = (TextView) inflate.findViewById(R.id.person_description);
    }

    public void bind(Person person) {
        personDescription.setText(person.getDisplayText());
    }
}
