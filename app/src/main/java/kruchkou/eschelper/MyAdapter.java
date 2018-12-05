package kruchkou.eschelper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<RecyclerItem> listItems;
    private Context mContext;

    public MyAdapter(List<RecyclerItem> listItems, Context mContext) {
        this.listItems = listItems;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        final RecyclerItem itemList = listItems.get(position);
        holder.actNumber.setText(itemList.getNumber());
        holder.actNote.setText(itemList.getNote());
        holder.actModel.setText(itemList.getModel());
        holder.actId.setText(itemList.getAct_id());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView actNumber;
        public TextView actModel;
        public TextView actId;
        public TextView actNote;
        public ViewHolder(View itemView) {
            super(itemView);
            actId = (TextView) itemView.findViewById(R.id.actId);
            actModel = (TextView) itemView.findViewById(R.id.actModel);
            actNote = (TextView) itemView.findViewById(R.id.actNote);
            actNumber = (TextView) itemView.findViewById(R.id.actNumber);
        }
    }
}