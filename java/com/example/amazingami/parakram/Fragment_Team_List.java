package com.example.amazingami.parakram;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class Fragment_Team_List extends Fragment {
    Fragment fragment;
    ListView list;
LinearLayout lltlist;


    Activity af;
    ArrayList<HashMap<String,String>> listf;
    int layouf;
    String[] web = {
            "Manish Sachan(Coordi.)",
            "Shikha Tiwari(Coordi.)",
            "Shubham Jain(Gen.Sec.)",
            "Neelanshu(Treasurer)",
            "O P Dubey(Sponsorship)",
            "Divyank Tiwari(Promotion)",
            "Amar Malik(Technical)",
            "Satyam(Hospitality)",
            "Shailesh(Hospitality)",
            "Deepak Verma(Registration)",
            "Arti Jaiswal(Registration)",
            "Vikas Dwivedi(Public Relation)",
            "Akash Verma(Alumni Contact)",
            "Nishant(Printing)",
            "Akhil(Program Coord.)",
            "Hikmat beig(Workshop)"


    } ;
    String[] mobile = {
            "8005183594",
            "",
            "8192831321",
            "8193910259",
            "8604563825",
            "9838170507",
            "8052425430",
            "7505570802",
            "7007791116",
            "9452747919",
            "",
            "9910210130",
            "8354849435",
            "8077373397",
            "9536379181",
            ""

    } ;
    Integer[] imageId = {
            R.drawable.manical,
            R.drawable.shikcal,
            R.drawable.subhcal,
            R.drawable.nilanshucal,
            R.drawable.opdcal,
            R.drawable.divyacal,
            R.drawable.amarimg,
            R.drawable.satcal,
            R.drawable.shaical,
            R.drawable.deepakcal,
            R.drawable.aarucal,
            R.drawable.vikcal,
            R.drawable.akacal,
            R.drawable.person,
            R.drawable.akhical,
            R.drawable.person
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vi = inflater.inflate(R.layout.fragment_team, container, false);
        lltlist = (LinearLayout) vi.findViewById(R.id.lltlist);
        Adapter_TeamList adapter = new
                Adapter_TeamList(getActivity(), web, imageId);
        list = (ListView) vi.findViewById(R.id.list_team);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                alertusercallmessage(mobile[position],imageId[position],getActivity());
            }
        });
        return vi;

    }


    private void changeFragment(Fragment targetFragment){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);

        Fragment newCustomFragment = targetFragment;
        transaction.replace(R.id.main_fragment, newCustomFragment );
        transaction.addToBackStack(null);

        transaction.commit();
    }

    public  void alertusercallmessage(final String mobilenumber,final int image,Activity act)
    {

        final Dialog dialog = new Dialog(act);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        dialog.setContentView(R.layout.fragment_callpop);
        Button btnsms = (Button) dialog.findViewById(R.id.btnsms);
        Button btncalll = (Button) dialog.findViewById(R.id.btncalll);
        ImageView ibtn_robo=(ImageView)dialog.findViewById(R.id.ibtn_robo);
        ibtn_robo.setBackgroundResource(image);
        btncalll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: "+mobilenumber));
                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                    return;
                }
                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                    return;
                }
                startActivity(callIntent);
            }
        });


        btnsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                    smsIntent.setType("vnd.android-dir/mms-sms");
                    smsIntent.putExtra("address",mobilenumber);
                    smsIntent.putExtra("sms_body","");

                    startActivity(smsIntent);
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getActivity(), "Messaging Not Supported",
                            Toast.LENGTH_LONG).show();
                }
            }
        });


        dialog.show();
    }

}