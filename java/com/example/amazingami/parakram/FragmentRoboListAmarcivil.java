package com.example.amazingami.parakram;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class FragmentRoboListAmarcivil extends Fragment {
    String[] web = {
            "UNDERWATER PROJECT",
            "BRIDGE BUILDING AND DESIGNING",
            "MACROCOSM",
            "PICTURESQUE",
            "FINAL YEAR SLOT"

    } ;

    String[] details = {
            "You are the Senior Structural Engineering of company. You have got a project for designing an underwater resort. (In AUTOCAD/STAAD PRO/REAL 3D MODEL/POWERPOINT)\n" +
                    "\n" +
                    "TEAM OF 5 (Max.)\n" +
                    "Registration Amount- 50/- per team\n" +
                    "Prize Money- 600/-\n",

            "Build a structure as you wish from the material given to you, where your imagination is the only restriction. The bet models will be awarded.\n" +
                    "\n" +
                    "TEAM OF 5(Max..)\n" +
                    "Registration Amount- 80/- per team\n" +
                    "Prize Money- 800/- + goodies\n",

            "A short quiz event on space and celestial bodies. Universe exploration through questionaire.\n" +
                    "\n" +
                    "TEAM OF 2\n" +
                    "Registration Amount- 20/- per team\n" +
                    "Prize Money- 600/\n",

            "A special treat for all photography enthusiasts! Participate in the competition and let your imagination speak for itself!\n" +
                    "Mail your photograph on the theme “SAFETY FIRST” that portrays the risks and hazards of construction workers to parakram2k17ietlko@gmail.com .\n" +
                    "\n" +
                    "Prize Money- goodies ",

            "Get a chance to interact directly with the seniors qualified in GATE/CAT\n"


    } ;

    int[] imageId = {
            R.drawable.civilwaterimg,
            R.drawable.civil2img,
            R.drawable.civilimg,
            R.drawable.civil1img,
            R.drawable.gatecivilimg


    };
ListView Lstamar;
    Fragment fragment;

    ArrayList<HashMap<String,String>>arrayList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View vi= inflater.inflate(R.layout.fragment_robo_list, parent, false);
arrayList=new ArrayList<HashMap<String, String>>();
        arrayList=getArraydata();

        Lstamar=(ListView)vi.findViewById(R.id.lst_robo);
        AdapterRoboListShiv adshiv=new AdapterRoboListShiv(getActivity(),arrayList,R.layout.row_robo_list,imageId);
        Lstamar.setAdapter(adshiv);

        Lstamar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

HashMap<String,String>map=arrayList.get(position);
             Helper.selectedtitle=   map.get("title");
                Helper.selecteddetails=map.get("details");
                Helper.selectedimage=imageId[position];

                Intent i=new Intent(getActivity(),ActivityRoboDetails.class);
                startActivity(i);
            }
        });
        return  vi;
    }



public ArrayList<HashMap<String,String>> getArraydata()
{
ArrayList<HashMap<String,String>>resultist=new ArrayList<HashMap<String, String>>();
    for(int i=0;i<web.length;i++)
    {
        HashMap<String,String>map=new HashMap<String,String>();
        map.put("title",web[i]);
        map.put("details",details[i]);
       resultist.add(map);
    }

return  resultist;
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


}
