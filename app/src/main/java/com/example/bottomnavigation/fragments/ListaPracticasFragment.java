package com.example.bottomnavigation.fragments;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.bottomnavigation.R;
import com.example.bottomnavigation.adaptadores.AdaptadorPracticas;
import com.example.bottomnavigation.entidades.Practicasvo;
import com.example.bottomnavigation.interfaces.IComunicaFragments;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListaPracticasFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListaPracticasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListaPracticasFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    ArrayList<Practicasvo> listaPractica;
    RecyclerView recyclerPracticas;

    IComunicaFragments interfaceComunicaFragments;
    Activity activity;


    public ListaPracticasFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListaPracticasFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListaPracticasFragment newInstance(String param1, String param2) {
        ListaPracticasFragment fragment = new ListaPracticasFragment();
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


        final View vista = inflater.inflate(R.layout.fragment_lista_practicas, container, false);

        listaPractica = new ArrayList<>();
        recyclerPracticas = vista.findViewById(R.id.recyclerId);
        recyclerPracticas.setLayoutManager(new LinearLayoutManager(getContext())); //Se le pone getcontext porque estan en un fragment

        llenarListaPracticas();
        AdaptadorPracticas adapter = new AdaptadorPracticas(listaPractica);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Selecciona"+listaPractica.get
                        (recyclerPracticas.getChildAdapterPosition(v)).getNombrePR(), Toast.LENGTH_SHORT).show();
                interfaceComunicaFragments.enviarPractica
                        (listaPractica.get(recyclerPracticas.getChildAdapterPosition(v)));

            }
        });
        // Inflate the layout for this fragment

        recyclerPracticas.setAdapter(adapter);

        return vista;
    }

    private void llenarListaPracticas() {
        listaPractica.add(new Practicasvo(getString(R.string.primerapractica_nombre),getString(R.string.primerapractica_descripcion),getString(R.string.primerapractica_info),getString(R.string.Primerapractica_Code), R.drawable.led_foto,R.drawable.led_descripcion));
        listaPractica.add(new Practicasvo(getString(R.string.Segundapractica_nombre),getString(R.string.Segundapractica_descripcion),getString(R.string.Segundapractica_info), getString(R.string.Segundapractica_Code),R.drawable.buzzer_foto,R.drawable.buzzer_descripcion));
        listaPractica.add(new Practicasvo(getString(R.string.TerceraPractica_nombre),getString(R.string.TerceraPractica_descripcion),getString(R.string.TerceraPractica_info),getString(R.string.Tercerapractica_code), R.drawable.secuencialed_foto,R.drawable.secuencialed_descripcion));
        listaPractica.add(new Practicasvo(getString(R.string.CuartapPractica_nombre),getString(R.string.CuartapPractica_descripcion),getString(R.string.CuartapPractica_info),getString(R.string.Primerapractica_Code), R.drawable.antirebote_foto,R.drawable.antirebote_descripcion));
        listaPractica.add(new Practicasvo(getString(R.string.QuintaPractica_nombre),getString(R.string.QuintaPractica_descripcion),getString(R.string.QuintaPractica_info),getString(R.string.Primerapractica_Code), R.drawable.sietesegmentos_foto,R.drawable.sietesegmentos_descripcion));
        listaPractica.add(new Practicasvo(getString(R.string.SextaPractica_nombre),getString(R.string.SextaPractica_descripcion),getString(R.string.SextaPractica_info), getString(R.string.Primerapractica_Code),R.drawable.lcd_foto,R.drawable.lcd_descripcion));
        listaPractica.add(new Practicasvo(getString(R.string.SeptimaPractica_nombre),getString(R.string.SeptimaPractica_descripcion),getString(R.string.SeptimaPractica_info),getString(R.string.Primerapractica_Code), R.drawable.teclado_foto,R.drawable.teclado_descripcion));
        listaPractica.add(new Practicasvo(getString(R.string.OctavaPractica_nombre),getString(R.string.OctavaPractica_descripcion),getString(R.string.OctavaPractica_info),getString(R.string.Primerapractica_Code), R.drawable.lm35_foto,R.drawable.lm35_descripcion));
        listaPractica.add(new Practicasvo(getString(R.string.NovenaPractica_nombre),getString(R.string.NovenaPractica_descripcion),getString(R.string.NovenaPractica_info),getString(R.string.Primerapractica_Code), R.drawable.voltimetro1_foto,R.drawable.voltimetro_descripcion));
        listaPractica.add(new Practicasvo(getString(R.string.DecimaPractica_nombre),getString(R.string.DecimaPractica_descripcion),getString(R.string.DecimaPractica_info),getString(R.string.Primerapractica_Code), R.drawable.motor_foto,R.drawable.motor_descripcion));
        listaPractica.add(new Practicasvo(getString(R.string.DecimaPrimeraPractica_nombre),getString(R.string.DecimaPrimeraPractica_descripcion),getString(R.string.DecimaPrimeraPractica_info),getString(R.string.Primerapractica_Code), R.drawable.rgb_foto,R.drawable.rgb_descripcion));
        listaPractica.add(new Practicasvo(getString(R.string.DecimaSegundaPractica_nombre),getString(R.string.DecimaSegundaPractica_descripcion),getString(R.string.DecimaSegundaPractica_info),getString(R.string.Primerapractica_Code), R.drawable.pir_png,R.drawable.pir_descripcion));
        listaPractica.add(new Practicasvo(getString(R.string.DecimaTerceraPractica_nombre),getString(R.string.DecimaTerceraPractica_descripcion),getString(R.string.DecimaTerceraPractica_info),getString(R.string.Primerapractica_Code), R.drawable.blu_foto,R.drawable.blue_descripcion));
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
        mListener.onFragmentInteraction(uri);        }

}

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

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
