package com.example.bottomnavigation.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bottomnavigation.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ResistenciaFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ResistenciaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ResistenciaFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private Spinner valor1,valor2,valor3,valor4,valor5,valor6,valor7,valor8,valor9;

    Button Calcular;
    TextView Resultado;
    LinearLayout linearLayout, linearLayout2;
    Switch aSwitch;
    ImageView res4,res5;
    private int color1=0;
    private int color2=0;
    private double color3 = 0;
    private String color4s = "";
    private int color5=0;
    private int color6 = 0;
    private int color7 = 0;
    private double color8 = 0;
    private String color9s = "";
    public ResistenciaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ResistenciaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ResistenciaFragment newInstance(String param1, String param2) {
        ResistenciaFragment fragment = new ResistenciaFragment();
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
        View vista =  inflater.inflate(R.layout.fragment_resistencia, container, false);

        valor1 = vista.findViewById(R.id.spinner1);
        valor2 = vista.findViewById(R.id.spinner2);
        valor3 = vista.findViewById(R.id.spinner3);
        valor4 = vista.findViewById(R.id.spinner4);
        valor5 = vista.findViewById(R.id.spinner5);
        valor6 = vista.findViewById(R.id.spinner6);
        valor7 = vista.findViewById(R.id.spinner7);
        valor8 = vista.findViewById(R.id.spinner8);
        valor9 = vista.findViewById(R.id.spinner9);

        Calcular = vista.findViewById(R.id.calcular);

        Resultado = vista.findViewById(R.id.res_Resultado);

        linearLayout = vista.findViewById(R.id.linear);
        linearLayout2 = vista.findViewById(R.id.linear2);

        aSwitch = vista.findViewById(R.id.id_switch);

        res4 = vista.findViewById(R.id.id_res4);
        res5 = vista.findViewById(R.id.id_res5);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.valores4,android.R.layout.simple_spinner_item);


        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getContext(),
                R.array.valor4,android.R.layout.simple_spinner_item);


        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(getContext(),
                R.array.tolerancia,android.R.layout.simple_spinner_item);

        valor1.setAdapter(adapter);
        valor2.setAdapter(adapter);
        valor3.setAdapter(adapter2);
        valor4.setAdapter(adapter3);

        valor5.setAdapter(adapter);
        valor6.setAdapter(adapter);
        valor7.setAdapter(adapter);
        valor8.setAdapter(adapter2);
        valor9.setAdapter(adapter3);


        aSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(aSwitch.isChecked()){
                    linearLayout.setVisibility(View.GONE);
                    linearLayout2.setVisibility(View.VISIBLE);

                    res4.setVisibility(View.GONE);
                    res5.setVisibility(View.VISIBLE);
                    Toast.makeText(getContext(), "5 Bandas Activado", Toast.LENGTH_SHORT).show();
                }

                else{
                    linearLayout.setVisibility(View.VISIBLE);
                    linearLayout2.setVisibility(View.GONE);

                    res5.setVisibility(View.GONE);
                    res4.setVisibility(View.VISIBLE);
                    Toast.makeText(getContext(), "4 Bandas Activado", Toast.LENGTH_SHORT).show();
                }

            }
        });

        opcionesspinner();

        Calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(linearLayout.getVisibility()==v.VISIBLE){

                    double Resultadores = (color1+color2)*color3;
                    Resultado.setText("El resultado es: "+Resultadores+"Ω±"+ color4s);
                }
                else{
                    double Resultadores = (color5+color6+color7)*color8;
                    Resultado.setText("El resultado es: "+Resultadores+"Ω±"+ color9s);
                }

            }
        });

        return vista;
    }

    private void opcionesspinner() {

        valor1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String color = parent.getItemAtPosition(position).toString();
                Toast.makeText(getContext(), "Seleccionado: "+ color, Toast.LENGTH_SHORT).show();

                switch (color){

                    case "Negro":
                        color1 = 0;
                        break;

                    case "Cafe":
                        color1 = 10;
                        break;

                    case "Rojo":
                        color1 = 20;
                        break;

                    case "Naranja":
                        color1 = 30;
                        break;

                    case "Amarillo":
                        color1 = 40;
                        break;

                    case "Verde":
                        color1 = 50;
                        break;

                    case "Azul":
                        color1 = 60;
                        break;

                    case "Morado":
                        color1 = 70;

                    case "Gris":
                        color1 = 80;
                        break;

                    case "Blanco":
                        color1 = 90;
                        break;


                    default:
                        break;

                }

                Toast.makeText(getContext(),"valor: "+ color1, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        valor2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String color = parent.getItemAtPosition(position).toString();
                Toast.makeText(getContext(), "Seleccionado: "+ color
                        , Toast.LENGTH_SHORT).show();

                switch (color){

                    case "Negro":
                        color2 = 0;
                        break;

                    case "Cafe":
                        color2 = 1;
                        break;

                    case "Rojo":
                        color2 = 2;
                        break;

                    case "Naranja":
                        color2 = 3;
                        break;

                    case "Amarillo":
                        color2 = 4;
                        break;

                    case "Verde":
                        color2 = 5;
                        break;

                    case "Azul":
                        color2 = 6;
                        break;

                    case "Morado":
                        color2 = 7;

                    case "Gris":
                        color2 = 8;
                        break;

                    case "Blanco":
                        color2 = 9;
                        break;

                    default:
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        valor3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String color = parent.getItemAtPosition(position).toString();
                Toast.makeText(getContext(), "Seleccionado: "+ color
                        , Toast.LENGTH_SHORT).show();

                switch (color){

                    case "Negro":
                        color3 = 1;
                        break;

                    case "Cafe":
                        color3 = 10;
                        break;

                    case "Rojo":
                        color3 = 100;
                        break;

                    case "Naranja":
                        color3 = 1000;
                        break;

                    case "Amarillo":
                        color3 = 10000;
                        break;

                    case "Verde":
                        color3 = 100000;
                        break;

                    case "Azul":
                        color3 = 1000000;
                        break;

                    case "Dorado":
                        color3 =  0.1;
                        break;

                    case "Plateado":
                         color3 = 0.01;
                        break;

                    default:
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        valor4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String color = parent.getItemAtPosition(position).toString();
                Toast.makeText(getContext(), "Seleccionado: "+ color
                        , Toast.LENGTH_SHORT).show();

                switch (color){

                    case "Cafe":
                        color4s = "1%";
                        break;

                    case "Rojo":
                        color4s = "2%";
                        break;


                    case "Dorado":
                        color4s = "5%";
                        break;

                    case "Plateado":
                        color4s = "10%";
                        break;

                    default:
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        valor5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String color = parent.getItemAtPosition(position).toString();
                Toast.makeText(getContext(), "Seleccionado: "+ color, Toast.LENGTH_SHORT).show();

                switch (color){

                    case "Negro":
                        color5 = 0;
                        break;

                    case "Cafe":
                        color5 = 100;
                        break;

                    case "Rojo":
                        color5 = 200;
                        break;

                    case "Naranja":
                        color5 = 300;
                        break;

                    case "Amarillo":
                        color5 = 400;
                        break;

                    case "Verde":
                        color5 = 500;
                        break;

                    case "Azul":
                        color5 = 600;
                        break;

                    case "Morado":
                        color5 = 700;

                    case "Gris":
                        color5 = 800;
                        break;

                    case "Blanco":
                        color5 = 900;
                        break;

                    default:
                        break;

                }

                Toast.makeText(getContext(),"valor: "+ color1, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        valor6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String color = parent.getItemAtPosition(position).toString();
                Toast.makeText(getContext(), "Seleccionado: "+ color, Toast.LENGTH_SHORT).show();

                switch (color){

                    case "Negro":
                        color6 = 0;
                        break;

                    case "Cafe":
                        color6 = 10;
                        break;

                    case "Rojo":
                        color6 = 20;
                        break;

                    case "Naranja":
                        color6 = 30;
                        break;

                    case "Amarillo":
                        color6 = 40;
                        break;

                    case "Verde":
                        color6 = 50;
                        break;

                    case "Azul":
                        color6 = 60;
                        break;

                    case "Morado":
                        color6 = 70;

                    case "Gris":
                        color6 = 80;
                        break;

                    case "Blanco":
                        color6 = 90;
                        break;

                    default:
                        break;

                }

                Toast.makeText(getContext(),"valor: "+ color1, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        valor7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String color = parent.getItemAtPosition(position).toString();
                Toast.makeText(getContext(), "Seleccionado: "+ color, Toast.LENGTH_SHORT).show();

                switch (color){

                    case "Negro":
                        color7 = 0;
                        break;

                    case "Cafe":
                        color7 = 1;
                        break;

                    case "Rojo":
                        color7 = 2;
                        break;

                    case "Naranja":
                        color7 = 3;
                        break;

                    case "Amarillo":
                        color7 = 4;
                        break;

                    case "Verde":
                        color7 = 5;
                        break;

                    case "Azul":
                        color7 = 6;
                        break;

                    case "Morado":
                        color7 = 7;

                    case "Gris":
                        color7 = 8;
                        break;

                    case "Blanco":
                        color7 = 9;
                        break;

                    default:
                        break;

                }

                Toast.makeText(getContext(),"valor: "+ color1, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        valor8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String color = parent.getItemAtPosition(position).toString();
                Toast.makeText(getContext(), "Seleccionado: "+ color
                        , Toast.LENGTH_SHORT).show();

                switch (color){

                    case "Negro":
                        color8 = 1;
                        break;

                    case "Cafe":
                        color8 = 10;
                        break;

                    case "Rojo":
                        color8 = 100;
                        break;

                    case "Naranja":
                        color8 = 1000;
                        break;

                    case "Amarillo":
                        color8 = 10000;
                        break;

                    case "Verde":
                        color8 = 100000;
                        break;

                    case "Azul":
                        color8 = 1000000;
                        break;

                    case "Dorado":
                        color8 = 0.1;
                        break;

                    case "Plateado":
                        color8 = 0.01;
                        break;

                    default:
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        valor9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String color = parent.getItemAtPosition(position).toString();
                Toast.makeText(getContext(), "Seleccionado: "+ color
                        , Toast.LENGTH_SHORT).show();

                switch (color){

                    case "Cafe":
                        color9s = "1%";
                        break;

                    case "Rojo":
                        color9s = "2%";
                        break;


                    case "Dorado":
                        color9s = "5%";
                        break;

                    case "Plateado":
                        color9s = "10%";
                        break;

                    default:
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

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
