package rashmi.sampleproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import rashmi.sampleproject.R;
import rashmi.sampleproject.model.VideoModel;

/**
 * Created by rashmi.ramesh on 20-05-2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<VideoModel> videoModelArrayList;
    private Context context;


    // Provide a suitable constructor (depends on the kind of DataSet)
    public RecyclerViewAdapter(ArrayList<VideoModel> videoModelArrayList, Context context) {
        this.videoModelArrayList = videoModelArrayList;
        this.context = context;
    }

    /**
     * Provide a reference to the views for each data item
     * you provide access to all the views for a data item in a view holder
     * Contains views which are required to be displayed which is an item
     */
     class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtTitle, txtSubText, txtDescription;
        private ImageView icon;

        private ViewHolder(View v) {
            super(v);
            txtTitle = (TextView) v.findViewById(R.id.tv_title);
            txtSubText = (TextView) v.findViewById(R.id.tv_sub_text);
            txtDescription = (TextView) v.findViewById(R.id.tv_description);
            icon = (ImageView) v.findViewById(R.id.iv_icon);


        }
    }

    /**
     * @param parent   The ViewGroup into which the new View will be added after it is bound to an adapter position.
     * @param viewType int: The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     */

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        // create a new view --Inflate the layout and creates an instance of the ViewHolder class
        View v = LayoutInflater.from(context).inflate(R.layout.video_item_layout, parent, false);
        // set and layout parameters
        return new ViewHolder(v);


    }

    /**
     * @param holder   gets the view at a particular position
     *                 Replace the contents of a view (invoked by the layout manager)
     *                 get element from your DataSet at this position
     * @param position assign the data to the individual views in the row. data to the view.
     *                 replace the contents of the view with that element
     */
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        VideoModel recyclerViewModel = videoModelArrayList.get(position);

        holder.txtTitle.setText(recyclerViewModel.getTitle());
        holder.txtSubText.setText(recyclerViewModel.getSubText());
        holder.txtDescription.setText(recyclerViewModel.getDescription());
        holder.icon.setImageDrawable(recyclerViewModel.getIcon());


    }

    // Return the size of your DataSet -number of items in ArrayList
    @Override
    public int getItemCount() {
        return videoModelArrayList.size();

    }



}


