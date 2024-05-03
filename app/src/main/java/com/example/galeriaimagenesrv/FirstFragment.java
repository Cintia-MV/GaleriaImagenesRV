package com.example.galeriaimagenesrv;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.galeriaimagenesrv.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment implements AdapterImg.SendItem{

    private FragmentFirstBinding binding;
    private List<Item> galeria = new ArrayList<>();

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        RecyclerView recyclerView = binding.recyclerView;
        AdapterImg adaptador = new AdapterImg(returnItemList(), getContext(),this);
        recyclerView.setAdapter(adaptador);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    private List<Item> returnItemList() {
        Item item01 = new Item("Samuel Ferrara", "https://images.unsplash.com/photo-1506905925346-21bda4d32df4?q=80&w=1470&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");
        galeria.add(item01);
        Item item02 = new Item("Greg Rakozy", "https://images.unsplash.com/photo-1444703686981-a3abbc4d4fe3?q=80&w=1470&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D ");
        galeria.add(item02);
        Item item03 = new Item("Vincentiu Solomon", "https://images.unsplash.com/photo-1419242902214-272b3f66ee7a?q=80&w=1513&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");
        galeria.add(item03);
        Item item04 = new Item("Ryan Hutton", "https://images.unsplash.com/photo-1444080748397-f442aa95c3e5?q=80&w=1632&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");
        galeria.add(item04);
        Item item05 = new Item("Bailey Zindel", "https://images.unsplash.com/photo-1506744038136-46273834b3fb?q=80&w=1470&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");
        galeria.add(item05);
        Item item06 = new Item("Joanna Kozik", "https://images.unsplash.com/photo-1613182196407-ef5d548c23ba?q=80&w=1374&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");
        galeria.add(item06);
        Item item07 = new Item("Robert Lukeman", "https://images.unsplash.com/photo-1472213984618-c79aaec7fef0?q=80&w=1455&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");
        galeria.add(item07);
        Item item08 = new Item("Luca Micheli", "https://images.unsplash.com/photo-1518098268026-4e89f1a2cd8e?q=80&w=1374&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");
        galeria.add(item08);
        Item item09 = new Item("Cristina Gottardi", "https://images.unsplash.com/photo-1484383707950-89c8d3276e53?q=80&w=1629&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");
        galeria.add(item09);
        Item item10 = new Item("Sergey Pesterev", "https://images.unsplash.com/photo-1490791539531-102a1e0beb7b?q=80&w=1470&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");
        galeria.add(item10);

        return galeria;
    }

    @Override
    public void sendItem(Item item) {
        Bundle bundle = new Bundle();
        bundle.putString("descripcion", item.getDescripcion());
        bundle.putString("url", item.getUrl());
        Navigation.findNavController(binding.getRoot()).navigate(R.id.action_FirstFragment_to_SecondFragment, bundle);
    }
}

