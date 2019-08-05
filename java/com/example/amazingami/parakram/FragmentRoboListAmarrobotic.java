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

public class FragmentRoboListAmarrobotic extends Fragment {
    String[] web = {
            "KON TRIVENCE",
            "KICK - O - BOT",
            "SOI - COURIER"
    } ;

    String[] details = {
            "An unknown enemy has launched a sudden attack on your fortress. As the fortress last defense you are to defend the fortress and rescue the injured. You are provided with a vehicle (bot) and your aim is rescue the injured from the battlefield (arena) and then launch an attack to win over your enemy.\n" +
                    "\n" +
                    "TEAM OF 5 (Max.)\n" +
                    "Exciting prizes to be won\n" +
                    "\n" +
                    "**The registration amount for Soi-Courier, Kick-o-bot and Kon Trivence combined is 500/-\n" +
                    "\n" +
                    "** THE PRIZE MONEY OF ALL THE THREE EVENTS OF ROBOTICS IS 25000/-\n",

            "It is a manual operated bot event. The bot is required to show off soccers skills. A group will consist of two teams with one acting as an attacker and the other as defender.\n" +
                    "\n" +
                    "TEAM OF 5 (Max.)\n" +
                    "Exciting prizes to be won\n" +
                    "\n" +
                    "**The registration amount for Soi-Courier, Kick-o-bot and Kon Trivence combined is 500/-\n" +
                    "\n" +
                    "** THE PRIZE MONEY OF ALL THE THREE EVENTS OF ROBOTICS IS 25000/-\n",

            "Autonomous bot event. It will be a 2 round event\n" +
                    "\n" +
                    "TEAM OF 5 (Max.)\n" +
                    "Exciting prizes to be won\n" +
                    "\n" +
                    "**The registration amount for Soi-Courier, Kick-o-bot and Kon Trivence combined is 500/-\n" +
                    "\n" +
                    "** THE PRIZE MONEY OF ALL THE THREE EVENTS OF ROBOTICS IS 25000/-\n"

           } ;

    int[] imageId = {
            R.drawable.konroboimg,
            R.drawable.kickroboimg,
            R.drawable.suiroboimg

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
