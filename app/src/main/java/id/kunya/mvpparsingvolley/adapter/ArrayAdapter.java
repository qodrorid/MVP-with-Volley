package id.kunya.mvpparsingvolley.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import id.kunya.mvpparsingvolley.R;
import id.kunya.mvpparsingvolley.model.ObjectModel;

/**
 * Created by muhammad on 05/05/17.
 */

public class ArrayAdapter extends RecyclerView.Adapter<ArrayAdapter.ArrayViewHolder> {

    private final Context context;
    private LayoutInflater inflater;
    private final List<ObjectModel.Item> list;

    public ArrayAdapter(Context context, ArrayList<ObjectModel.Item> list){
        this.context = context;
        this.list = list;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public ArrayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ArrayViewHolder(inflater.inflate(R.layout.item_array_list,parent,false));
    }

    @Override
    public void onBindViewHolder(ArrayViewHolder holder, int position) {
        ObjectModel.Item arrayItem = list.get(position);
        holder.tvID.setText(""+arrayItem.getId());
        holder.tvNama.setText(arrayItem.getNama());
        holder.tvJurusan.setText(arrayItem.getJurusan());
        holder.tvKelas.setText(arrayItem.getKelas());
        holder.tvMotto.setText(arrayItem.getMotto());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ArrayViewHolder extends RecyclerView.ViewHolder {

        TextView tvID, tvNama, tvKelas, tvJurusan, tvMotto;

        public ArrayViewHolder(View itemView) {
            super(itemView);
            tvID = (TextView) itemView.findViewById(R.id.id);
            tvNama = (TextView) itemView.findViewById(R.id.nama);
            tvKelas = (TextView) itemView.findViewById(R.id.kelas);
            tvJurusan = (TextView) itemView.findViewById(R.id.jurusan);
            tvMotto = (TextView) itemView.findViewById(R.id.motto);
        }
    }
}
