package com.crazy.booksoul.main.home;

import androidx.recyclerview.widget.RecyclerView;

public class Model {
    private RecyclerView recyclerView;

    public Model(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }
}
