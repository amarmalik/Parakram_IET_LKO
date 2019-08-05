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

public class FragmentRoboListAmarelex extends Fragment {
    String[] web = {
            "CIRCUITRIX",
            "QUIZ O MANIA",
            "TECH PAPER PRESENTATION"

    } ;

    String[] details = {
            "A two round contest. Round 1 is a basic quiz related to electronics. Round 2 will be a team event which will require one to have knowledge about implementation of logic using gates on breadboard.\n" +
                    "\n" +
                    "INDIVIDUAL EVENT\n" +
                    "Registration Amount- 20/- per person\n" +
                    "Prize Money- 600/-\n",

            "A three round quiz event. Virtual money will be given to every individual which will help them to survive in further round.\n" +
                    "\n" +
                    "INDIVIDUAL EVENT\n" +
                    "Registration Amount- 20/- per person\n" +
                    "Prize Money- 600/-\n",

            "Motive of the event is to make students understand the importance of presentation and it will surely help them to enhance our soft skill. Presentation format : IJARIIT The topic is open to all subjects.\n" +
                    "\n" +
                    "TEAM OF 4\n" +
                    "Registration Amount- Free\n" +
                    "Prize Money- goodies\n"
    } ;

    int[] imageId = {
            R.drawable.cireleximg,
            R.drawable.techquizimg,
            R.drawable.eleximg

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
