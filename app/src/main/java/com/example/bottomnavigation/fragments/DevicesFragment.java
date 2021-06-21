package com.example.bottomnavigation.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.bottomnavigation.R;
import com.example.bottomnavigation.adaptadores.AdaptadorDevices;
import com.example.bottomnavigation.adaptadores.AdaptadorPracticas;
import com.example.bottomnavigation.entidades.Devicesvo;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DevicesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DevicesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DevicesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    ArrayList<Devicesvo> listaDevices;
    RecyclerView recyclerDevices;

    Comunicador comunicador;
    public interface Comunicador{
        public void enviarS(String dispositivo);
    }

    public DevicesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DevicesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DevicesFragment newInstance(String param1, String param2) {
        DevicesFragment fragment = new DevicesFragment();
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
        // Inflate the layout for this fragment
        final View vista = inflater.inflate(R.layout.fragment_devices, container, false);

        listaDevices = new ArrayList<>();
        recyclerDevices = vista.findViewById(R.id.devicerecyclerId);
        //recyclerDevices.setLayoutManager(new LinearLayoutManager(getContext())); //Se le pone getcontext porque estan en un fragment
        recyclerDevices.setLayoutManager(new GridLayoutManager(getContext(),2));
        llenarListaDevices();
        AdaptadorDevices adapter = new AdaptadorDevices(listaDevices);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = listaDevices.get(recyclerDevices.getChildAdapterPosition(v)).getNombreDevice();
                Toast.makeText(getContext(), "Selecciona"+nombre, Toast.LENGTH_SHORT).show();
                comunicador.enviarS(nombre);

            }
        });
        // Inflate the layout for this fragment

        recyclerDevices.setAdapter(adapter);

        return vista;    }

    private void llenarListaDevices() {
        listaDevices.add(new Devicesvo("PIC18F4620",R.drawable.micro));
        listaDevices.add(new Devicesvo("Diodo Emisor de Luz (LED)",R.drawable.led_foto));
        listaDevices.add(new Devicesvo("Buzzer",R.drawable.buzzer_foto));
        listaDevices.add(new Devicesvo("Boton",R.drawable.antirebote_foto));
        listaDevices.add(new Devicesvo("Display 7 segmentos", R.drawable.sietesegmentos_foto));
        listaDevices.add(new Devicesvo("Lcd 16x2",R.drawable.lcd_foto));
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

        comunicador = (Comunicador) context;


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
