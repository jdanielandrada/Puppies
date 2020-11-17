package com.example.puppies2.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.puppies2.R;
import com.example.puppies2.adaptadores.AdaptadorPerros;
import com.example.puppies2.entidades.PerroVo;
import com.example.puppies2.interfaces.IComunicaFragments;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListaPerrosFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListaPerrosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListaPerrosFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    private OnFragmentInteractionListener mListener;
    View vista;
    Button botonDonar;

    ArrayList <PerroVo> listaPerros;
    RecyclerView recyclerPerros;

    Activity activity;
    IComunicaFragments interfaceComunicaFragments;

    public ListaPerrosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListaPerrosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListaPerrosFragment newInstance(String param1, String param2) {
        ListaPerrosFragment fragment = new ListaPerrosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        vista = inflater.inflate(R.layout.fragment_lista_perros, container, false);

        listaPerros = new ArrayList<>();
        recyclerPerros = vista.findViewById(R.id.recyclerId);
        //recyclerPerros.setLayoutManager(new LinearLayoutManager(getContext())); //EN FILA
        recyclerPerros.setLayoutManager(new GridLayoutManager(getContext(),3)); //EN COLUMNA

        llenarListaPerros();

        AdaptadorPerros adapter = new AdaptadorPerros(listaPerros);
        recyclerPerros.setAdapter(adapter);


        //METODO ON CLICK
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(),"Selección: "+listaPerros.get(recyclerPerros.getChildAdapterPosition(view)).getImagenId(),Toast.LENGTH_SHORT).show(); //MANDO EL NOMBRE
                interfaceComunicaFragments.enviarPerro(listaPerros.get(recyclerPerros.getChildAdapterPosition(view))); //MANDO EL OBJETO COMPLETO
            }
        });

        //BOTON DONAR
        botonDonar = vista.findViewById(R.id.boton_donar);
        botonDonar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                interfaceComunicaFragments.iniciarDonar();
            }
        });

        return vista;
    }

    //LENAR LISTA DE PERROS
    private void llenarListaPerros() {
        listaPerros.add(new PerroVo("", getString(R.string.perro1_descripcion), R.drawable.perro1, R.drawable.perro1));
        listaPerros.add(new PerroVo("", getString(R.string.perro2_descripcion), R.drawable.perro2, R.drawable.perro2));
        listaPerros.add(new PerroVo("", getString(R.string.perro3_descripcion), R.drawable.perro3, R.drawable.perro3));
        listaPerros.add(new PerroVo("", getString(R.string.perro4_descripcion), R.drawable.perro4, R.drawable.perro4));
        listaPerros.add(new PerroVo("", getString(R.string.perro5_descripcion), R.drawable.perro5, R.drawable.perro5));
        listaPerros.add(new PerroVo("", getString(R.string.perro6_descripcion), R.drawable.perro6, R.drawable.perro6));
        listaPerros.add(new PerroVo("", getString(R.string.perro1_descripcion), R.drawable.perro1, R.drawable.perro1));
        listaPerros.add(new PerroVo("", getString(R.string.perro2_descripcion), R.drawable.perro2, R.drawable.perro2));
        listaPerros.add(new PerroVo("", getString(R.string.perro3_descripcion), R.drawable.perro3, R.drawable.perro3));
        listaPerros.add(new PerroVo("", getString(R.string.perro4_descripcion), R.drawable.perro4, R.drawable.perro4));
        listaPerros.add(new PerroVo("", getString(R.string.perro5_descripcion), R.drawable.perro5, R.drawable.perro5));
        listaPerros.add(new PerroVo("", getString(R.string.perro6_descripcion), R.drawable.perro6, R.drawable.perro6));
        listaPerros.add(new PerroVo("", getString(R.string.perro1_descripcion), R.drawable.perro1, R.drawable.perro1));
        listaPerros.add(new PerroVo("", getString(R.string.perro2_descripcion), R.drawable.perro2, R.drawable.perro2));
        listaPerros.add(new PerroVo("", getString(R.string.perro3_descripcion), R.drawable.perro3, R.drawable.perro3));
        listaPerros.add(new PerroVo("", getString(R.string.perro4_descripcion), R.drawable.perro4, R.drawable.perro4));
        listaPerros.add(new PerroVo("", getString(R.string.perro5_descripcion), R.drawable.perro5, R.drawable.perro5));
        listaPerros.add(new PerroVo("", getString(R.string.perro6_descripcion), R.drawable.perro6, R.drawable.perro6));
        listaPerros.add(new PerroVo("", getString(R.string.perro1_descripcion), R.drawable.perro1, R.drawable.perro1));
        listaPerros.add(new PerroVo("", getString(R.string.perro2_descripcion), R.drawable.perro2, R.drawable.perro2));
        listaPerros.add(new PerroVo("", getString(R.string.perro3_descripcion), R.drawable.perro3, R.drawable.perro3));
        listaPerros.add(new PerroVo("", getString(R.string.perro4_descripcion), R.drawable.perro4, R.drawable.perro4));
        listaPerros.add(new PerroVo("", getString(R.string.perro5_descripcion), R.drawable.perro5, R.drawable.perro5));
        listaPerros.add(new PerroVo("", getString(R.string.perro6_descripcion), R.drawable.perro6, R.drawable.perro6));
        listaPerros.add(new PerroVo("", getString(R.string.perro1_descripcion), R.drawable.perro1, R.drawable.perro1));
        listaPerros.add(new PerroVo("", getString(R.string.perro2_descripcion), R.drawable.perro2, R.drawable.perro2));
        listaPerros.add(new PerroVo("", getString(R.string.perro3_descripcion), R.drawable.perro3, R.drawable.perro3));
        listaPerros.add(new PerroVo("", getString(R.string.perro4_descripcion), R.drawable.perro4, R.drawable.perro4));
        listaPerros.add(new PerroVo("", getString(R.string.perro5_descripcion), R.drawable.perro5, R.drawable.perro5));
        listaPerros.add(new PerroVo("", getString(R.string.perro6_descripcion), R.drawable.perro6, R.drawable.perro6));


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //COMUNICACION ENTRE LA LISTA Y DETALLE
        if(context instanceof Activity){
            this.activity = (Activity) context;
            interfaceComunicaFragments = (IComunicaFragments) this.activity;
        }

        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
