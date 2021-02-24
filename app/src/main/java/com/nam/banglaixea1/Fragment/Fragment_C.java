package com.nam.banglaixea1.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nam.banglaixea1.Adapter.FigureBAdapter;
import com.nam.banglaixea1.Module.Figure;
import com.nam.banglaixea1.R;

import java.util.ArrayList;
import java.util.List;

public class Fragment_C extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private List<Figure> list = new ArrayList<>();
    private FigureBAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_a, container, false);
        recyclerView = view.findViewById(R.id.recycler_a);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        adapter=new FigureBAdapter(list,getContext());
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list.clear();
        list.add(new Figure(R.drawable.c1, "Biển số 301a \" Hướng đi phải theo \"", "các xe chỉ được đi thẳng (trừ xe được quyền ưu tiên theo quy định)"));
        list.add(new Figure(R.drawable.c2, "Biển số 301b \" Hướng đi phải theo \"", "các xe chỉ được rẽ phải (trừ xe được quyền ưu tiên theo quy định). Biển này được đặt ở sau  nơi đường giao nhau."));
        list.add(new Figure(R.drawable.c3, "Biển số 301c \" Hướng đi phải theo \"", "các xe chỉ được rẽ trái (trừ xe được quyền ưu tiên theo quy định). Biển này được đặt ở sau nơi đường giao nhau."));
        list.add(new Figure(R.drawable.c4, "Biển số 301d \" Hướng đi phải theo \"", "các xe chỉ được rẽ phải (trừ xe được quyền ưu tiên theo quy định). Biển này được đặt ở trước nơi đường giao nhau, có tác dụng tại nơi giao nhau đằng sau mặt biển."));
        list.add(new Figure(R.drawable.c5, "Biển số 301e \" Hướng đi phải theo \"", "các xe chỉ được rẽ trái (trừ xe được quyền ưu tiên theo quy định).  Biển này được đặt ở trước nơi đường giao nhau, có tác dụng tại nơi giao nhau đằng sau mặt biển"));
        list.add(new Figure(R.drawable.c6, "Biển số 301f \" Hướng đi phải theo \"", "các xe chỉ được đi thẳng và rẽ phải (trừ xe được quyền ưu tiên theo quy định)"));
        list.add(new Figure(R.drawable.c7, "Biển số 301h \" Hướng đi phải theo \"", "các xe chỉ được đi thẳng và rẽ trái (trừ xe được quyền ưu tiên theo quy định)"));
        list.add(new Figure(R.drawable.c8, "Biển số 301i \" Hướng đi phải theo \"", "các xe chỉ được rẽ phải và rẽ trái (trừ xe được quyền ưu tiên theo quy định)"));
        list.add(new Figure(R.drawable.c9, "Biển số 302a \"Hướng phải đi vòng chướng ngại vật\"", "báo các loại xe (cơ giới và thô sơ) hướng đi vòng sang phải để qua một chướng ngại vật "));
        list.add(new Figure(R.drawable.c10, "Biển số 302b \"Hướng phải đi vòng chướng ngại vật\"", "báo các loại xe (cơ giới và thô sơ) hướng đi vòng sang trái để qua một chướng ngại vật "));
        list.add(new Figure(R.drawable.c11, "Biển số 303 \"Nơi giao nhau chạy theo vòng xuyến\"", "báo cho các loại xe (thô sơ và cơ giới) phải chạy vòng theo đảo an toàn ở nơi đường giao nhau"));
        list.add(new Figure(R.drawable.c12, "Biển số 304 \" Đường dành cho xe thô  sơ\"", "báo đường dành cho xe thô sơ (kể cả xe của người tàn tật) và người đi bộ. Biển bắt buộc các  loại xe thô sơ (kể cả xe của người tàn tật) và người đi bộ phải dùng đường dành riêng này để đi và cấm các xe cơ giới kể cả xe gắn máy, các xe được ưu tiên theo quy định đi vào đường đã đặt biển này."));
        list.add(new Figure(R.drawable.c13, "Biển số 305 \"Đường dành cho người đi bộ\"", "báo đường dành cho người đi bộ. Các loại xe cơ giới và thô sơ kể cả các xe được ưu tiên theo quy định không được phép đi vào đường đã đặt biển này, trừ trường hợp đi cắt ngang qua nhưng phải đảm bảo tuyệt đối an toàn cho người đi bộ. "));
        list.add(new Figure(R.drawable.c14, "Biển số 306 \"Tốc độ tối thiểu cho phép\"", "báo tốc độ tối thiểu cho phép các xe cơ giới chạy. Biển cấm các loại xe cơ giới chạy với tốc độ nhỏ hơn trị số ghi trên biển"));
        list.add(new Figure(R.drawable.c15, "Biển số 307 \"Hết hạn chế tốc độ tối thiểu\"", "báo hết đoạn đường hạn chế tốc độ tối thiểu. Kể từ biển này các xe được phép chạy chậm hơn trị số ghi trên biển nhưng không được gây cản trở các xe khác."));
        list.add(new Figure(R.drawable.c16, "Biển số 308a \"Tuyến đường cầu vượt cắt qua\"", "biểu thị phía trước có cầu vượt, xe có thể đi thẳng hoặc theo chỉ dẫn trên hình vẽ để rẽ trái"));
        list.add(new Figure(R.drawable.c17, "Biển số 308b \"Tuyến đường cầu vượt cắt qua\"", " biểu thị phía trước có cầu vượt, xe có thể đi thẳng hoặc theo chỉ dẫn trên hình vẽ để rẽ phải"));
        list.add(new Figure(R.drawable.c18, "Biển số 309 \"Ấn còi\"", "biểu thị xe cộ đi đến vị trí cắm biển đó thì phải ấn còi."));
        list.add(new Figure(R.drawable.c19, "Biển số 310a \" Hướng đi phải theo cho các xe chở hàng nguy hiểm\"", "báo cho các loại xe chở hàng nguy hiểm phải đi theo hướng quy định (rẽ trái)"));
        list.add(new Figure(R.drawable.c20, "Biển số 310a \" Hướng đi phải theo cho các xe chở hàng nguy hiểm\"", "báo cho các loại xe chở hàng nguy hiểm phải đi theo hướng quy định (đi thẳng)"));
        list.add(new Figure(R.drawable.c21, "Biển số 310a \" Hướng đi phải theo cho các xe chở hàng nguy hiểm\"", "báo cho các loại xe chở hàng nguy hiểm phải đi theo hướng quy định (rẽ phải)"));
    }

    @Override
    public void onPause() {
        super.onPause();
        list.clear();
    }

}
