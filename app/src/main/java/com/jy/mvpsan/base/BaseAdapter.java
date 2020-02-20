package com.jy.mvpsan.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseAdapter.BaseViewHolder> {

    private OnItemClickListener onItemClickListener;
    protected List<T> mDatas;
    protected Context mContext;

    public BaseAdapter(List<T> mDatas){
        this.mDatas = mDatas;
        setHasStableIds(true);
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        mContext = viewGroup.getContext();
        View view = LayoutInflater.from(mContext).inflate(getLayoutId(),viewGroup,false);
        final BaseViewHolder baseViewHolder = new BaseViewHolder(view);
        view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(onItemClickListener != null){
                    onItemClickListener.onItemClick(v,baseViewHolder.getLayoutPosition());
                }
            }
        });
        return baseViewHolder;
    }


    public void onBindViewHolder(BaseViewHolder viewHolder, int i) {
        T t = mDatas.get(i);
        bindData(viewHolder,i,t);
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    public void refresh(List<T> list){
        this.mDatas.clear();
        this.mDatas.addAll(list);
        notifyDataSetChanged();
    }

    public void addData(List<T> list){
        this.mDatas.addAll(list);
        notifyDataSetChanged();
    }

    public void addDataWithoutAnim(List<T> datas){
        if(datas == null) return;
        int size = datas.size();
        this.mDatas.addAll(datas);
        notifyItemChanged(size,datas.size());
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    protected abstract int getLayoutId();

    protected abstract void bindData(BaseViewHolder holder,int positon,T t);

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(View v, int position);
    }

    class BaseViewHolder extends RecyclerView.ViewHolder{

        private SparseArray<View> myViewSparseArray;
        public BaseViewHolder(@NonNull View itemView) {
            super(itemView);
            myViewSparseArray = new SparseArray<>();
        }

        public View getView(int id){
            View view = myViewSparseArray.get(id);
            if(view == null){
                view = itemView.findViewById(id);
                myViewSparseArray.put(id,view);
            }
            return view;
        }
    }
}
