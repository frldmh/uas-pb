package com.example.moviedatabase;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

public class ListViewAdapter extends ArrayAdapter<MovieItem> {
    private List<MovieItem> movieItemList;
    private Context context;

    public ListViewAdapter(List<MovieItem> movieItemList, Context context) {
        super(context, R.layout.list_item, movieItemList);
        this.movieItemList = movieItemList;
        this.context = context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);

        View listViewItem = inflater.inflate(R.layout.list_item, null, true);

        TextView textViewTitle = listViewItem.findViewById(R.id.title);
        TextView textViewReleaseDate = listViewItem.findViewById(R.id.release_date);
        TextView textViewOverview = listViewItem.findViewById(R.id.overview);
        TextView textViewVoteAverage = listViewItem.findViewById(R.id.vote_average);


        MovieItem movieItem = movieItemList.get(position);

        textViewTitle.setText(movieItem.getTitle());
        textViewReleaseDate.setText(movieItem.getReleaseDate());
        textViewOverview.setText(movieItem.getOverview());
        textViewVoteAverage.setText(movieItem.getVoteAverage());

        return listViewItem;
    }
}