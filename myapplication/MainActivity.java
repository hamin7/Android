package com.example.hamin.myapplication;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerView;
    FriendRecyclerAdapter adapter;
    LinearLayoutManager manager;
    // List manager 필요 - 방향이랑 설정

    // Main - adapter - manager

    Retrofit retrofit;
    ProfileService service;
    String SERVER_URL = "monotype.tk";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.retrofit = new Retrofit.Builder()
                .baseUrl(SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        this.service = this.retrofit.create(ProfileService.class);

        final Call<FriendDTO> call = this.service.getProfileList();


        recyclerView = new RecyclerView(this);

        recyclerView= (RecyclerView) findViewById(R.id.recycler);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe);

        adapter = new FriendRecyclerAdapter(Glide.with(this));
        manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);

        //FriendDTO dto = new FriendDTO(R.drawable.newt,"newt","is newt");

        //adapter.addItem(dto);

        // recyclerView는 마무리 되었음.

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //FriendDTO dto = new FriendDTO(R.drawable.newttwo,"newt's two","newt's two");
                //adapter.addItem(dto);
                //swipeRefreshLayout.setRefreshing(false);     // 이제 도는거 그만

                //HTTP GET method를 retrofit으로 서버에 보내고 응답을 받아서
                //처리해서 adapter 안에 집어넣고 마무리
                call.enqueue(new Callback<FriendDTO>() {
                    @Override
                    public void onResponse(Call <FriendDTO> call, Response<FriendDTO> response){
                        adapter.addItem(response.body());
                        swipeRefreshLayout.setRefreshing(false);
                    }

                    @Override  // call이 안될 때, client에서 실패했을 때
                    public void onFailure(Call<FriendDTO> call, Throwable t){

                    }
                });    // 비동기 방식
            }
        });
    }
}

// 1122
// REST API
// Lgin - PUT

// Network는 자손 thread 사용 --> library - Retrofit2, OKhttp를 사용

// GET 해서 돌아오는 response는 json(key - value) { "key" : "value", }
// img는 address 태워서 보냄
// error 여러개 오면 [] array로 묶음, 일반적으로 []로 묶어서 보냄

// ?는 url이 끝났다
// & 추가정보
// URL에 정보가 들어있다 - REST(싱태가 특성을 설명한다)
// maps, place, routing.