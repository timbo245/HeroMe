package com.magtecconsulting.timothylott.herome.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.magtecconsulting.timothylott.herome.Activities.MainActivity;
import com.magtecconsulting.timothylott.herome.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PickPowerFragment.PickPowerInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PickPowerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PickPowerFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button turtleBtn;
    private Button lightningBtn;
    private Button flightBtn;
    private Button webBtn;
    private Button laserBtn;
    private Button superBtn;
    private Button backstoryBtn;

    private PickPowerInteractionListener mListener;

    public PickPowerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PickPowerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PickPowerFragment newInstance(String param1, String param2) {
        PickPowerFragment fragment = new PickPowerFragment();
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
        View view = inflater.inflate(R.layout.fragment_pick_power, container, false);

        turtleBtn = (Button)view.findViewById(R.id.turtleBtn);
        lightningBtn = (Button)view.findViewById(R.id.lightingBtn);
        flightBtn = (Button)view.findViewById(R.id.flightBtn);
        webBtn = (Button)view.findViewById(R.id.webBtn);
        laserBtn = (Button)view.findViewById(R.id.laserBtn);
        superBtn = (Button)view.findViewById(R.id.superBtn);
        backstoryBtn = (Button)view.findViewById(R.id.backstoryBtn);

        turtleBtn.setOnClickListener(this);
        lightningBtn.setOnClickListener(this);
        flightBtn.setOnClickListener(this);
        webBtn.setOnClickListener(this);
        laserBtn.setOnClickListener(this);
        superBtn.setOnClickListener(this);

        backstoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity = (MainActivity)getActivity();
                mainActivity.loadBackstoryScreen();
            }
        });

        backstoryBtn.setEnabled(false);
        backstoryBtn.getBackground().setAlpha(128);



        return view;
    }

    @Override
    public void onClick(View v) {
        backstoryBtn.setEnabled(true);
        backstoryBtn.getBackground().setAlpha(255);

        turtleBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.turtlepower_icon,0,0,0);
        lightningBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.lightning_icon,0,0,0);
        flightBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.rocket_icon,0,0,0);
        webBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.spiderweb_icon,0,0,0);
        laserBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.laservision_icon,0,0,0);
        superBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.superstrength_icon,0,0,0);

        Button powersBtn = (Button)v;
        int powersLeftDrawable = 0;

        if (powersBtn == turtleBtn) {
            powersLeftDrawable = R.drawable.turtlepower_icon;
        } else if (powersBtn == lightningBtn) {
            powersLeftDrawable = R.drawable.lightning_icon;
        } else if (powersBtn == flightBtn) {
            powersLeftDrawable = R.drawable.rocket_icon;
        } else if (powersBtn == webBtn) {
            powersLeftDrawable = R.drawable.spiderweb_icon;
        } else if (powersBtn == laserBtn) {
            powersLeftDrawable = R.drawable.laservision_icon;
        } else if (powersBtn == superBtn) {
            powersLeftDrawable = R.drawable.superstrength_icon;
        }

        powersBtn.setCompoundDrawablesWithIntrinsicBounds(powersLeftDrawable,0,R.drawable.item_selected_btn,0);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onPickPowerFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PickPowerInteractionListener) {
            mListener = (PickPowerInteractionListener) context;
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
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface PickPowerInteractionListener
    {
        // TODO: Update argument type and name
        void onPickPowerFragmentInteraction(Uri uri);
    }
}
