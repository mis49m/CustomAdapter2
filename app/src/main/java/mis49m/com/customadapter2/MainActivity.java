package mis49m.com.customadapter2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button btn;

    ArrayList<SocialNetwork> socialNetworks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        btn = (Button) findViewById(R.id.btn);

        initialize();

        RecyclerView.LayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recyclerView.setHasFixedSize(true);

        MyAdapter adapter = new MyAdapter(socialNetworks);
        recyclerView.setAdapter(adapter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (SocialNetwork socialNetwork : socialNetworks) {
                    if (socialNetwork.isChecked()) {
                        Toast.makeText(getBaseContext(), socialNetwork.getName(), Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    private void initialize() {
        socialNetworks=new ArrayList<SocialNetwork>();
        socialNetworks.add(new SocialNetwork("Facebook", R.drawable.facebook, false));
        socialNetworks.add(new SocialNetwork("Google+", R.drawable.googlep, false));
        socialNetworks.add(new SocialNetwork("Twitter", R.drawable.twitter, false));
        socialNetworks.add(new SocialNetwork("Linkedin", R.drawable.linkedin, false));
    }
}
