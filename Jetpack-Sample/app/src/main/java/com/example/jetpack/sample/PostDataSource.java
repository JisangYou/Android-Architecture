package com.example.jetpack.sample;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

public class PostDataSource extends PageKeyedDataSource<Integer, Post> {

    private PostService postService;

    public PostDataSource(PostService postService) {
        this.postService = postService;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, Post> callback) {
        
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Post> callback) {

    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Post> callback) {

    }
}
