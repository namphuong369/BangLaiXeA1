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

public class Fragment_D extends Fragment {
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
        adapter = new FigureBAdapter(list, getContext());
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list.clear();
        list.add(new Figure(R.drawable.d1, "Biển số 501 \"Phạm vi tác dụng của biển\"", "Để thông báo chiều dài đoạn đường nguy hiểm hoặc cấm hoặc hạn chế bên dưới một số biển báo nguy hiểm, biển báo cấm hoặc hạn chế, chẳng hạn như: Nhiều chỗ ngoặt nguy hiểm liên tiếp; Dốc xuống nguy hiểm..."));
        list.add(new Figure(R.drawable.d2, "Biển số 502 \"Khoảng cách đến đối tượng báo hiệu\"", "Bên dưới các loại biển báo nguy hiểm, biển báo cấm, biển hiệu lệnh và chỉ dẫn, thông báo khoảng cách thực tế từ vị trí đặt biển đến đối tượng báo hiệu ở phía trước."));
        list.add(new Figure(R.drawable.d3, "Biển số 503a \"Hướng tác dụng của biển\"", "Biển số 503a đặt bên dưới các biển báo cấm, biển hiệu lệnh để chỉ hướng tác dụng của biển là hướng vuông góc với chiều đi."));
        list.add(new Figure(R.drawable.d4, "Biển số 503b \"Hướng tác dụng của biển\"", "Biển số 503b đặt bên dưới các biển báo cấm, biển hiệu lệnh để chỉ hướng tác dụng của biển là hướng vuông góc với chiều đi."));
        list.add(new Figure(R.drawable.d5, "Biển số 503c \"Hướng tác dụng của biển\"", "Biển số 503c đặt bên dưới các biển báo cấm, biển hiệu lệnh để chỉ hướng tác dụng của biển là hướng vuông góc với chiều đi."));
        list.add(new Figure(R.drawable.d6, "Biển số 503d \"Hướng tác dụng của biển\"", "Biển số 503d đặt bên dưới biển Cấm quay xe, Cấm dừng đỗ xe… để chỉ hướng tác dụng của biển là hướng song song với chiều đi."));
        list.add(new Figure(R.drawable.d7, "Biển số 503e \"Hướng tác dụng của biển\"", "Biển số 503e đặt bên dưới biển Cấm quay xe, Cấm dừng đỗ xe… để chỉ hướng tác dụng của biển là hướng song song với chiều đi."));
        list.add(new Figure(R.drawable.d8, "Biển số 503f \"Hướng tác dụng của biển\"", "Biển số 503f đặt bên dưới biển Cấm quay xe, Cấm dừng đỗ xe… để chỉ hướng tác dụng của biển là hướng song song với chiều đi."));
        list.add(new Figure(R.drawable.d9, "Biển số 504 \"Làn đường\"", "Biển số 504 được đặt bên trên làn đường và dưới các biển báo cấm và biển hiệu lệnh hay bên dưới đèn tín hiệu để chỉ làn đường chịu hiệu lực của biển báo hay đèn tín hiệu."));
        list.add(new Figure(R.drawable.d10, "Biển số 505a \"Loại xe\"", "Được đặt bên dưới các biển báo cấm và biển hiệu lệnh hay biển chỉ dẫn để chỉ loại xe chịu hiệu lực của biển báo cấm, biển hiệu lệnh hay biển chỉ dẫn. Tùy theo loại xe chịu hiệu lực mà bố trí hình vẽ cho phù hợp."));
        list.add(new Figure(R.drawable.d11, "Biển số 505b \"Loại xe hạn chế qua cầu\"", "Được đặt bên dưới biển báo số 106a “Cấm ôtô tải” để chỉ các loại xe tải chịu hiệu lực của biển báo và trọng lượng lớn nhất cho phép (bao gồm trọng lượng xe và hàng) tương ứng với mỗi loại xe không phụ thuộc vào số lượng trục."));
        list.add(new Figure(R.drawable.d12, "Biển số 505c \"Tải trọng trục hạn chế qua cầu\"", "Được đặt bên dưới biển báo số 106a “Cấm ôtô tải” để chỉ các loại xe tải có tải  trọng  trục  lớn nhất cho phép tương ứng với mỗi loại  trục (trục đơn, trục kép, trục ba)."));
        list.add(new Figure(R.drawable.d13, "Biển số 506a \"Hướng đường ưu tiên\"", "Biển số 506a  được đặt bên dưới biển chỉ dẫn số 401 trên đường ưu tiên để chỉ dẫn cho người lái xe trên đường này biết hướng đường ưu tiên ở ngã tư."));
        list.add(new Figure(R.drawable.d14, "Biển số 506b \"Hướng đường ưu tiên\"", "Biển số 506b được đặt bên dưới biển số 208 và biển số 122 trên đường không ưu tiên để chỉ dẫn cho người lái xe trên đường này biết hướng đường ưu tiên ở ngã tư."));
        list.add(new Figure(R.drawable.d15, "Biển số 507 \"Hướng rẽ\"", "Được sử dụng độc lập để báo trước cho người tham gia giao thông biết chuẩn bị đến chỗ rẽ nguy hiểm và để chỉ hướng rẽ."));
        list.add(new Figure(R.drawable.d16, "Biển số 508a \"Biểu thị thời gian\"", "Được đặt dưới biển báo cấm hoặc biển hiệu lệnh nhằm quy định phạm vi thời gian hiệu lực của các biển báo cấm, biển hiệu lệnh cho phù hợp yêu cầu."));
        list.add(new Figure(R.drawable.d17, "Biển số 508b \"Biểu thị thời gian\"", "Được đặt dưới biển báo cấm hoặc biển hiệu lệnh nhằm quy định phạm vi thời gian hiệu lực của các biển báo cấm, biển hiệu lệnh cho phù hợp yêu cầu."));
        list.add(new Figure(R.drawable.d18, "Biển số 509a \"Thuyết minh biển chính\"", "Để bổ sung cho biển số 239 \"Đường cáp điện ở phía trên\", phải đặt biển số 509a \"Chiều cao an toàn\" bên dưới biển số 239, biển này chỉ rõ chiều cao cho các phương tiện đi qua an toàn."));
        list.add(new Figure(R.drawable.d19, "Biển 509b", "Để bổ sung cho biển số 130 \"Cấm dừng, đỗ xe\", biển số 131 (a,b,c) \"Cấm đỗ xe\", phải đặt thêm biển số 509b \"Cấm đỗ xe\" bên dưới biển số 130, 131 (a,b,c)"));
    }


    @Override
    public void onPause() {
        super.onPause();
        list.clear();
    }
}
