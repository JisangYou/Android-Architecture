package com.example.jetpack;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TestBindingAdapter extends RecyclerView.Adapter<TestBindingAdapter.BindingHolder> {

    ArrayList<String> arrayList;
    Context context;

    public TestBindingAdapter(Context context) {
        arrayList = new ArrayList<String>();
        arrayList.add("jisang");
        this.context = context;
    }

    @NonNull
    @Override
    public BindingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull BindingHolder holder, int position) {

        String item = arrayList.get(position);

        /**
         * ~~
         */
//        holder.getBinding().setData(getItem(position));

//        holder.getBinding().setVariable(BR.item, item);
        holder.getBinding().executePendingBindings();

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    // 즉각적인 바인딩하기
    class BindingHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {
        private T binding;

        //    public BindingHolder(@NonNull View itemView) {
//        super(itemView);
//    }
        public BindingHolder(@NonNull T binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public T getBinding() {
            return binding;
        }

    }
}
