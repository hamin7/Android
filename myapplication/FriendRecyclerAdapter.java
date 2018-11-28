package com.example.hamin.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.RequestManager;

import java.util.ArrayList;
import java.util.List;

public class FriendRecyclerAdapter extends RecyclerView.Adapter<FriendRecyclerAdapter.FriendRecyclerViewHolder> {

    private List<FriendDTO> list;
    private RequestManager manager;

    public FriendRecyclerAdapter(RequestManager manager) {
        this.list=new ArrayList<>();
        this.manager = manager;
    }

    @NonNull
    @Override
    public FriendRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_friend, null, false);     // inflate는 확장 시키는거.
        return new FriendRecyclerViewHolder(v);      // viewHolder를 만들어서 반환 했구나라고 생각하면 됌.
    }

    @Override
    public void onBindViewHolder(@NonNull FriendRecyclerViewHolder holder, int position) {     // position은 홀더의 몇번쨰 인지
        FriendDTO itemAtPosition = this.list.get(position);     // i번째 아이템을 넣기.
        holder.textViewName.setText(itemAtPosition.getFriendName());      // i번째 홀더에 넣기
        holder.textViewStatus.setText(itemAtPosition.getFrinedStatus());

        manager.load(itemAtPosition.getFaceId()).into(holder.imageViewFace);     //
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addItem(FriendDTO item){
        list.add(item);      // 맨 끝에 집어넣기 list는 선입 선출.
        notifyDataSetChanged();     // 바뀌었다고 알려주기.
    }
    public class FriendRecyclerViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageViewFace;
        private TextView textViewName;
        private  TextView textViewStatus;

        public FriendRecyclerViewHolder(View itemView) {
            super(itemView);
            imageViewFace=itemView.findViewById(R.id.img_idface);
            textViewName = itemView.findViewById((R.id.text_friend_name));
            textViewStatus = itemView.findViewById((R.id.text_friend_status));
        }
    }
}
